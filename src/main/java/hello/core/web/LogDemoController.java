package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider;
    // private final MyLogger myLogger; 를 하면 request scope에서 에러 발생
    // ObjectProvider를 이용해 ObjectProvider.getObject()를 호출하는 시점까지 request scope 빈의 생성을 지연

    @RequestMapping("log-demo")
    @ResponseBody // 문자를 그대로 응답으로 보냄
    public String logDemo(HttpServletRequest request) { // request 정보 받아옴
        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerProvider.getObject();

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
