package study.plainjava.order;

public interface OrderRepository {
    void saveOrder(Order order);
    Order findById(Long orderId);
}
