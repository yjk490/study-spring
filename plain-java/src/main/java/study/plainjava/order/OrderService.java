package study.plainjava.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    Order findOrder(Long orderId);
}
