package repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phj.webshop.domain.Member;
import phj.webshop.repository.MemberRepository;
import phj.webshop.repository.MemoryMemberRepository;
import phj.webshop.service.MemberService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberServiceTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);



    }
        @Test
        public void findByName(){
            Member member1 = new Member();
            member1.setName("spring1");
            member1.setId("kuy08");
            member1.setPw("1234");
            member1.setTel("12-34");
            member1.setAddress("부산");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            member2.setId("kuy082");
            member2.setPw("12342");
            member2.setTel("12-342");
            member2.setAddress("부산2");
            repository.save(member2);

            List<Member> result = repository.findByName("spring1");
            List<Member> result2 = repository.findByName("spring2");
            System.out.println(result.get(0));
            System.out.println(result.get(1));




    }
}