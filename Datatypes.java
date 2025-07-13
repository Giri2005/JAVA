class numbers{
	int var1;
	double var2;
	char var3;
	boolean var4;
	int var5;
	double var6;
	String var7;
	
	numbers(int var1,double var2,char var3,boolean var4,int var5, double var6, String var7){
		this.var1=var1;
		this.var2=var2;
		this.var3=var3;
		this.var4=var4;
		this.var5=var5;
		this.var6=var6;
		this.var7=var7;
	}
	
	void display(){
		System.out.println("Integer Value:"+var1);
		System.out.println("Double Value:"+var2);
		System.out.println("Character:"+var3);
		System.out.println("Boolean Value:"+var4);
		System.out.println("The area of circle with radius"+var5+"is:"+(3.14*var5*var5));
		System.out.println("Coverted Double to Integer:"+(int)var6);
		System.out.println("Message:"+var7);
	}
}
public class Datatypes {

	public static void main(String[] args) {
		numbers num = new numbers(25,3.75,'A',true,5,3.0,"Learning Java is fun!");
		num.display();

	}

}
