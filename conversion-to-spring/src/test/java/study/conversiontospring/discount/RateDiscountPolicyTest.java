package study.conversiontospring.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.conversiontospring.member.Grade;
import study.conversiontospring.member.Member;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void discountSuccess() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        int itemPrice = 50000;

        //when
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //then
        assertThat(discountPrice).isEqualTo((int) (itemPrice * 0.1));
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않는다.")
    void discountFail() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);
        int itemPrice = 50000;

        //when
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}