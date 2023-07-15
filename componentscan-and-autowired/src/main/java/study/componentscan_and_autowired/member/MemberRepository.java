package study.componentscan_and_autowired.member;

public interface MemberRepository {
    void saveMember(Member member);
    Member findById(Long memberID);

}
