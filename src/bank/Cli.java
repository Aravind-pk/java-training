package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cli {

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";




    public static void start(Bank bank){
        Scanner sc= new Scanner(System.in);
        int state = 0;
        System.out.println( ANSI_BLACK + ANSI_CYAN_BACKGROUND+"WELCOME ----------------\n"+ ANSI_GREEN_BACKGROUND);


        while (state != 5){
            switch (state){
                case 0:
                    printOption(Arrays.asList("Customer ", "Bank overview" ,"Exit"));
                    state = sc.nextInt()+1;
                    break;
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int cId = sc.nextInt();
                    System.out.print("\nEnter Account No: ");
                    int aId = sc.nextInt();
                    System.out.println("Current balance is Rs: "+ ANSI_YELLOW+ bank.getBalance(cId,aId)+ANSI_BLACK);
                    printOption(Arrays.asList("debit","credit" ,"Back" , "Finish"));
                    switch (sc.nextInt()){
                        case 0:
                            System.out.print("Enter amount: ");
                            bank.debit(cId,aId, BigDecimal.valueOf(sc.nextInt()));
                            System.out.println(ANSI_YELLOW+"\n Amount debited"+ANSI_BLACK);
                            state = 4;
                            break;
                        case 1:
                            System.out.print("Enter amount: ");
                            bank.credit(cId,aId, BigDecimal.valueOf(sc.nextInt()));
                            System.out.println(ANSI_YELLOW+"\n Amount credited"+ANSI_BLACK);
                            state = 4;
                            break;
                        case 2: state = 0;break;
                        case 3: state = 5;break;

                    }break;
                case 2:
                    System.out.println("Get no of customers above SPECIFIED AMOUNT");
                    System.out.println("Enter the total amount");
                    System.out.println("Enter 0 for total number of users");
                    System.out.print("Amount: ");
                    int amount = sc.nextInt();
                    System.out.println("\n Total no of users above " + amount);
                    System.out.println("In total balance: " + bank.getCustomersWithTotal(BigDecimal.valueOf(amount)).size());
                    System.out.println("In any account: " + bank.getCustomersWithOneOver(BigDecimal.valueOf(amount)).size());
                    state = 4;
                    break;
                case 3:state = 5;break;
                case 4:
                    printOption(Arrays.asList("Finish" , "Go to main menu"));
                    switch (sc.nextInt()){
                        case 0:state = 5;break;
                        case 1:state = 0;break;
                    }
                    break;



            }
        }
        System.out.println( ANSI_BLACK + ANSI_CYAN_BACKGROUND+"THANK YOU -----------\n");
    }

    public static void printOption(List<String> options){
        System.out.println("Please select an option from above");
        options.forEach(o-> System.out.printf("%d. %s \n",options.indexOf(o) ,o ));

    }

}
