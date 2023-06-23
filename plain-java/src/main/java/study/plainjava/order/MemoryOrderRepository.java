package study.plainjava.order;

import java.util.HashMap;
import java.util.Map;

public class MemoryOrderRepository implements OrderRepository {
    private static Map<Long, Order> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void saveOrder(Order order) {
        order.setOrderId(++sequence);
        store.put(order.getOrderId(), order);
    }

    @Override
    public Order findById(Long orderId) {
        return store.get(orderId);
    }
}
