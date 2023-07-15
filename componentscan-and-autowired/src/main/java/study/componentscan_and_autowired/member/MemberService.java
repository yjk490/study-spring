package study.componentscan_and_autowired.member;

public interface MemberService {
    Member signUp(Member member);
    Member findMember(Long memberId);
}
