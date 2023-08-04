package into;

public class Exeptest {

   /*
   . Create a Custom Ex Class which will be thrown in case we have divide by zero or File not found.
2. We have to research and find Classes with implements Autoclosable.
3. Few Examples of Classes which extend Error or its subtype.
4. Write a Java program that reads a list of numbers from a file and throws a custom exception if any of the numbers are positive.
    */

    public static void main(String[] args) {
        try {
            throw new customEx("hello");
        }catch (customEx e){
            System.out.println(e.getMessage());
        }
    }
}



class customEx extends ArithmeticException{
    customEx(String msg){super(msg);}
}

