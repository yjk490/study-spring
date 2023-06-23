package study.plainjava.discount;

import study.plainjava.member.Grade;
import study.plainjava.member.Member;

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
