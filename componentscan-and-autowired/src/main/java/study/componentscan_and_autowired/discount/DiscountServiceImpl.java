package study.componentscan_and_autowired.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.componentscan_and_autowired.member.Member;

import java.util.List;
import java.util.Map;

@Component
public class DiscountServiceImpl implements DiscountService {
    private final Map<String, DiscountPolicy> policyMap;
    private final List<DiscountPolicy> policyList;

    @Autowired
    public DiscountServiceImpl(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
        this.policyMap = policyMap;
        this.policyList = policyList;
    }

    @Override
    public int discount(Member member, int price, String discountCode) {
        DiscountPolicy discountPolicy = policyMap.get(discountCode);
        return discountPolicy.discount(member, price);
    }
}
