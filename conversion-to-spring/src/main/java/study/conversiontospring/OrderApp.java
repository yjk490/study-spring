package study.conversiontospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.conversiontospring.member.Grade;
import study.conversiontospring.member.Member;
import study.conversiontospring.member.MemberService;
import study.conversiontospring.order.Order;
import study.conversiontospring.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Member savedMember = memberService.signUp(new Member(1L, "memberA", Grade.VIP));
        Order savedOrder = orderService.createOrder(savedMember.getMemberId(), "3series", 50000);
        Order foundOrder = orderService.findOrder(savedOrder.getOrderId());

        System.out.println("savedOrder = " + savedOrder.toString());
        System.out.println("foundOrder = " + foundOrder.toString());
    }
}
