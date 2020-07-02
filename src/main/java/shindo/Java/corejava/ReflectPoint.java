package shindo.Java.corejava;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by shindo.yang on 2017/9/28.
 */
@Getter
@Setter
public class ReflectPoint {
    private Date birthday = new Date();

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    private int x;
    public int y;
    public String str1 = "ball";
    public String str2 = "basketball";
    public String str3 = "itcast";

    public ReflectPoint(int x,int y){
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return str1 + ":" + str2 + ":" + str3;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;


        ReflectPoint that = (ReflectPoint) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
