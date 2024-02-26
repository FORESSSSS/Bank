package ru.skillfactory.fores.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.fores.bank.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
