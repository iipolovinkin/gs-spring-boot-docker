package hello.in.scheduler;

import hello.domain.service.HelloService;
import hello.metric.HelloCounter;
import io.sentry.Sentry;
import io.sentry.event.BreadcrumbBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
@Slf4j
public class SentryTestScheduler {

    private final HelloCounter helloCounter;
    private final HelloService service;

    @Scheduled(cron = "*/10 * * * * *")
    public void scheduledCaptureException() {
        try {
            throw new IllegalArgumentException("Bad random integer 22 " + ThreadLocalRandom.current().nextInt(3));
        } catch (Exception e) {
            log.info("scheduledCaptureException():", e);
            Sentry.getContext().addTag("tag-key", "tag-value");
            Sentry.getContext().addExtra("extra-key", "extra-value");
            Sentry.capture(e);
        }
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void scheduledCaptureStringMessage() {
        Sentry.getContext().addTag("tag-key", "tag-value2");
        Sentry.getContext().addExtra("extra-key", "extra-value2");
        Sentry.capture("Bad random double" + ThreadLocalRandom.current().nextInt(1));
    }
}
