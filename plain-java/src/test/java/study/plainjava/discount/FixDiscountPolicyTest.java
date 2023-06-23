package study.plainjava.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.plainjava.member.Grade;
import study.plainjava.member.Member;

import static org.assertj.core.api.Assertions.*;

class FixDiscountPolicyTest {

    DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("VIP는 1000원 할인이 적용된다.")
    void discountSuccess() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        int itemPrice = 50000;

        //when
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //then
        assertThat(discountPrice).isEqualTo(1000);

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