package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data"); // 문자 타입 조회
        Integer integerValue = Integer.valueOf(data);
        System.out.println("integerValue = " + integerValue);

        return "OK";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam("data") Integer data) {
        System.out.println("integerValue = " + data);

        return "OK";
    }

    @GetMapping("/hello-v3")
    public String helloV3(@RequestParam("ipPort") IpPort ipPort) {
        System.out.println("ipPort = " + ipPort);

        return "OK";
    }
}
