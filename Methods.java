class mtd{
	void display() {
		System.out.println("Welcome to the Java Methods Program!\n\n");
	}
	void add(int a,int b) {
		System.out.println("Sum of "+a+" and "+b+" is: "+(a+b));
	}
	void area(int a, int b) {
		System.out.println("Area of rectangle ("+a+","+b+"): "+(a*b));
	}
	void mul(int a,int b) {
		System.out.println("Multiplication of "+a+" and "+b+": "+(a*b));
	}
	void mul(double a,double b) {
		System.out.println("Multiplication of "+a+" and "+b+": "+(a*b));
	}
}
public class Methods {

	public static void main(String[] args) {
		mtd obj= new mtd();
		obj.display();
		obj.add(5,10);
		obj.area(5,8);
		obj.mul(4,6);
		obj.mul(2.5,3.5);
	}

}
