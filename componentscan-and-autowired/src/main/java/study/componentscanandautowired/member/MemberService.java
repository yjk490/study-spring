package study.componentscanandautowired.member;

public interface MemberService {
    Member signUp(Member member);
    Member findMember(Long memberId);
}
