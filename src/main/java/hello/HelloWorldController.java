package hello;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = {"http://localhost:9000","http://localhost:9001","http://localhost:3000","http://localhost:8080"}, maxAge = 4800, allowCredentials = "false")
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
        return "Hi There! this app is 0.1.8 version than adding codedeploy and travis ci. your name is "+String.format(template, name);
    }
}
