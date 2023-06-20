package study.conversiontospring.discount;

import study.conversiontospring.member.Grade;

public interface DiscountPolicy {
    int discount(Grade grade, int itemPrice);
}
