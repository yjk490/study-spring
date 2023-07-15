package study.componentscan_and_autowired.order;

public interface OrderRepository {
    void saveOrder(Order order);
    Order findById(Long orderId);
}
