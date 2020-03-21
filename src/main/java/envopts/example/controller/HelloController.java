package envopts.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * Example controller that responds with hello messages.
 */
@RestController
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    /**
     * Gets a hello message.
     *
     * @param name name of the recipient
     * @return an HTTP 200 response containing a hello message
     */
    @GetMapping(value = "/hello",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<?>> sayHello(@RequestParam(value = "name", required = false, defaultValue = "You") String name) {
        return Mono.fromSupplier(() -> {
            LOG.info("Received hello request for: {}", name);

            final String message = String.format("Hello, %s!", name);

            Map<String, String> body = new HashMap<>();
            body.put("message", message);

            LOG.info("Sending hello message: {}", message);

            return ResponseEntity.ok(body);
        });
    }
}
