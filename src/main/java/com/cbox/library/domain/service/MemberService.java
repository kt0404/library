package com.cbox.library.domain.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.RegisterForm;
import com.cbox.library.domain.mapper.MemberMapper;
import com.cbox.library.domain.form.MemberUpdateRequestForm;
import com.cbox.library.domain.model.Member;
import com.cbox.library.domain.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;
    
	@Autowired
	MemberRepository memberRepository;
	
	public Member findById(int id) {
	    return memberMapper.findById(id);
	}

	public Member findOne(int id) {
		Map<String, Object> map = memberRepository.findOne(id);
		if (map == null)
			return null;
		Member member = new Member();
		member.setId((Integer) map.get("id"));
		member.setName((String) map.get("name"));
		member.setFurigana((String) map.get("furigana"));
		member.setBoardId((Integer) map.get("board_id"));
		member.setDiscription((String) map.get("discription"));
		member.setCreatedAt((Timestamp) map.get("created_at"));
		member.setUpdatedAt((Timestamp) map.get("updated_at"));
		return member;
	}

	public List<Member> findAll() {
		List<Member> result = new ArrayList<>();
		List<Map<String, Object>> tmpList = memberRepository.findAll();
		for (Map<String, Object> map : tmpList) {
			Member member = new Member();
			member.setId((Integer) map.get("id"));
			member.setName((String) map.get("name"));
			member.setFurigana((String) map.get("furigana"));
			member.setBoardId((Integer) map.get("board_id"));
			member.setDiscription((String) map.get("discription"));
			member.setCreatedAt((Timestamp) map.get("created_at"));
			member.setUpdatedAt((Timestamp) map.get("updated_at"));
			result.add(member);
		}
		return result;
	}

	public int create(RegisterForm form) {
		String name = form.getName();
		String furigana = form.getFurigana();
		int boardId = form.getBoardId();
		String discription = form.getDiscription();
		return memberRepository.create(name, furigana, boardId, discription);
	}
	
	public boolean updateNameAndFuriganaAndBoardIdAndDiscriptionById(String name, String furigana, int boardId, String discription, int memberId) {
	    return memberMapper.updateNameAndFuriganaAndBoardIdAndDiscriptionById(name, furigana, boardId, discription, memberId);
	}
	
	public int updateDiscription(MemberUpdateRequestForm form) {
	    int id = form.getMemberId();
	    String discription = form.getDiscription();
	    return memberRepository.updateDiscription(id, discription);
	}
	
	public List<Member> testFindAll() {
	    return memberMapper.findAll();
	}
}
