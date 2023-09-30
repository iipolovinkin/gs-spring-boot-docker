package hello.domain.service.impl;

import hello.domain.service.HelloService;
import io.sentry.Sentry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        try {
            return "Hello Docker World";
        } catch (Exception e) {
            log.info("sayHello: e: {}", e);
            Sentry.capture(e);
        }
        return "temporary unavailable";
    }
}
