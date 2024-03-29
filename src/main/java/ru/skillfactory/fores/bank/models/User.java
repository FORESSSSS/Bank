package ru.skillfactory.fores.bank.models;

import lombok.Data;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BALANCE")
    private BigDecimal balance;
}