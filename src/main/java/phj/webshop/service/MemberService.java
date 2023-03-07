package phj.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phj.webshop.domain.Member;
import phj.webshop.repository.MemberRepository;
import phj.webshop.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public String join(Member member){ //회원가입
        //같은 이름이 있는 중복회원 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId(); //회원 아이디 반환
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
        .ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String memberId){
        return memberRepository.findById(memberId);
    }
}
