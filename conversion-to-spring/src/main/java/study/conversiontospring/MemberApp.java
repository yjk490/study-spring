package study.conversiontospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.conversiontospring.member.*;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        Member savedMember = memberService.signUp(member);
        Member foundMember = memberService.findMember(member.getMemberId());

        System.out.println("findMember = " + foundMember.toString());
        System.out.println("savedMember = " + savedMember.toString());
    }
}
