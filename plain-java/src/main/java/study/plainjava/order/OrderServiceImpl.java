package study.plainjava.order;

import study.plainjava.discount.DiscountPolicy;
import study.plainjava.member.Member;
import study.plainjava.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    // DIP 위반, 추상화(인터페이스)뿐만 아니라 구현 클래스에도 의존하고 있다.
    // OCP 위반, 확장(기능 추가)을 하는 경우 코드를 수정해야 한다.
    // ex) 할인 정책을 변경하려면 new FixDiscountPolicy()를 new RateDiscountPolicy()로 수정해야 함.
//    private final OrderRepository orderRepository = new MemoryOrderRepository();
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // 인터페이스에만 의존하도록 하여 DIP를 지킨다. 이대로 라면 NullPointException이 발생한다.
    // 그러나 생성자를 통해 필요한 구현 객체를 '외부'(AppConfig)에서 주입받음으로써 해결한다. 이를 의존성 주입이라고 한다.
    // 다른 종류의 할인 정책이나 DB접근 객체를 사용하고 싶다면 AppConfig의 코드만 수정하면 된다.
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(OrderRepository orderRepository, MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.orderRepository = orderRepository;
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        Order order = new Order(memberId, itemName, itemPrice, discountPrice);
        orderRepository.saveOrder(order);

        return order;
    }

    @Override
    public Order findOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
