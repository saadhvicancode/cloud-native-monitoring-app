package net.javaguides.banking_app2.repository;

import net.javaguides.banking_app2.entity.Account;
import net.javaguides.banking_app2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    void delete(Account account);
}
