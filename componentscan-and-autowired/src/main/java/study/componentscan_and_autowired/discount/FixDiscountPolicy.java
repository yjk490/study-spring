package study.componentscan_and_autowired.discount;

import org.springframework.stereotype.Component;
import study.componentscan_and_autowired.member.Grade;
import study.componentscan_and_autowired.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountAmount = 1000;

    @Override
    public int discount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return discountAmount;
        } else {
            return 0;
        }
    }
}
