package oopslab;

/**
 * @author iraki
 */
abstract class Student
{
    private String name;
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    abstract public void giveExam();
}

class CseStudent extends Student
{
    public CseStudent(String name)
    {
        super.setName(name);
    }
    @Override
    public void giveExam()
    {
        System.out.println("CSE Student "+this.getName()+ " is giving exam.");
    }
}
class ItStudent extends Student
{
    public ItStudent(String name)
    {
        super.setName(name);
    }
    @Override
    public void giveExam()
    {
        System.out.println("IT Student "+this.getName()+ " is giving exam.");
    }
}
public class StudentMain {

    public static void main(String[] args) {
        
        //Question 1:
        System.out.println("Question 1:");
        CseStudent s1=new CseStudent("Rakib");
        ItStudent s2=new ItStudent("Krishna");
        
        s1.giveExam();
        s2.giveExam();
        
        //Question 2:
        System.out.println("\nQuestion 2:");
        Student s3=s1;
        s3.giveExam();
        
        s3=s2;
        s3.giveExam();
    }

}
