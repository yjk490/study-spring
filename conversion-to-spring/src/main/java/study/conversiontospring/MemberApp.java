package study.conversiontospring;

import study.conversiontospring.member.*;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.signUp(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("findMember = " + findMember.toString());
        System.out.println("member = " + member.toString());

    }
}
