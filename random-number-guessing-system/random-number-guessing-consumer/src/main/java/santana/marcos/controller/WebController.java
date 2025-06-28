package santana.marcos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import santana.marcos.service.GuessService;

@Controller
public class WebController {

    @Autowired
    private GuessService guessService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/guess-web")
    public String guess(@RequestParam int number, Model model) {
        String result = guessService.guess(number);
        model.addAttribute("result", result);
        return "index";
    }
}