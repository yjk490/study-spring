package study.componentscan_and_autowired.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    // requestURL은 빈이 생성되는 시점에는 알 수 없으므로 외부에서 주입받는다.
    // request 스코프의 빈이 HTTP 요청시에 생성되는 것은 맞지만 request 정보를 받고나서 생성되는 것은 아니므로
    // 빈 생성 시점에 requestURL을 알 수 없다.
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "] [" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean destroy : " + this);
    }
}
