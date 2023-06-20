package study.conversiontospring.order;

import study.conversiontospring.discount.DiscountPolicy;
import study.conversiontospring.discount.FixDiscountPolicy;
import study.conversiontospring.member.Member;
import study.conversiontospring.member.MemberRepository;
import study.conversiontospring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository = new MemoryOrderRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member.getGrade(), itemPrice);

        Order order = new Order(memberId, itemName, itemPrice, discountPrice);
        orderRepository.saveOrder(order);

        return order;
    }

    @Override
    public Order findOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
