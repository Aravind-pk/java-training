package bank;


/*
Programs for practice:
Program: Banking POC
Scenario: A bank has multiple customers. Each customer can have one or more accounts. Design a system which will allow the bank to manage the following.
Bank should be able to provide the following features for a customer.
Create and manage a customer
Create an account and assign it to a customer
Perform transactions on the account (Credit and Debit)
Provide basic features like
Check account balance
Update customer address
Show all the accounts for a customer along with account detaills.
Bank should create following features for its own internal purposes
Get all the customers who have more than 1 bank account
Get all the customers with a bank balance of more than 1 million rupees in one of their accounts
Get all the customers with a bank balance of more than 1 million rupees in all of their accounts combined.
 */


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Bank myBank = new Bank("myBank");

        // random generating customers in bank
        myBank.addCustomer(generateCustomerList(50));

        //printing no of customers
        System.out.println(myBank.noOfCustomers);

        //printing customerlist
        System.out.println(myBank.getCustomerList());

        //printing number of customers with a total over 1000000;
        System.out.println(myBank.getCustomersWithTotal(BigDecimal.valueOf(1000000)).size());

        ////printing number of customers with over 1000000 in any account;
        System.out.println(myBank.getCustomersWithOneOver(BigDecimal.valueOf(100000)).size());

        //debit from a specific account
        System.out.println(myBank.getBalance(3,1));     //balance before debit
        myBank.debit(3,1, BigDecimal.valueOf(5000));
        System.out.println(myBank.getBalance(3,1));     //balance after debit

        //debit from a specific account
        System.out.println(myBank.getBalance(3,1));     //balance before credit
        myBank.credit(3,1, BigDecimal.valueOf(5000));
        System.out.println(myBank.getBalance(3,1));     //balance after credit


        //cli interface.
        Cli.start(myBank);




    }


    //random generation of account list
    public static List<Account> generateRandomAccountsList(int n){
        List<Account> accList = new ArrayList<>();
        String[] acTypeList = {"savings","current","Salary"};

        for (int i = 0; i < n; i++) {
            int acNo = i+1;
            String acType = acTypeList[ThreadLocalRandom.current().nextInt(acTypeList.length)];
            BigDecimal accBalance = BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(1500000));;
            accList.add(new Account(acNo,acType,accBalance));
        }
        return accList;
    };


    //random generation of customer list
    public static List<Customer> generateCustomerList(int n){

        List<Customer> customerList = new ArrayList<>();
        String[] nameList = {"Aravind","meenakshi","hazeem","hiba","gokul"};
        String[] addressList = {"nattassery kottayam","kazhakootam trivandrum","chinnakada kollam","payanur kannur","chavadimuku trivandrum"};

        for (int i = 0; i < n; i++) {
            int id = i+1;
            String name = nameList[ThreadLocalRandom.current().nextInt(nameList.length)];
            String address = addressList[ThreadLocalRandom.current().nextInt(addressList.length)];
            List<Account> accountList = generateRandomAccountsList(ThreadLocalRandom.current().nextInt(2,10));
            customerList.add(new Customer(id,name,address,accountList));
        }
        return customerList;
    };

}
