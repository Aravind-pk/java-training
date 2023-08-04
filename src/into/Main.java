package into;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        // Problem set
        /*
        PROGRAM 1 :Create a list of colours in the rainbow and do the following:
        - Print the last colour
        - Change the 4th colour to purple and print all the coloursß
         */

        List<String> colours = Arrays.asList( "red", "orange", "yellow", "green", "blue", "indigo", "violet");
        System.out.println("last colour: "+ colours.get(6));
        colours.set(3,"purple");
        colours.forEach(System.out::println);

        System.out.println("\nend of problem --------\n");

        /*
        PROGRAM 2: Eliminate the duplicate values from the given list of values.
        [A,v,d,a,d,f,g,r,c,v,g,D,d,e,g]
         */

        Set<String> letters = new HashSet<>(Arrays.asList("A", "v", "d", "a", "d", "f", "g", "r", "c", "v", "g", "D", "d", "e", "g"));
        System.out.println("no-duplicate " +letters);

        /*
        PROGRAM 3: Create a list of employees with the attributes - name, age, salary, yearsOfExp, department and rating (1 to 5)
        Print the name and department of all the employees who have more than 5 years of experience
        Find out salary increments for all the employees using the following criteria and print their names and incremented salary
            Employees who belong to the HR department and has a rating of 5 will get a 10% increment
            Employees who belong to the HR department and has a rating of 4 will get 8% increment
            All other employees will get an increment of 7%

         */

        Employee james = new Employee("James", 40,70_000,20,"HR",4);
        Employee daisy = new Employee("Daisy", 25,45_000,3,"people oops",5);
        Employee joseph = new Employee("Joseph", 49,30_000,25,"sales",3);
        Employee rahul = new Employee("Rahul", 30,50_000,4,"HR",5);
        Employee jisha = new Employee("Jisha", 29,30_000,6,"sales",4);

        List<Employee> employees = new ArrayList<>(Arrays.asList(james, daisy, joseph, rahul, jisha));

        System.out.println("Employees with more than 5 year exp");
        for(Employee e :employees){
            if(e.yearsOfExp > 5) System.out.println(e.name + ", department: " + e.department );
        }





        for (Employee e : employees){
            System.out.printf("Name %s, current salary: %.2f, increment: %.2f \n",e.name,e.salary,calculateIncrement(e));

        }

        System.out.println("........................................");

        employees.forEach( e -> System.out.println(e.name));

        // using stream api ..........

        employees.stream().filter(e -> e.yearsOfExp > 5).forEach(e-> System.out.println(e.name + ", department: " + e.department ));

        System.out.println("\nend of problem --------\n");


        /*
        PROGRAM 4: Create a smartphone class with required attributes and write the equals and hashcode methods for the class to instruct java on how to equate two smartphone objects.
        Then create a HashSet of smartphones and try to add 2 objects with similar data and verify if the set is able to ignore duplicate objects.
         */


        //comparing objects using equals
        Smartphone samsung = new Smartphone("S23" , 16, "128GB",6.1);
        Smartphone apple = new Smartphone("14" , 12, "128GB",6.1);
        Smartphone apple2 = new Smartphone("14" , 12, "128GB",6.1);
        Smartphone apple3 = new Smartphone("14pro" , 12, "128GB",6.1);


        System.out.println(apple2.equals(apple));

        Set<Smartphone> sSet  = new HashSet<>();
        sSet.add(samsung);
        sSet.add(apple);
        sSet.add(apple2);
        sSet.add(apple3);
        System.out.println(sSet); // duplicate objects successfully ignored.

        System.out.println("\nend of problem  --------\n");

    /*

    PROGRAM 4: Create a map of smartphones and find out if a S23 and 14Pro are present in the map.
    If yes, print the smartphone configuration. (Hint: Use containsKey method)

     */

    Map<String, Smartphone> smartPhoneMap = new HashMap<>();
    smartPhoneMap.put("s23" , samsung);
    smartPhoneMap.put("14" , apple2);
    smartPhoneMap.put("14pro" , apple3);


    if(smartPhoneMap.containsKey("s23") && smartPhoneMap.containsKey("14pro") ){
        System.out.println(smartPhoneMap.get("s23") +""+ smartPhoneMap.get("14pro"));
    }else System.out.println("phones not found");




    }

    private static double calculateIncrement(Employee e) {
        double increment = 0.07;
        if(e.department.equals("HR")) {
            if (e.rating == 5) increment = 0.1;
            else if (e.rating == 4) increment = 0.08;
        }
        return increment*e.salary;
    }
}

