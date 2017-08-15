package shindo.Java.testAbstract;

public class TestChild {
	public static void main(String[] args) {
		AbstractFather father = new Child2();
		father.sayHello();
	}
}
