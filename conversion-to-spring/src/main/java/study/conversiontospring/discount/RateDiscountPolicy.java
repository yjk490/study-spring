package study.conversiontospring.discount;

import study.conversiontospring.member.Grade;

public class RateDiscountPolicy implements DiscountPolicy {
    private final double discountRate = 0.1;

    @Override
    public int discount(Grade grade, int itemPrice) {
        if (grade == Grade.VIP) {
            return (int) (itemPrice * discountRate);
        } else {
            return 0;
        }
    }
}
