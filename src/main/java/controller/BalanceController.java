package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import main.Balance;

@Controller
@RequestMapping("/balance")
public class BalanceController {

    @GetMapping("/getBalance/{userId}")
    @ResponseBody
    public String getBalance(@PathVariable String userId) {
        Long response = new Balance().getBalance(userId);
        return "Result = " + response;
    }

    @GetMapping("/putMoney/{userId}/{amount}")
    @ResponseBody
    public String putMoney(@PathVariable String userId, @PathVariable Long amount) {
        Long response = new Balance().putMoney(userId, amount);
        return "Result = " + response;
    }

    @GetMapping("/takeMoney/{userId}/{amount}")
    @ResponseBody
    public String takeMoney(@PathVariable String userId, @PathVariable Long amount) {
        Long response = new Balance().takeMoney(userId, amount);
        return "Result = " + response;
    }
}