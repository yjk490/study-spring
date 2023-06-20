package study.conversiontospring;

import study.conversiontospring.discount.DiscountPolicy;
import study.conversiontospring.discount.FixDiscountPolicy;
import study.conversiontospring.discount.RateDiscountPolicy;
import study.conversiontospring.member.MemberRepository;
import study.conversiontospring.member.MemberService;
import study.conversiontospring.member.MemberServiceImpl;
import study.conversiontospring.member.MemoryMemberRepository;
import study.conversiontospring.order.MemoryOrderRepository;
import study.conversiontospring.order.OrderRepository;
import study.conversiontospring.order.OrderService;
import study.conversiontospring.order.OrderServiceImpl;

// 애플리케이션의 전체 동작 방식을 구성(config)하는 클래스이다. 구현 객체를 생성하고 연결하는 역할을 한다.
// 생성할 구현 객체가 의존하는 객체를 생성자를 통해 주입(연결)한다.
// 각 구현 객체(XXXServiceImpl or XXXRepository)는 스스로 실행하는 역할에 집중한다. 즉, 관심사를 분리했다.
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryOrderRepository(),
                                    new MemoryMemberRepository(),
                                    new RateDiscountPolicy());
    }
}
