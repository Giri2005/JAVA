import java.util.Scanner;
public class excephand {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("Enter Name:");
			String name= scanner.nextLine();
			
			System.out.println("Enter Age:");
			int age = scanner.nextInt();
			scanner.nextLine();
			
			if(age<18) {
				throw new IllegalArgumentException("Error: Age must be 18 or above to register.");
			}
			
			System.out.println("Enter Email:");
			String email= scanner.nextLine();
			if (!email.contains("@")||!email.contains(".")) {
				throw new IllegalArgumentException("Error: Invalid email format!");
			}
			
			System.out.print("Enter Password (min 6 characters): ");
            String password = scanner.nextLine();
            if (password.length() < 6) {
                throw new IllegalArgumentException("Error: Password must be at least 6 characters long.");
            }

            System.out.println("\nRegistration Successful!");
            System.out.println("Welcome, " + name + "! Your account has been created.");
			}
		
			catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        } 
	        catch (Exception e) {
	            System.out.println("Invalid input! Please try again.");
	        } 
	        finally {
	            System.out.println("Thank you for using our registration system.");
	            scanner.close();
	        }
	}
}
