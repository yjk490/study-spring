package study.componentscan_and_autowired.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.componentscan_and_autowired.AutoAppConfig;
import study.componentscan_and_autowired.member.Grade;
import study.componentscan_and_autowired.member.Member;
import study.componentscan_and_autowired.member.MemberService;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        orderService = ac.getBean(OrderService.class);
        memberService = ac.getBean(MemberService.class);
    }

    @Test
    void createOrder() {
        //given
        Member member = memberService.signUp(new Member(1L,"memberA", Grade.VIP));
        Long memberId = member.getMemberId();
        String itemName = "3series";
        int itemPrice = 50000;
        String discountCode = "rateDiscountPolicy";

        //when
        Order order = orderService.createOrder(memberId, itemName, itemPrice, discountCode);

        //then
        assertNotNull(order);
        assertThat(order.getMemberId()).isEqualTo(memberId);
        assertThat(order.getItemName()).isEqualTo(itemName);
        assertThat(order.getItemPrice()).isEqualTo(itemPrice);
    }

    @Test
    void findOrder() {
        //given
        Member member = memberService.signUp(new Member(1L,"memberA", Grade.VIP));
        Order order = orderService.createOrder(member.getMemberId(), "5series", 70000, "rateDiscountPolicy");

        //when
        Order foundOrder = orderService.findOrder(order.getOrderId());

        //then
        assertNotNull(foundOrder);
        assertThat(foundOrder).isEqualTo(order);
    }
}