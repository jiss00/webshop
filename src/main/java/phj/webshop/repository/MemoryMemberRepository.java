package phj.webshop.repository;

import phj.webshop.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<String,Member> store = new HashMap<>();
    @Override
    public Member save(Member member) {
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Member findById(String id) {
        return store.get(id);
    }

    @Override
    public List<Member> findByName(String name) {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
