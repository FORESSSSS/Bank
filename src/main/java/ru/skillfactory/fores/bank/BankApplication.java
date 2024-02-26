package ru.skillfactory.fores.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.skillfactory.fores.bank.controllers.UserOperationController;

import java.math.BigDecimal;

@SpringBootApplication
public class BankApplication {

    private static final Logger logger = LoggerFactory.getLogger(BankApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(BankApplication.class, args);

        UserOperationController userOperationController =
                (UserOperationController) app.getBean(UserOperationController.class);
        logger.info(userOperationController.getBalance(1L).toString());
        logger.info(userOperationController.takeMoney(1L, new BigDecimal(1000)).toString());
        logger.info(userOperationController.putMoney(1l, new BigDecimal(1000)).toString());
    }
}
