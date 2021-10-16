package africa.semicolon.bankingApplication.data.dtos.Request;

import africa.semicolon.bankingApplication.data.models.AccountType;
import lombok.Data;

@Data
public class CreateAccountRequest {

    private String bankId;
    private String firstName;
    private AccountType accountType;
    private String lastName;
    private String bvn;
}
