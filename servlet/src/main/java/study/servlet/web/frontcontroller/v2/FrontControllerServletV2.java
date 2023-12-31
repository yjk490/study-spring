package study.servlet.web.frontcontroller.v2;

import study.servlet.web.frontcontroller.MyView;
import study.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import study.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import study.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV2 controllerV2 = controllerMap.get(requestURI);
        if (controllerV2 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controllerV2.process(request, response);
        myView.render(request, response);
    }
}
