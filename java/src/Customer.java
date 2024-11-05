import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int customerId;
    private final String name;
    private final List<BankAccount> accounts;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        accounts.remove(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}