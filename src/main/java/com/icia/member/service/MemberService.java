package com.icia.member.service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public int save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO);
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO dto = memberRepository.login(memberDTO);
        if (dto != null) {
            return true;
        } else {
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        if(memberDTOList.size() == 0) {
            return null;
        } else {
            return memberDTOList;
        }
    }

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return memberRepository.findByMemberEmail(loginEmail);
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.update(memberDTO);
    }

    public void delete(Long id) {
        memberRepository.delete(id);
    }
}