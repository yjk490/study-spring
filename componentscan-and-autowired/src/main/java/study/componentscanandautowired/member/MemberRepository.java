package study.componentscanandautowired.member;

public interface MemberRepository {
    void saveMember(Member member);
    Member findById(Long memberID);

}
