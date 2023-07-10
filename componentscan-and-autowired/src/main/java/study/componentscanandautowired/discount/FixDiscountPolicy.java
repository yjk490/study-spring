package study.componentscanandautowired.discount;

import study.componentscanandautowired.member.Grade;
import study.componentscanandautowired.member.Member;

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
