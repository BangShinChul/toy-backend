package rest.controller;

import rest.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/main")
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
        return "ver 0.1.12 - 181117";
    }
}
