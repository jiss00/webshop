package phj.webshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import phj.webshop.repository.MemberRepository;
import phj.webshop.repository.MemoryMemberRepository;
import phj.webshop.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
