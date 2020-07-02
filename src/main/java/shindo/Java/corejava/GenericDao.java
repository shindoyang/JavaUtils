package shindo.Java.corejava;

import java.util.Set;

/**
 * dao:data accecc object --->crud-->(create,read,update,delete)
 * Created by shindo on 2017/10/8.
 * 把泛型定义到类上面，可以使类里面的方法的泛型一致，至于类上定义的泛型符号是什么无所谓了，
 * 比如这里写成<T>,也可以写成<E>,只要一致即可
 */
public class GenericDao<T> {
    public void add(T x) {

    }

    public <T> T findById(int id) {
        return null;
    }

    public Set<T> findByConditions(String where) {
        return null;
    }

    public void delete(T obj) {

    }

    public void delete(int i) {

    }

    public void update(T obj) {

    }

}
