package study.plainjava;

import study.plainjava.discount.DiscountPolicy;
import study.plainjava.discount.FixDiscountPolicy;
import study.plainjava.member.MemberRepository;
import study.plainjava.member.MemberService;
import study.plainjava.member.MemberServiceImpl;
import study.plainjava.member.MemoryMemberRepository;
import study.plainjava.order.MemoryOrderRepository;
import study.plainjava.order.OrderRepository;
import study.plainjava.order.OrderService;
import study.plainjava.order.OrderServiceImpl;

// 애플리케이션의 전체 동작 방식을 구성(config)하는 클래스이다. 구현 객체를 생성하고 연결하는 역할을 한다.
// 생성할 구현 객체가 의존하는 객체를 생성자를 통해 주입(연결)한다.
// 각 구현 객체(XXXServiceImpl or XXXRepository)는 스스로 실행하는 역할에 집중한다. 즉, 관심사를 분리했다.
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository(), memberRepository(), discountPolicy());
    }

    public OrderRepository orderRepository() {
        return new MemoryOrderRepository();
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
