package santana.marcos.controller;

import santana.marcos.service.RandomNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guess")
public class RandomNumberController {
    @Autowired
    private RandomNumberService randomNumberService;

    @PostMapping
    public String guess(@RequestParam int number) {
        int randomNumber = randomNumberService.getOrCreateRandomNumber();
        if (number > randomNumber) {
            return "Your number is higher than the correct one.";
        } else if (number < randomNumber) {
            return "Your number is lower than the correct one.";
        } else {
            randomNumberService.clearRandomNumber();
            return "Your number is equal to the correct one.";
        }
    }
}