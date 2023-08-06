package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    String name ;
    int noOfCustomers = 0;
    private List<Customer> customerList = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }
    public Bank(String name , List<Customer> customerList) {
        this.name = name;
        this.customerList = customerList;
        this.noOfCustomers = customerList.size();
    }

    public void addCustomer(List<Customer> customerList) {
        this.customerList.addAll(customerList);
        this.noOfCustomers = this.customerList.size();
    }
    public void addCustomer(Customer c){
        this.customerList.add(c);
        this.noOfCustomers = this.customerList.size();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

     public List<Customer> getCustomersWithTotal(BigDecimal bal) {
        return  this.customerList.stream().filter(customer -> customer.getTotalBalance().compareTo(bal)> 0).collect(Collectors.toList());
    }

    public List<Customer> getCustomersWithOneOver(BigDecimal bal) {
        return  this.customerList.stream().filter(customer -> customer.getTopAccount().getAccBalance().compareTo(bal)> 0).collect(Collectors.toList());

    }


    public Customer getCustomerById(int id){

        return  customerList.stream().filter(c-> c.cId==id).collect(Collectors.toList()).get(0);
    }

    public void debit(int cId ,int accId, BigDecimal amt){
        getCustomerById(cId).getAccountById(accId).addDebit(amt);
    }
    public void credit(int cId ,int accId, BigDecimal amt){
        getCustomerById(cId).getAccountById(accId).addCredit(amt);

    }

}
