package study.conversiontospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.conversiontospring.discount.DiscountPolicy;
import study.conversiontospring.discount.FixDiscountPolicy;
import study.conversiontospring.member.MemberRepository;
import study.conversiontospring.member.MemberService;
import study.conversiontospring.member.MemberServiceImpl;
import study.conversiontospring.member.MemoryMemberRepository;
import study.conversiontospring.order.MemoryOrderRepository;
import study.conversiontospring.order.OrderRepository;
import study.conversiontospring.order.OrderService;
import study.conversiontospring.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    // 위와 같이 memberService와 orderService를 호출하면 MemoryMemberRepository가 두 번 생성되는데
    // 이런 경우 싱글톤 패턴이 깨지는 것 아닌가?
    // 확인해 보기 위해 plintln 메서드를 작성했다. @Bean이 등록된 메서드가 호출 될 때마다 로그를 출력한다.
    // 그렇다면 memberRepository()는 총 3번 호출되어야 한다.


    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(orderRepository(), memberRepository(), discountPolicy());
    }

    @Bean
    public OrderRepository orderRepository() {
        System.out.println("call AppConfig.orderRepository");
        return new MemoryOrderRepository();
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
        return new FixDiscountPolicy();
    }
}
