package study.componentscan_and_autowired.discount;

import study.componentscan_and_autowired.member.Member;

public interface DiscountPolicy {

    // 확장성을 고려하여 Grade가 아니라 Member객체 자체를 매개변수로 받는다.
    int discount(Member member, int itemPrice);
}
