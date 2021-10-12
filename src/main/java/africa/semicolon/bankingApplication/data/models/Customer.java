package africa.semicolon.bankingApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Customer {
    private String bvn;
    private final List<Account>accounts = new ArrayList<>();
    private String firstName;
    private String lastName;
}
