package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    final int cId;
    String cName;
    String cAddress;
    List <Account> acList = new ArrayList<>();
    int noOfAccount = 1;

    public Customer(int cId, String cName, Account acc, String cAddress) {
        this.cId = cId;
        this.cName = cName;
        this.cAddress = cAddress;
        this.acList.add(acc);
    }

    public Customer(int cId, String cName,String cAddress, List<Account> acList) {
        this.cId = cId;
        this.cName = cName;
        this.cAddress = cAddress;
        this.acList = acList;
        this.noOfAccount= acList.size();
    }

    public List<Account> getAcList() {
        return acList;
    }

    public void addAccount(Account acc) {
        this.acList.add(acc);
        this.noOfAccount++;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public BigDecimal getTotalBalance(){
        return this.acList.stream().map(a -> a.accBalance).reduce(BigDecimal.valueOf(0), BigDecimal::add);

    }

    public Account getTopAccount(){
        return Collections.max(this.acList , Comparator.comparing(Account::getAccBalance));
    }


    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", acList=" + acList +
                ", noOfAccount=" + noOfAccount +
                '}'+"\n";
    }

    public Account getAccountById(int accNo) {
        return this.acList.stream().filter(a ->a.acNo ==accNo).collect(Collectors.toList()).get(0);
    }
}
