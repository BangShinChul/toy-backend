package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = {"http://localhost:9000","http://localhost:9001","http://localhost:3000","http://localhost:80", "http://bangshinchul.com", "http://rest.bangshinchul.com:9000"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class HelloWorldController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue = "Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/")
    @ResponseBody
    public String defaultHello(@RequestParam(name="name", required=false, defaultValue = "Stranger") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return "안녕하세요! 해당 RESTful api는 0.1.8 버전이며, Spring Boot Gradle로 제작하였습니다. 배포는 AWS CodeDeploy & Travis CI로 자동화 하였습니다. 현재 프론트엔드는 s3에 배포되어 있습니다. 18.08.02";
    }
}
