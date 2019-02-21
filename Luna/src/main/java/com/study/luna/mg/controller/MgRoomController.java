package com.study.luna.mg.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.RoomVO;
import com.study.luna.mg.model.uploadfileVO;
import com.study.luna.mg.service.MgRoomService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

@Controller
public class MgRoomController {
	//�����ȭ��
	
	@Autowired
	public MgRoomService mgRoomService;
	// ������ ��������
	String filePath = "C:\\myProject\\mySpring\\main.zip_expanded\\Luna\\src\\main\\webapp\\resources\\manager\\file\\";

	// ����� ȭ��
		@RequestMapping(value = "/mgRoom.mdo")
		public ModelAndView mgRoomList(RoomVO vo,@RequestParam(defaultValue="roomName")String searchOption,
				@RequestParam(defaultValue="")String keyword) throws Exception {
			// ���丮���� 
			File dir = new File(filePath); 
			if (!dir.isDirectory()) {
				System.out.println("���丮����");
				dir.mkdirs();
			}

			List<RoomVO> list = mgRoomService.RoomList(vo,searchOption,keyword);
			
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("list", list); 
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("body/room/mgRoom");
			mv.addObject("map", map);

			System.out.println("list" + map.toString());
			System.out.println("mv" + mv.toString());
			return mv;
		}

	// �� ���� ȭ��
	@RequestMapping(value = "/RoomUpload.mdo", method = RequestMethod.GET)
	public String mgRoomUpload() {
		return "body/room/roomupload";
	}

