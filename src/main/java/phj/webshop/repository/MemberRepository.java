package phj.webshop.repository;

import phj.webshop.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Member findById(String id);
    List<Member> findByName(String name);
    List<Member> findAll();
}
