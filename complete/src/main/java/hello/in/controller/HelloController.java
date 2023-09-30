package hello.in.controller;

import hello.metric.HelloCounter;
import hello.domain.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private final HelloCounter helloCounter;
    private final HelloService service;

    @RequestMapping("/")
    public String home() {

        String s = service.sayHello();
        log.info("home: s: {}", s);
        helloCounter.incSuccess();
        return s;
    }
}
