package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;

public interface MemberDAO {
	public List<MemberCommand> memberList(MemberCommand mc);
}
