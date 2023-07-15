package study.componentscan_and_autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.componentscan_and_autowired.member.*;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        Member savedMember = memberService.signUp(member);
        Member foundMember = memberService.findMember(member.getMemberId());

        System.out.println("findMember = " + foundMember.toString());
        System.out.println("savedMember = " + savedMember.toString());
    }
}
