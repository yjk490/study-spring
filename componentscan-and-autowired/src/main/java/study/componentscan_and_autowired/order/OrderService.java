package study.componentscan_and_autowired.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice, String discountCode);
    Order findOrder(Long orderId);
}
