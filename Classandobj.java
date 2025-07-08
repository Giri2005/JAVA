class Car{
	String brand;
	String model;
	int year;
	
	void set(String brand, String model, int year) {
		this.brand=brand;
		this.model=model;
		this.year=year;
	}
	void displayCarInfo() {
		System.out.println("Brand: "+brand);
		System.out.println("Model: "+model);
		System.out.println("Year: "+year);
	}
}
public class Classandobj {

	public static void main(String[] args) {
		Car c1=new Car();
		c1.set("Tesla", "Model S", 2022);
		System.out.println("Car 1 Details:");
		c1.displayCarInfo();
		System.out.println();
		Car c2=new Car();
		c2.set("Toyota", "Corolla", 2020);
		System.out.println("Car 2 Details:");
		c2.displayCarInfo();
	}

}
