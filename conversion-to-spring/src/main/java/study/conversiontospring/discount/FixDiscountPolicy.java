package study.conversiontospring.discount;

import study.conversiontospring.member.Grade;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int discountAmount = 1000;

    @Override
    public int discount(Grade grade, int itemPrice) {
        if (grade == Grade.VIP) {
            return discountAmount;
        } else {
            return 0;
        }
    }
}
