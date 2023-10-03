package study.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
    private Map<Long, Member> store = new HashMap<>();
    private long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    /**
     * store.values()는 hashmap에 저장된 Member객체를 컬렉션 형태로 반환한다.
     * 그래서 findAll()에서 store.values()를 그대로 반환하면 Repository에 저장된 Member객체에 직접 접근할 수 있다.
     * 따라서, 이를 방지하기 위해 ArrayList로 복사하여 반환한다.
     * @return
     */
    public List<Member> findAll() { return new ArrayList<>(store.values()); }

    public void clearStroe() {
        store.clear();
    }
}
