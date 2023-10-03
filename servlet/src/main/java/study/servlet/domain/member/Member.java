package study.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private Long id;
    // 기본형(long)이 아니라 참조형(Long)으로 선언한 이유
    // -> 최초로 Member 객체를 생성할 때는 id 필드가 null 상태이어야 하는데
    // 기본형 변수에는 null값을 가질 수 없으므로 참조형을 선언
    private String username;
    private int age;

    public Member() {}

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
