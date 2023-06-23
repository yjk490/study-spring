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

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository(), memberRepository(), discountPolicy());
    }

    @Bean
    public OrderRepository orderRepository() {
        return new MemoryOrderRepository();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
