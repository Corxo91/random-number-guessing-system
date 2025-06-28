package santana.marcos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "random-number-guessing-provider")
public interface ProviderClient {
    @PostMapping("/api/guess")
    String guess(@RequestParam("number") int number);
}