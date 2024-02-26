package ru.skillfactory.fores.bank.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactory.fores.bank.models.ResponseJson;
import ru.skillfactory.fores.bank.services.FinanceService;

import java.math.BigDecimal;
import java.util.Optional;

@RestController("/api")
@RequiredArgsConstructor
public class UserOperationController {
    private final FinanceService financeService;

    @GetMapping("/getBalance")
    public ResponseJson getBalance(@RequestParam(value = "id") Long userId) {
        Optional<BigDecimal> result = financeService.getBalance(userId);
        if (result.isPresent()) {
            return new ResponseJson(1, result.get().toString());
        } else {
            return new ResponseJson(-1, "Invalid id");
        }
    }

    @GetMapping("/takeMoney")
    public ResponseJson takeMoney(@RequestParam(value = "id") Long userId,
                                  @RequestParam(value = "amount") BigDecimal amount) {
        return financeService.takeMoney(userId, amount);
    }

    @GetMapping("/putMoney")
    public ResponseJson putMoney(@RequestParam(value = "id") Long userId,
                                 @RequestParam(value = "amount") BigDecimal amount) {
        return financeService.putMoney(userId, amount);
    }
}