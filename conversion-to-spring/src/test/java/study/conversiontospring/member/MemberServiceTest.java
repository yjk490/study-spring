package study.conversiontospring.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.conversiontospring.AppConfig;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void signUp() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        Member savedMember = memberService.signUp(member);

        //then
        assertNotNull(savedMember);
        assertThat(savedMember).isEqualTo(member);
    }

    @Test
    void findMember() {
        //given
        Member savedMember = memberService.signUp(new Member(1L, "memberA", Grade.BASIC));
        Long memberId = savedMember.getMemberId();

        //when
        Member foundMember = memberService.findMember(memberId);

        //then
        assertNotNull(foundMember);
        assertThat(foundMember).isEqualTo(savedMember);
    }
}