import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. Find Customer");
            System.out.println("3. Add Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Get Balance");
            System.out.println("7. Remove Customer");
            System.out.println("8. Get Total Deposits");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCustomer(bank, scanner);
                    break;
                case 2:
                    findCustomer(bank, scanner);
                    break;
                case 3:
                    addAccount(bank, scanner);
                    break;
                case 4:
                    deposit(bank, scanner);
                    break;
                case 5:
                    withdraw(bank, scanner);
                    break;
                case 6:
                    getBalance(bank, scanner);
                    break;
                case 7:
                    removeCustomer(bank, scanner);
                    break;
                case 8:
                    getTotalDeposits(bank);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCustomer(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Customer newCustomer = new Customer(customerId, customerName);
        bank.addCustomer(newCustomer);
        System.out.println("Customer added successfully.");
    }

    private static void findCustomer(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID to find: ");
        int customerIdToFind = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer foundCustomer = bank.findCustomer(customerIdToFind);
        if (foundCustomer != null) {
            System.out.println("Customer found: " + foundCustomer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void addAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerIdForAccount = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customerForAccount = bank.findCustomer(customerIdForAccount);
        if (customerForAccount != null) {
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            BankAccount newAccount = new BankAccount(accountNumber, customerForAccount.getName(), initialBalance);
            customerForAccount.addAccount(newAccount);
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deposit(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerIdForDeposit = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customerForDeposit = bank.findCustomer(customerIdForDeposit);
        if (customerForDeposit != null) {
            System.out.print("Enter account number: ");
            int accountNumberForDeposit = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            BankAccount depositAccount = findAccount(customerForDeposit, accountNumberForDeposit);
            if (depositAccount != null) {
                depositAccount.deposit(depositAmount);
            } else {
                System.out.println("Account not found.");
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void withdraw(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerIdForWithdrawal = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customerForWithdrawal = bank.findCustomer(customerIdForWithdrawal);
        if (customerForWithdrawal != null) {
            System.out.print("Enter account number: ");
            int accountNumberForWithdrawal = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter amount to withdraw: ");
            double withdrawalAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            BankAccount withdrawalAccount = findAccount(customerForWithdrawal, accountNumberForWithdrawal);
            if (withdrawalAccount != null) {
                withdrawalAccount.withdraw(withdrawalAmount);
            } else {
                System.out.println("Account not found.");
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void getBalance(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID: ");
        int customerIdForBalance = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customerForBalance = bank.findCustomer(customerIdForBalance);
        if (customerForBalance != null) {
            System.out.print("Enter account number: ");
            int accountNumberForBalance = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            BankAccount balanceAccount = findAccount(customerForBalance, accountNumberForBalance);
            if (balanceAccount != null) {
                System.out.println("Account balance: " + balanceAccount.getBalance());
            } else {
                System.out.println("Account not found.");
            }
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void removeCustomer(Bank bank, Scanner scanner) {
        System.out.print("Enter customer ID to remove: ");
        int customerIdToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Customer customerToRemove = bank.findCustomer(customerIdToRemove);
        if (customerToRemove != null) {
            bank.removeCustomer(customerToRemove);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void getTotalDeposits(Bank bank) {
        double totalDeposits = bank.getTotalDeposits();
        System.out.println("Total deposits in the bank: " + totalDeposits);
    }

    private static BankAccount findAccount(Customer customer, int accountNumber) {
        for (BankAccount account : customer.getAccounts()) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null; // Account not found
    }
}