package study.conversiontospring.order;

import org.junit.jupiter.api.Test;
import study.conversiontospring.member.Grade;
import study.conversiontospring.member.Member;
import study.conversiontospring.member.MemberService;
import study.conversiontospring.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void createOrder() {
        //given
        Member member = new Member(1L,"memberA", Grade.VIP);
        Member savedMember = memberService.signUp(member);
        Long memberId = savedMember.getMemberId();
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
        Member member = new Member(1L,"memberA", Grade.VIP);
        Member savedMember = memberService.signUp(member);
        Order order = orderService.createOrder(savedMember.getMemberId(), "5series", 70000);

        //when
        Order foundOrder = orderService.findOrder(order.getOrderId());

        //then
        assertThat(foundOrder).isEqualTo(order);
    }
}