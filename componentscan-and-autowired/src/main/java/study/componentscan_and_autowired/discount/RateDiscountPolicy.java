package study.componentscan_and_autowired.discount;

import org.springframework.stereotype.Component;
import study.componentscan_and_autowired.annotation.MainDiscountPolicy;
import study.componentscan_and_autowired.member.Grade;
import study.componentscan_and_autowired.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private final double discountRate = 0.1;

    @Override
    public int discount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return (int) (itemPrice * discountRate);
        } else {
            return 0;
        }
    }
}
