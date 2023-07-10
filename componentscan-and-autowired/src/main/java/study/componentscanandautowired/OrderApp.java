package study.componentscanandautowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.componentscanandautowired.member.Grade;
import study.componentscanandautowired.member.Member;
import study.componentscanandautowired.member.MemberService;
import study.componentscanandautowired.order.Order;
import study.componentscanandautowired.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        Member savedMember = memberService.signUp(new Member(1L, "memberA", Grade.VIP));
        Order savedOrder = orderService.createOrder(savedMember.getMemberId(), "3series", 50000);
        Order foundOrder = orderService.findOrder(savedOrder.getOrderId());

        System.out.println("savedOrder = " + savedOrder.toString());
        System.out.println("foundOrder = " + foundOrder.toString());
    }
}
