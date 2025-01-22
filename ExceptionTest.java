package oopslab;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * @author iraki
 */
class InvalidVoterException extends Exception
{
    @Override
    public String toString()
    {
        return "INVALID REGISTRATION! Age is below 18";
    }
}
class Person2
{
    String id;
    String name;
    String gender;
    String dob;
    String voterId;
    public Person2(String name,String gender,String dob)
    {
        id=Double.toString(Math.random()*100000);
        this.gender=gender;
        this.name=name;
        this.dob=dob;
        this.voterId=null;
    }
    @Override
    public String toString()
    {
        return "Name: "+name+"\nGender: "+gender+"\nDob: "+dob+"\nVoterId: "+voterId;
    }
}
class Voter
{

    public static void setVoter(Person2 p)throws InvalidVoterException
    {
        if(calculateAge(p.dob)<18)
            throw new InvalidVoterException();

        p.voterId="ZZE"+Math.random()*1000;
    }
    public static int calculateAge(String dob)
    {
       DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        
        LocalDate currentDate = LocalDate.now();
        
        Period age = Period.between(birthDate, currentDate);
        
        return age.getYears();
    }
}
public class ExceptionTest {

    public static void main(String[] args) {
         ArrayList<String> aarv=new ArrayList<>();
         ArrayList<String> aarinv=new ArrayList<>();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no. of person");
        int n=sc.nextInt();
        Person2 persons[]=new Person2[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the name: ");String name=sc.next();
            System.out.print("Enter the gender: ");String gender=sc.next();
            System.out.print("Enter the dob[yyyy-mm-dd]: ");String dob=sc.next();
            persons[i]=new Person2(name,gender,dob);
            try
            {
                Voter.setVoter(persons[i]);

            }
            catch(InvalidVoterException e)
            {
                System.out.println(e);
            }
            if(persons[i].voterId == null)
            {
               aarinv.add(persons[i].name);
            }
            else
            {
               aarv.add(persons[i].name);
            }
                
            }
            System.out.print("Invalid: ");
            System.out.println(aarinv);
            System.out.print("Valid: ");
            System.out.println(aarv);
            
        }
}
