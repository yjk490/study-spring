package study.plainjava.discount;

import study.plainjava.member.Grade;
import study.plainjava.member.Member;

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
