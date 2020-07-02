package shindo.Java.corejava;


/**
 * 关于注解的测试类
 *
 * 注解：告诉java编译器或向开发IDE传达一种信息
 *
 * 注解相当于一种标记，在程序中加了注解就等于为程序打上了某种标记，没加，则等于没有某种标记，以后，java编译器，开发工具和其他程序
 * 可以用反射来了解你的类和各种元素上有无何种标记，看你有什么标记，就去干相应的事。标记可以加在包、类、字段、方法、
 * 方法的参数以及局部变量上。
 * 看java.lang包，可看到jdk提供的最基本的Annotation
 *
 * 注解就相当于一个你的源程序中要调用的一个类，要在源程序中应用某个注解，得先准备好这个注解类。就像你要调用某个类，得先开发好这个类。
 *
 * 类名的命名一般是名词，方法一般是以动词命名
 * Created by shindo on 2017/10/2.
 */
@ItcastAnnotation(color = "red",value ="abc",arrayAttr={1,2,3})
public class AnnotationTest {
    //@SuppressWarnings 压缩警告，jdk1.5的新特性，一个注解就相当于一个类
    @SuppressWarnings("deprecation")
    @ItcastAnnotation("xyz")//如果只有一个value属性需要设置，那么可以省略"value="
    public static void main(String[] args) {
        //过时方法，想编译器不画横线提示，可以使用 @SuppressWarnings("deprecation")
//        System.runFinalizersOnExit(true);

        //检查AnnotationTest类是否有ItcastAnnotation注解
        if(AnnotationTest.class.isAnnotationPresent(ItcastAnnotation.class)){
            ItcastAnnotation annotation = (ItcastAnnotation) AnnotationTest.class.getAnnotation(ItcastAnnotation.class);
            System.out.println(annotation);
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            System.out.println(annotation.arrayAttr().length);
        }
    }

    //若方法过时，对新的调用者不建议使用，对已调用不影响，可使用@Deprecated注解
    @Deprecated
    public static void sayHello(){
        System.out.println("hi,天津河西区！");
    }

}
