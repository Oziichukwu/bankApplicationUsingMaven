package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Account;

import java.util.List;

public interface AccountRepository {

    Account save(Account account);
    Account findByAccountid(String id);
    void delete(Account account);
    void delete(String id);
    List<Account>findAll();
}
