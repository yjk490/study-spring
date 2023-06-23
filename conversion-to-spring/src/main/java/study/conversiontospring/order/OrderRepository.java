package study.conversiontospring.order;

public interface OrderRepository {
    void saveOrder(Order order);
    Order findById(Long orderId);
}
