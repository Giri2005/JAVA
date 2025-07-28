class Animal{
	void makeSound(){
		System.out.println("Animal makes a sound");
		}
}
class Dog extends Animal{
	@Override void makeSound() {
		System.out.println("Dog barks");
	}
}
class Cat extends Animal{
	@Override void makeSound() {
		System.out.println("Cat meows");
	}
}
class Puppy extends Dog{
	@Override void makeSound() {
		System.out.println("Puppy makes a sound");
		super.makeSound();
	}
}
public class inheritance {

	public static void main(String[] args) {
		Animal a=new Animal();
		a.makeSound();
		Dog b=new Dog();
		b.makeSound();
		Cat c=new Cat();
		c.makeSound();
		Puppy p=new Puppy();
		p.makeSound();
	}

}
