package study.componentscan_and_autowired.discount;

import study.componentscan_and_autowired.member.Member;

public interface DiscountService {
    int discount(Member member, int price, String discountCode);
}
