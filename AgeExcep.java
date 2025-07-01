import java.util.Scanner;
class invalidException extends Exception{
	public invalidException(String message) {
		super(message);
	}
}
#ageExp
public class AgeExcep {
	public static void validate(int age) throws invalidException{
		if (age<18) {
			throw new invalidException("Your not Eligible to Register");
		}
		System.out.println("Your age "+age+" is Eligible to Register");
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your Age to Validate:");
		int age=scanner.nextInt();
		try {
		validate(age);
		}
		catch (invalidException e) {
            System.out.println(e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Invalid input! Please enter a valid age.");
        } 
        finally {
            System.out.println("Thank you for using our registration system.");
            scanner.close();
	}
	}
}
