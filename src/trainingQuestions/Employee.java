package trainingQuestions;//PROGRAM 3: Create a list of employees with the attributes - name, age, salary, yearsOfExp, department and rating (1 to 5)

public class Employee {
    String name;
    int age;
    double salary;
    int yearsOfExp;
    String department;
    int rating;

    public Employee(String name, int age,double salary, int yearsOfExp, String department, int rating) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.yearsOfExp = yearsOfExp;
        this.department = department;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "into.Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", yearsOfExp=" + yearsOfExp +
                ", department='" + department + '\'' +
                ", rating=" + rating +
                '}';
    }
}
