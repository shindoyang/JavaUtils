package shindo.Java.corejava;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * JavaBean内省
 * Created by shindo on 2017/9/30.
 */
public class IntroSpectorTest {

    public static void main(String[] args) throws Exception{
        ReflectPoint pt1 = new ReflectPoint(3,5);

        String propertyName = "x";
        //"x"-->"X"-->"getX"-->"methodGetX"-->

        Object revVal = getProperty(pt1, propertyName);
        System.out.println(revVal);


        Object value = 7;
        setProperties(pt1, propertyName, value);

        //使用BeanUtils开源工具类
        System.out.println(BeanUtils.getProperty(pt1,"x"));
        System.out.println(BeanUtils.getProperty(pt1,"x").getClass().getName());//返回的类型是字符串
        BeanUtils.setProperty(pt1,"x","9");//这里的9是字符串
        System.out.println(pt1.getX());

        /*
        //java7的新特性
        Map map = {name:"zxx",age:"18"};
        BeanUtils.setProperty(pt1,"name","lhh");//BeanUtils不仅可以操作javaBean，还可以操作Map对象
        */

        //BeanUtils还可以进行Bean对象和Map对象之间的相互转换，这个工具包非常有用
        BeanUtils.setProperty(pt1,"birthday.time","111");
        System.out.println(BeanUtils.getProperty(pt1,"birthday.time"));

        PropertyUtils.setProperty(pt1,"x",9);//这里的9是int类型，和BeanUtils工具包的区别
        System.out.println(PropertyUtils.getProperty(pt1,"x"));
        System.out.println(PropertyUtils.getProperty(pt1,"x").getClass().getName());//返回的类型也是证书

    }

    private static void setProperties(Object pt1, String propertyName, Object value) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        PropertyDescriptor pd2 = new PropertyDescriptor(propertyName,pt1.getClass());
        Method methodSetX = pd2 .getWriteMethod();
        methodSetX.invoke(pt1,value);
    }

    private static Object getProperty(Object pt1, String propertyName) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        //简单的内省操作
        /*PropertyDescriptor pd = new PropertyDescriptor(propertyName,pt1.getClass());
        Method methodGetX = pd.getReadMethod();
        Object retVal = methodGetX.invoke(pt1);*/

        //复杂的内省操作
        BeanInfo beanInfo = Introspector.getBeanInfo(pt1.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        Object retVal = null;
        for(PropertyDescriptor pd : pds){
            if(pd.getName().equals(propertyName)){
                Method methodGetX = pd.getReadMethod();
                retVal = methodGetX.invoke(pt1);
            }
        }

        return retVal;

    }
}
