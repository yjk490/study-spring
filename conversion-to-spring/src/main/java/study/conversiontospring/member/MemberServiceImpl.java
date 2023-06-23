package study.conversiontospring.member;

public class MemberServiceImpl implements MemberService {
    // DIP 위반, 추상화(인터페이스)뿐만 아니라 구현 클래스에도 의존하고 있다.
    // OCP 위반, 확장(기능 추가)을 하는 경우 코드를 수정해야 한다.
    // ex) 할인 정책을 변경하려면 new FixDiscountPolicy()를 new RateDiscountPolicy()로 수정해야 함.
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 인터페이스에만 의존하도록 하여 DIP를 준수한다. 이대로 라면 NullPointException이 발생한다.
    // 그러나 생성자를 통해 필요한 구현 객체를 '외부'(AppConfig)에서 주입받음으로써 해결한다. 이를 의존성 주입이라고 한다.
    // 다른 종류의 할인 정책이나 DB접근 객체를 사용하고 싶다면 AppConfig에서 설정하면 된다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
