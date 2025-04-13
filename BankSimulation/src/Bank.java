import java.util.List;
import java.util.ArrayList;

class Bank {
    private List<Account> accounts;
    private List<Customer> customers;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Nasabah " + customer.getName() + " berhasil ditambahkan");
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }


}
