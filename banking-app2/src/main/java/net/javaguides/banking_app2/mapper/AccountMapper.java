package net.javaguides.banking_app2.mapper;

import net.javaguides.banking_app2.dto.AccountDto;
import net.javaguides.banking_app2.entity.Account;
//mapper class to map dto into entity and vice versa
public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }
    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