	// ����� insert
	@RequestMapping(value = "/uploadFile.mdo", method = RequestMethod.POST)
	public ModelAndView mginsertRoom(HttpServletRequest req, MultipartHttpServletRequest mrequest,
			@ModelAttribute("room") RoomVO vo) throws Exception, IllegalStateException {
		System.out.println("�� ���ε� ��Ʈ�ѷ� ����");
		System.out.println("���Ͼ��ε��׽�Ʈ");

		// textarea �ٳ��� db�ν� ó��
		if (vo.getRoomExplain() == null) {
			System.out.println("�󼼳��� ����");
		} else {
			String roomExplain = vo.getRoomExplain().replace("\r\n", "<br>");
			vo.setRoomExplain(roomExplain);
		}
		if (vo.getRoomWarn() == null) {
			System.out.println("���ǻ��׳��� ����");
		} else {
			String roomWarn = vo.getRoomWarn().replace("\r\n", "<br>");
			vo.setRoomWarn(roomWarn);
		}
		mgRoomService.mgRoomUpload(vo);

		HttpSession session = req.getSession();
		vo.setId((String) session.getAttribute("id"));

		File dir = new File(filePath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		// �Ѿ�� ������ ����Ʈ�� ����
		List<MultipartFile> mf = mrequest.getFiles("input_img");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
			System.out.println("������ ����");
		} else {
			System.out.println("���� ����");
			System.out.println(mf.size());
			for (int i = 0; i < mf.size(); i++) {
					vo.setFilenum(i + 1); //���ϳѹ� 
				if (!mf.get(i).getOriginalFilename().equals("")) {
					System.out.println("����" + i);
					// ���� �ߺ��� ó��
					String genId = UUID.randomUUID().toString();
					// ���� ���ϸ�
					String originalfileName = mf.get(i).getOriginalFilename();
					String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName); // Ȯ����
					// ����Ǵ� ���� �̸�
					String savePath = filePath + saveFileName; // ���� �� ���� ���
					// long fileSize = mf.get(i).getSize(); // ���� ������
					mf.get(i).transferTo(new File(savePath)); // ���� ����

					System.out.println("���������̸� " + originalfileName);
					System.out.println("���ϻ����� " + saveFileName);
					// System.out.println("������Ÿ�� " + fileSize);
					mgRoomService.fileUpload(originalfileName, saveFileName, vo, savePath);
				}else {
					//�����̾����� ����Ȯ����<jsp���� �о���϶� index=null ������ �������� �ӽÿ���ó��>
					String originalfileName="X", saveFileName ="X",savePath="X"  ;
					mgRoomService.fileUpload(originalfileName, saveFileName, vo, savePath);
				}
			}
		}
		return new ModelAndView("redirect:mgRoom.mdo");
	}

	// �� �󼼺���
	@RequestMapping(value="mgRoomView.mdo")
	public ModelAndView roomupdateView(@RequestParam int roomnum ,HttpSession session,@ModelAttribute(value="vo") RoomVO vo,@ModelAttribute(value="file") uploadfileVO file) throws Exception {
	    vo=	(RoomVO) mgRoomService.RoomRead(roomnum); //�󼼺��� �� �� ����Ȯ��
	    //�ٳ��� ó��
	    System.out.println(vo.getRoomExplain());
	    System.out.println(vo.getRoomWarn());
	    if(vo.getRoomExplain()==null){
	    	System.out.println("�󼼳��� ����");
	    }else {
		String roomExplain = vo.getRoomExplain().replace( "<br>","\r\n");
		vo.setRoomExplain(roomExplain); 
	    }
	    if(vo.getRoomWarn()==null) {
	    System.out.println("���ǻ��׳��� ����");
	    }else {
		String roomWarn = vo.getRoomWarn().replace( "<br>","\r\n");
		vo.setRoomWarn(roomWarn);
	    } 
		List<uploadfileVO> list = new ArrayList<uploadfileVO>(/*Collections.nCopies(5 , file)*/);
		list= mgRoomService.RoomFile(roomnum); 
/*		for(int i=0; i<5; i++) {
			if(list.get(i).getFname()==null) {
				list.add(i).
			}
		}*/
		//ȭ���̵� - text + file 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/room/roomupdate");
		mv.addObject("text",vo);
		mv.addObject("file", list);
		return mv;
		
	}

	// �����ϱ�
	@RequestMapping(value = "updateRoom.mdo")
	public ModelAndView updateRoom(HttpServletRequest req, @RequestParam int roomnum,
			MultipartHttpServletRequest mrequest, @ModelAttribute("vo") RoomVO vo)
			throws Exception, IllegalStateException {
		System.out.println("�� ������Ʈ ��Ʈ�ѷ� ����");
		vo.setRoomnum(Integer.parseInt(req.getParameter("text1")));
		vo.setBranchName(req.getParameter("text2"));
		vo.setRoomName(req.getParameter("roomName"));
		vo.setInown(req.getParameter("text4"));
		vo.setJoosu(req.getParameter("text5"));
		vo.setRoomEx1(req.getParameter("text6"));
		vo.setRoomEx2(req.getParameter("text7"));
		vo.setRoomEx3(req.getParameter("text8"));
		vo.setRoomEx4(req.getParameter("text9"));
		vo.setRoomExplain(req.getParameter("area1"));
		vo.setRoomWarn(req.getParameter("area2"));
		
		// textarea �ٳ��� db�ν� ó��
		if (vo.getRoomExplain() == null) {
			System.out.println("�󼼳��� ����");
		} else {
			String roomExplain = vo.getRoomExplain().replace("\r\n", "<br>");
			vo.setRoomExplain(roomExplain);
		}
		if (vo.getRoomWarn() == null) {
			System.out.println("���ǻ��׳��� ����");
		} else {
			String roomWarn = vo.getRoomWarn().replace("\r\n", "<br>");
			vo.setRoomWarn(roomWarn);
		}
		vo.setRoomnum(roomnum); 
		mgRoomService.mgRoomUpdate(vo);

		HttpSession session = req.getSession();
		vo.setId((String) session.getAttribute("id"));
		File dir = new File(filePath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		// �����ҽ� ���� ���� �����۾� �����ؾ���
		List<uploadfileVO> list = new ArrayList<uploadfileVO>();
		list = mgRoomService.RoomFile(roomnum);
		// �Ѿ�� ������ ����Ʈ�� ����
		List<MultipartFile> mf = mrequest.getFiles("input_img");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
			System.out.println("������ ����");
		} else {
			System.out.println("���� ����");
			System.out.println(mf.size());
			for (int i = 0; i < mf.size(); i++) {
				vo.setFilenum(i + 1);// ������ ���ϳѹ�
				if (!mf.get(i).getOriginalFilename().equals("")) {
					System.out.println("����" + i);
					System.out.println("������ ���� ���� �����۾�����");

					// ���� ����
					File file = new File(filePath + list.get(i).getFname());
					if (file.exists() == true) {
						file.delete();
					}
					
					// ���� �ߺ��� ó��
					String genId = UUID.randomUUID().toString();
					// ���� ���ϸ�
					String originalfileName = mf.get(i).getOriginalFilename();
					String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName); // Ȯ����
					// ����Ǵ� ���� �̸�
					String savePath = filePath + saveFileName; // ���� �� ���� ���
					// long fileSize = mf.get(i).getSize(); // ���� ������
					mf.get(i).transferTo(new File(savePath)); // ���� ����

					System.out.println("���������̸� " + originalfileName);
					System.out.println("���ϻ����� " + saveFileName);
					// System.out.println("������Ÿ�� " + fileSize);
					mgRoomService.fileUpdate(originalfileName, saveFileName, vo, savePath);
				}
			}
		}

		return new ModelAndView("redirect:mgRoom.mdo");
	}

	// �����ϱ�
	@RequestMapping(value = "deleteRoom.mdo")
	public ModelAndView roomupdateView(RoomVO vo, @RequestParam int roomnum) throws Exception {

		mgRoomService.RoomDelete(roomnum);
		// ���� ���� �����۾� �����ؾ���
		List<uploadfileVO> list = new ArrayList<uploadfileVO>();
		list = mgRoomService.RoomFile(roomnum);
		for (int i = 0; i < 5; i++) {
			// ���� ����
			File file = new File(filePath + list.get(i).getFname());
			if (file.exists() == true) {
				file.delete();
			}
		}
		mgRoomService.filDelete(roomnum);// ���� ��� ������ �������� ���� ���� �����ؾ���
		return new ModelAndView("redirect:mgRoom.mdo");
	}
}
