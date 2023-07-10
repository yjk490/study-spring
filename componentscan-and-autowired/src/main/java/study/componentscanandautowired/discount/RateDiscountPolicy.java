package study.componentscanandautowired.discount;

import org.springframework.stereotype.Component;
import study.componentscanandautowired.member.Grade;
import study.componentscanandautowired.member.Member;

@Component
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
