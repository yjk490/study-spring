package study.conversiontospring;

import study.conversiontospring.member.Grade;
import study.conversiontospring.member.Member;
import study.conversiontospring.member.MemberService;
import study.conversiontospring.order.Order;
import study.conversiontospring.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        // AppConfig를 통해 의존성 주입, 관심사 분리
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member savedMember = memberService.signUp(new Member(1L, "memberA", Grade.VIP));
        Order savedOrder = orderService.createOrder(savedMember.getMemberId(), "3series", 50000);
        Order foundOrder = orderService.findOrder(savedOrder.getOrderId());

        System.out.println("order = " + savedOrder.toString());
        System.out.println("findOrder = " + foundOrder.toString());

    }
}
