import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public Customer findCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    public double getTotalDeposits() {
        double total = 0;
        for (Customer customer : customers) {
            for (BankAccount account : customer.getAccounts()) {
                total += account.getBalance();
            }
        }
        return total;
    }
}

