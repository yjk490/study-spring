package study.componentscan_and_autowired.scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.componentscan_and_autowired.AutoAppConfig;
import study.componentscan_and_autowired.order.OrderService;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        OrderService orderService = ac.getBean(OrderService.class);

        assertThat(orderService).isInstanceOf(OrderService.class);
    }
}
