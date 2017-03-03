package shindo.Java.generic.interfaceDemo;

//泛型接口
interface Info<T> {// 在接口上定义泛型
    public T getVar();// 定义抽象方法，抽象方法的返回值就是泛型类型
}
