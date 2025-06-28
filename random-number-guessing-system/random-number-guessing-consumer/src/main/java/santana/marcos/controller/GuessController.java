package santana.marcos.controller;

import santana.marcos.service.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess")
public class GuessController {
    @Autowired
    private GuessService guessService;

    @PostMapping
    public String guess(@RequestParam int number) {
        return guessService.guess(number);
    }
}