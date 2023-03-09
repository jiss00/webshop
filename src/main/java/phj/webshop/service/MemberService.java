package phj.webshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import phj.webshop.domain.Member;
import phj.webshop.repository.MemberRepository;
import phj.webshop.domain.Member;

import java.util.List;
import java.util.Optional;
public class MemberService {
    private final MemberRepository memberRepository;
    private Member member;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean login(String id,String pw){
        member= memberRepository.findById(id);
        if(pw.equals(member.getPw())) return true;
        else return false;
    }

    public String join(Member member){ //회원가입
        //같은 아이디 있는 중복회원 X
        duplicate_id(member);
        memberRepository.save(member);
        return member.getId(); //회원 아이디 반환
    }

    private void duplicate_id(Member member) {
        memberRepository.findById(member.getId());
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(String memberId){
        return memberRepository.findById(memberId);
    }
}
