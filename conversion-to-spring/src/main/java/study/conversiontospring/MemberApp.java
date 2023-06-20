package study.conversiontospring;

import study.conversiontospring.member.*;

public class MemberApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();

        // AppConfig를 통해 의존성 주입, 관심사 분리
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        Member savedMember = memberService.signUp(member);
        Member foundMember = memberService.findMember(member.getMemberId());

        System.out.println("findMember = " + foundMember.toString());
        System.out.println("savedMember = " + savedMember.toString());
    }
}
