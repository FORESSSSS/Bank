package ru.skillfactory.fores.bank.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skillfactory.fores.bank.models.ResponseJson;
import ru.skillfactory.fores.bank.models.User;
import ru.skillfactory.fores.bank.repositories.UserRepository;

import java.math.BigDecimal;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class FinanceService {

    @Autowired
    private final UserRepository userRepository;

    public Optional<BigDecimal> getBalance(Long userId) {
        BigDecimal balance = null;
        try {
            balance = userRepository.findById(userId).get().getBalance();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        Optional<BigDecimal> result = Optional.of(balance);
        return result;
    }

    public ResponseJson takeMoney(Long userId, BigDecimal amount) {
        if (userRepository.existsById(userId)) {
            User target = userRepository.findById(userId).get();
            if (target.getBalance().compareTo(amount) < 0) {
                return new ResponseJson(0, "Недостаточно средств");
            } else {
                target.setBalance(target.getBalance().subtract(amount));
                userRepository.save(target);
                return new ResponseJson(1);
            }
        }
        return new ResponseJson(0, "Пользователь не найден");
    }

    public ResponseJson putMoney(Long userId, BigDecimal amount) {
        if (userRepository.existsById(userId)) {
            User target = userRepository.findById(userId).get();
            target.setBalance(target.getBalance().add(amount));
            userRepository.save(target);
            return new ResponseJson(1);
        }
        return new ResponseJson(0, "Пользователь не найден");
    }
}