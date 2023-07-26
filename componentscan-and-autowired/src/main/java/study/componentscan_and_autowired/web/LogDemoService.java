package study.componentscan_and_autowired.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.componentscan_and_autowired.common.MyLogger;

@Service
public class LogDemoService {
    private final MyLogger myLogger;

    @Autowired
    public LogDemoService(MyLogger myLogger) {
        this.myLogger = myLogger;
    }

    public void logic(String testId) {
        myLogger.log("Service id = " + testId);
    }
}
