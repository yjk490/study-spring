package study.componentscan_and_autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.componentscan_and_autowired.member.Grade;
import study.componentscan_and_autowired.member.Member;
import study.componentscan_and_autowired.member.MemberService;
import study.componentscan_and_autowired.order.Order;
import study.componentscan_and_autowired.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);

        Member savedMember = memberService.signUp(new Member(1L, "memberA", Grade.VIP));
        Order savedOrder = orderService.createOrder(savedMember.getMemberId(), "3series", 50000, "rateDiscountPolicy");
        Order foundOrder = orderService.findOrder(savedOrder.getOrderId());

        System.out.println("savedOrder = " + savedOrder.toString());
        System.out.println("foundOrder = " + foundOrder.toString());
    }
}
