package study.itemservice.domain.item;

import lombok.Data;

@Data
public class Item {

    // id, price, quantity의 타입이 래퍼 객체인 이유
    // -> 최초로 객체를 생성할 때는 id 값이 null 상태이거나 price(가격)이 존재하지 않는 경우를 표현해야하는데 0으로 표현하기는 모호하기 때문이다.
    // 그런데 기본형 변수는 null을 가질 수 없기 때문에 래퍼 객체를 사용한다.
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {}

    public Item(Long id) {}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
