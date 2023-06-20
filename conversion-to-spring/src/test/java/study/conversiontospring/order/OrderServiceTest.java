package study.conversiontospring.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.conversiontospring.AppConfig;
import study.conversiontospring.member.Grade;
import study.conversiontospring.member.Member;
import study.conversiontospring.member.MemberService;
import study.conversiontospring.member.MemberServiceImpl;

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