package bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cli {



    public static void start(){
        Scanner sc= new Scanner(System.in);
        int state = 1;
        List<String> options = new ArrayList<>();
        System.out.println("welcome");


        while (state != 5){
            switch (state){
                case 1:{
                    options.clear();
                    options.addAll(Arrays.asList("Customer details","Add transactions" , "Bank overview"));
                    options.forEach(o-> System.out.printf("%d. %s \n",options.indexOf(o) ,o ));
                }
            }
        }
    }
}
