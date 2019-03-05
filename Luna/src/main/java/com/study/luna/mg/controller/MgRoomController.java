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
	//방생성화면
	
	@Autowired
	public MgRoomService mgRoomService;
	//저장할 파일폴더
	String filePath = "C:\\Users\\JudeKim\\git\\NewLuna\\Luna\\src\\main\\webapp\\resources\\rooms\\";

	//방관리화면 
		@RequestMapping(value = "/mgRoom.mdo")
		public ModelAndView mgRoomList(RoomVO vo,@RequestParam(defaultValue="all")String searchOption,
				@RequestParam(defaultValue="")String keyword) throws Exception {
			//디렉토리 없으면 생성
			File dir = new File(filePath); 
			if (!dir.isDirectory()) {
				System.out.println("디렉토리생성");
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

	//방생성 화면
	@RequestMapping(value = "/RoomUpload.mdo", method = RequestMethod.GET)
	public String mgRoomUpload() {
		return "body/room/roomupload";
	}

	//방생성 insert
	@RequestMapping(value = "/uploadFile.mdo", method = RequestMethod.POST)
	public ModelAndView mginsertRoom(HttpServletRequest req, MultipartHttpServletRequest mrequest,
			@ModelAttribute("room") RoomVO vo) throws Exception, IllegalStateException {
		System.out.println("룸 업로드 컨트롤러 시작");
		System.out.println("파일업로드 테스트");

		// textarea 줄내림 db 인식 처리
		if (vo.getRoomExplain() == null) {
			System.out.println("상세내용 없음");
		} else {
			String roomExplain = vo.getRoomExplain().replace("\r\n", "<br>");
			vo.setRoomExplain(roomExplain);
		}
		if (vo.getRoomWarn() == null) {
			System.out.println("주의사항내용 없음");
		} else {
			String roomWarn = vo.getRoomWarn().replace("\r\n", "<br>");
			vo.setRoomWarn(roomWarn);
		}
		vo.setRoomPrice(Integer.parseInt(vo.getPrice()));
		mgRoomService.mgRoomUpload(vo);

		HttpSession session = req.getSession();
		vo.setId((String) session.getAttribute("id"));

		File dir = new File(filePath);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		// 방file insert 하기
		List<MultipartFile> mf = mrequest.getFiles("input_img");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
			System.out.println("파일이 없음");
		} else {
			System.out.println("파일 추출");
			System.out.println(mf.size());
			for (int i = 0; i < mf.size(); i++) {
					vo.setFilenum(i + 1); //파일넘버
				if (!mf.get(i).getOriginalFilename().equals("")) {
					System.out.println("포문" + i);
					// 파일 중복명 처리
					String genId = UUID.randomUUID().toString();
					// 본래 파일명
					String originalfileName = mf.get(i).getOriginalFilename();
					String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName); // Ȯ����
					// 저장되는 파일 이름
					String savePath = filePath + saveFileName; // 저장 될 파일 경로
					// long fileSize = mf.get(i).getSize(); // 파일 사이즈
					mf.get(i).transferTo(new File(savePath)); // 파일 저장

					System.out.println("오리지널이름" + originalfileName);
					System.out.println("파일사이즈 " + saveFileName);
					// System.out.println("콘텐트타입 " + fileSize);
					mgRoomService.fileUpload(originalfileName, saveFileName, vo, savePath);
				}else {
					//파일이없을때 공간확보만<jsp에서 읽어들일때 index=null 문제를 막기위한 임시예외처리>
					String originalfileName="X", saveFileName ="X",savePath="X"  ;
					mgRoomService.fileUpload(originalfileName, saveFileName, vo, savePath);
				}
			}
		}
		return new ModelAndView("redirect:/mgRoom.mdo");
	}

	//방 상세보기
	@RequestMapping(value="mgRoomView.mdo")
	public ModelAndView roomupdateView(@RequestParam int roomnum ,HttpSession session,@ModelAttribute(value="vo") RoomVO vo,@ModelAttribute(value="file") uploadfileVO file) throws Exception {
	    vo=	(RoomVO) mgRoomService.RoomRead(roomnum); //�󼼺��� �� �� ����Ȯ��
	  //줄내림 처리
	    System.out.println(vo.getRoomExplain());
	    System.out.println(vo.getRoomWarn());
	    if(vo.getRoomExplain()==null){
	    	System.out.println("상세내용 없음");
	    }else {
		String roomExplain = vo.getRoomExplain().replace( "<br>","\r\n");
		vo.setRoomExplain(roomExplain); 
	    }
	    if(vo.getRoomWarn()==null) {
	    	System.out.println("주의사항내용 없음");
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
		//화면이동 - text + file 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/room/roomupdate");
		mv.addObject("text",vo);
		mv.addObject("file", list);
		return mv;
		
	}

	// 수정하기
	@RequestMapping(value = "updateRoom.mdo")
	public ModelAndView updateRoom(HttpServletRequest req, @RequestParam int roomnum,
			MultipartHttpServletRequest mrequest, @ModelAttribute("vo") RoomVO vo)
			throws Exception, IllegalStateException {
		System.out.println("룸 업데이트 컨트롤러 시작");
		vo.setRoomnum(Integer.parseInt(req.getParameter("text1")));
		vo.setBranchName(req.getParameter("text2"));
		vo.setRoomName(req.getParameter("roomName"));
		vo.setRoomPrice(Integer.parseInt( req.getParameter("roomPrice")));
		vo.setRoomLocate(req.getParameter("roomLocate"));
		vo.setRoomEx1(req.getParameter("text6"));
		vo.setRoomEx2(req.getParameter("text7"));
		vo.setRoomEx3(req.getParameter("text8"));
		vo.setRoomEx4(req.getParameter("text9"));
		vo.setRoomExplain(req.getParameter("area1"));
		vo.setRoomWarn(req.getParameter("area2"));
		
		// textarea 줄내림 db인식 처리
		if (vo.getRoomExplain() == null) {
			System.out.println("상세내용 없음");
		} else {
			String roomExplain = vo.getRoomExplain().replace("\r\n", "<br>");
			vo.setRoomExplain(roomExplain);
		}
		if (vo.getRoomWarn() == null) {
			System.out.println("주의사항내용 없음");
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
		// 수정할시 기존 파일 삭제작업 수행해야함
		List<uploadfileVO> list = new ArrayList<uploadfileVO>();
		list = mgRoomService.RoomFile(roomnum);
		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mrequest.getFiles("input_img");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
			System.out.println("������ ����");
		} else {
			System.out.println("���� ����");
			System.out.println(mf.size());
			for (int i = 0; i < mf.size(); i++) {
				vo.setFilenum(i + 1);// 저장할 파일넘버
				if (!mf.get(i).getOriginalFilename().equals("")) {
					System.out.println("포문" + i);
					System.out.println("수정할 기존 파일 삭제작업수행");

					//파일 삭제
					File file = new File(filePath + list.get(i).getFname());
					if (file.exists() == true) {
						file.delete();
					}
					
					// 파일 중복명 처리
					String genId = UUID.randomUUID().toString();
					// 본래 파일명
					String originalfileName = mf.get(i).getOriginalFilename();
					String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName); // Ȯ����
					// 저장되는 파일 이름
					String savePath = filePath + saveFileName; // 저장 될 파일 경로
					// long fileSize = mf.get(i).getSize(); // 파일 사이즈
					mf.get(i).transferTo(new File(savePath)); // 파일 저장

					System.out.println("오리지널이름 " + originalfileName);
					System.out.println("파일사이즈 " + saveFileName);
					// System.out.println("콘텐츠타입 " + fileSize);
					mgRoomService.fileUpdate(originalfileName, saveFileName, vo, savePath);
				}
			}
		}

		return new ModelAndView("redirect:mgRoom.mdo");
	}

	// 삭제하기
	@RequestMapping(value = "deleteRoom.mdo")
	public ModelAndView roomupdateView(RoomVO vo, @RequestParam int roomnum) throws Exception {

		mgRoomService.RoomDelete(roomnum);
		// 실제 파일 삭제작업 수행해야함
		List<uploadfileVO> list = new ArrayList<uploadfileVO>();
		list = mgRoomService.RoomFile(roomnum);
		for (int i = 0; i < 5; i++) {
			// 파일 삭제
			File file = new File(filePath + list.get(i).getFname());
			if (file.exists() == true) {
				file.delete();
			}
		}
		mgRoomService.filDelete(roomnum);// 파일 경로 삭제시 실제파일 삭제 서비스 구현해야함
		return new ModelAndView("redirect:mgRoom.mdo");
	}
}
