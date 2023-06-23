package study.plainjava.member;

public interface MemberService {
    Member signUp(Member member);
    Member findMember(Long memberId);
}
