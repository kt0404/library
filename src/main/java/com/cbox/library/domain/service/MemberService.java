package com.cbox.library.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.MemberUpdateRequestForm;
import com.cbox.library.domain.form.RegisterForm;
import com.cbox.library.domain.mapper.MemberMapper;
import com.cbox.library.domain.model.Member;

@Service
public class MemberService {
    
    @Autowired
    MemberMapper memberMapper;

	public Member findByMemberId(int memberId) {
	    List<Member> list = memberMapper.find(memberId);
	    Member member = list.get(0);
		return member;
	}

	public List<Member> findAll() {
	    return memberMapper.find(null);
	}

	public boolean create(RegisterForm form) {
		String name = form.getName();
		String furigana = form.getFurigana();
		int boardId = form.getBoardId();
		String discription = form.getDiscription();
		return memberMapper.create(name, furigana, boardId, discription);
	}
	
	public boolean updateNameAndFuriganaAndBoardIdAndDiscriptionByMemberId(String name, String furigana, Integer boardId, String discription, Integer memberId) {
	    return memberMapper.update(name, furigana, boardId, discription, memberId);
	}
	
	public boolean updateDiscription(MemberUpdateRequestForm form) {
	    int memberId = form.getMemberId();
	    String discription = form.getDiscription();
	    return memberMapper.update(null, null, null, discription, memberId);
	}
	
}
