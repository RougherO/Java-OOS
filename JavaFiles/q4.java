public class q4 {
    public static void main(String[] args) {
        new Bank();
    }
}

class BankAccount {
    private int accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(int accountNumber, double balance, String ownerName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + "/- INR into account " + accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + "/- INR from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }

    public String getAccountDetails() {
        return "Account Number: " + accountNumber + "\nOwner Name: " + ownerName + "\nBalance: " + balance + "/- INR";
    }
}

class AccountManager {
    private BankAccount[] accounts;
    private int totalAccounts;

    public AccountManager(int capacity) {
        accounts = new BankAccount[capacity];
        totalAccounts = 0;
    }

    public void create(int accountNumber, double initialBalance, String ownerName) {
        if (totalAccounts < accounts.length) {
            accounts[totalAccounts++] = new BankAccount(accountNumber, initialBalance, ownerName);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Cannot create more accounts. Bank at full capacity.");
        }
    }

    public void delete(int accountNumber) {
        for (int i = 0; i < totalAccounts; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                System.arraycopy(accounts, i + 1, accounts, i, totalAccounts - i - 1);
                totalAccounts--;
                System.out.println("Account deleted successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void deposit(int accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account != null && account.getAccountNumber() == accountNumber) {
                account.deposit(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void withdraw(int accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account != null && account.getAccountNumber() == accountNumber) {
                account.withdraw(amount);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void printAllAccounts() {
        for (BankAccount account : accounts) {
            if (account != null) {
                System.out.println(account.getAccountDetails() + "\n");
            }
        }
    }
}

class Bank {
    Bank() {
        AccountManager accountManager = new AccountManager(5);

        accountManager.create(101, 1000.0, "John Doe");
        accountManager.create(102, 1500.0, "Alice Smith");
        accountManager.create(103, 2000.0, "Bob Johnson");
        accountManager.create(104, 1200.0, "Eva Davis");
        accountManager.create(105, 1800.0, "Mark Brown");

        System.out.println();

        accountManager.printAllAccounts();
    }
}
