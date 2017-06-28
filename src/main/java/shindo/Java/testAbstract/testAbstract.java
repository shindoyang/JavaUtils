package shindo.Java.testAbstract;

/**
 * 抽象类不能创建
 * 因为默认的都是“public static”的静态方法，所以是没法new对象的。
 1.抽象类与抽象方法的关系是：抽象方法必须在抽象类中,如果抽象方法不在抽象类中,则会编译报错,这个是规定的。
 2.抽象类中的方法不一定要必须是抽象方法,可以有抽象方法,和非抽象方法.其中非抽象方法,往往都是抽象类的所有子类所具有的,而抽象方法则由具体的不同子类实现不同的方法。
 *
 */
public class testAbstract {
	public static void main(String[] args) {
		int a = 1;
		if(1==a ){
			Child c = new Child();
			c.hello();
			c.getMsg();
		}
	}
}
