package study.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import study.springmvc.basic.HelloData;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age =Integer.parseInt(request.getParameter("age"));
        log.info("username = {} age = {}",username, age);

        response.getWriter().write("ok");
    }

    // 클래스 레벨에 @Controller를 붙이면 반환되는 문자열로 뷰를 찾지만 메서드 레벨에 @ResponseBody가 붙어있으면 반환값을 http응답 메세지에 담는다.
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {
        log.info("username = {} age = {}",memberName, memberAge);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")   // Http 파라미터 이름이 변수명과 같으면 @RequestParam의 name 생략 가능
    public String requestParamV3(@RequestParam String username, @RequestParam int age) {
        log.info("username = {} age = {}",username, age);
        return "OK";
    }

    @ResponseBody   // 파라미터가 기본자료형이면 @RequestParam 자체를 생략 가능
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username = {} age = {}",username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        // @RequestParam(required = false) int age 로 작성하고 요청파라미터에 age를 포함하지 않으면 오류가 발생한다.
        // int형은 null을 담을 수 없기 때문이다.
        log.info("username = {} age = {}",username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, // 요청 파라미터값이 빈문자열("")로 와도 기본값을 저장한다.
            @RequestParam(required = false, defaultValue = "-1") Integer age) {
        log.info("username = {} age = {}",username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String , Object> paramMap) {
        log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("{}",helloData);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("{}",helloData);
        return "ok";
    }
}
