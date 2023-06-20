package study.conversiontospring.member;

public class MemberServiceImpl implements MemberService {
    // DIP 위반, 추상화에 의존해야 하는데 구현체도 의존하고 있음
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Member signUp(Member member) {
        memberRepository.saveMember(member);

        return member;
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
