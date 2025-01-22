package oopslab;

/**
 * @author iraki
 */
class Person
{
    private String name;
    private int age;

    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    @Override
    public String toString()
    {
        return "Name: "+name+", Age: "+age;
    }
}
class Employee extends Person
{
    private String id;
    private int salary;
    
    public Employee(String name,int age,String id,int salary)
    {
        super(name,age);
        this.id=id;
        this.salary=salary;
    }
    @Override
    public String toString()
    {
        return "Name: "+super.getName()+", Age: "+super.getAge()+", Id: "+id+", Salary: "+salary;
    }
}
public class InheritanceTest {

    public static void main(String[] args) {
    Person p1=new Person("Vishal",20);
    Person p2=new Person("Krishna",20);
    System.out.println(p1);
    System.out.println(p2);
    Person e1=new Employee("Mr. Rakesh",25,"E001",25000);
    System.out.println(e1);
    }

}


