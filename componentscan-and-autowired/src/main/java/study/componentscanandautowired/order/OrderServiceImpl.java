package study.componentscanandautowired.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.componentscanandautowired.discount.DiscountPolicy;
import study.componentscanandautowired.member.Member;
import study.componentscanandautowired.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
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

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
