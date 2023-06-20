package study.conversiontospring.member;

public interface MemberService {
    Member signUp(Member member);
    Member findMember(Long memberId);
}
