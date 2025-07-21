import java.util.Scanner;
class Flow{
	void days(int a){
		switch(a) {
		case 1:
			System.out.println("You selected: Monday");
			break;
		case 2:
			System.out.println("You selected: Tuesday");
			break;
		case 3:
			System.out.println("You selected: Wednesday");
			break;
		case 4:
			System.out.println("You selected: Thursday");
			break;
		case 5:
			System.out.println("You selected: Friday");
			break;
		default:
			System.out.println("Not valid");
			return;
			}
		System.out.println();
	}
	void num() {
		System.out.println("Numbers from 1 to 10 (skipping 5):");
		for(int i=1;i<11;i++) {
			if(i==5) {
				continue;
			}
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	void nums() {
		System.out.println("Counting down from 10 (stopping at 3):");
		for(int i=10;i>0;i--) {
			if(i==3) {
				break;
			}
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
	void mess(String x) {
		System.out.println("Printing message using do-while loop:");
		int i=0;
		do {
			System.out.println(x);
			i++;
		}while(i<3);
		System.out.println();
	}
}
public class Flowcontrol {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		int a;
		System.out.println("Enter a number between 1 to 5:");
		a=ob.nextInt();
		
		Flow myobj = new Flow();
		myobj.days(a);
		myobj.num();
		myobj.nums();
		myobj.mess("Java is fun!");
		ob.close();
	}

}
