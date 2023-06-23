package study.plainjava.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void saveMember(Member member) {
        store.put(member.getMemberId(), member);
    }

    @Override
    public Member findById(Long memberID) {
        return store.get(memberID);
    }
}
