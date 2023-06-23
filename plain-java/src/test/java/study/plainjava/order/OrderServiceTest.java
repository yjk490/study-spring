package study.plainjava.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.plainjava.AppConfig;
import study.plainjava.member.Grade;
import study.plainjava.member.Member;
import study.plainjava.member.MemberService;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
    }

    @Test
    void createOrder() {
        //given
        Member member = memberService.signUp(new Member(1L,"memberA", Grade.VIP));
        Long memberId = member.getMemberId();
        String itemName = "3series";
        int itemPrice = 50000;

        //when
        Order order = orderService.createOrder(memberId, itemName, itemPrice);

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
        Order order = orderService.createOrder(member.getMemberId(), "5series", 70000);

        //when
        Order foundOrder = orderService.findOrder(order.getOrderId());

        //then
        assertNotNull(foundOrder);
        assertThat(foundOrder).isEqualTo(order);
    }
}