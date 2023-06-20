package study.conversiontospring;

import study.conversiontospring.member.Grade;
import study.conversiontospring.member.Member;
import study.conversiontospring.member.MemberService;
import study.conversiontospring.member.MemberServiceImpl;
import study.conversiontospring.order.Order;
import study.conversiontospring.order.OrderService;
import study.conversiontospring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.signUp(member);
        Order order = orderService.createOrder(member.getMemberId(), "3series", 50000);
        Order findOrder = orderService.findOrder(order.getOrderId());

        System.out.println("order = " + order.toString());
        System.out.println("findOrder = " + findOrder.toString());

    }
}
