package study.componentscan_and_autowired.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import study.componentscan_and_autowired.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @Autowired
    public LogDemoController(LogDemoService logDemoService, MyLogger myLogger) {
        this.logDemoService = logDemoService;
        this.myLogger = myLogger;
    }

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("Controller test");
        logDemoService.logic("testId-A");

        return "OK " + myLogger.toString();
    }
}
