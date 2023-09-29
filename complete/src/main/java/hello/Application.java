package hello;

import hello.metric.HelloCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class Application {

	private final HelloCounter helloCounter;

	@RequestMapping("/")
	public String home() {
		String s = "Hello Docker World";
		System.out.println("s = " + s);
		helloCounter.incSuccess();
		return s;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
