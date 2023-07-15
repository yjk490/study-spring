package study.componentscan_and_autowired.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.componentscan_and_autowired.annotation.MainDiscountPolicy;
import study.componentscan_and_autowired.discount.DiscountPolicy;
import study.componentscan_and_autowired.discount.DiscountService;
import study.componentscan_and_autowired.member.Member;
import study.componentscan_and_autowired.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final DiscountService discountService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, MemberRepository memberRepository, DiscountService discountService) {
        this.orderRepository = orderRepository;
        this.memberRepository = memberRepository;
        this.discountService = discountService;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice, String discountCode) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountService.discount(member, itemPrice, discountCode);

        Order order = new Order(memberId, itemName, itemPrice, discountPrice);
        orderRepository.saveOrder(order);

        return order;
    }

    @Override
    public Order findOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
