package 泛型的理解和好处;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class CustomGeneric_ {
    public static void main(String[] args) {

        //T=Double,R=String,M=Integer
        Tiger<Double, String, Integer> g = new Tiger<>("john");
        g.setT(10.9);//OK
        //g.setT("yy");//错误,类型不对
        System.out.println("g=" + g);

        Tiger g2 = new Tiger("john~~");//OK T=Object,R=Object,M=Object
        g2.setT("yy");//OK,因为 T=Object "yy"=String 是 Object子类
        System.out.println("g2 = " + g2);

    }
}

//老韩解读
//1. Tiger 后面泛型,所以我们把 Tiger就称为自定义泛型类
//2. T,R,M 泛型的标识符,一般是单个大写字母
//3. 泛型标识符可以有多个
//4. 普通成员可以使用泛型(属性,方法)
//5. 使用泛型的数组,不能初始化
//6. 静态方法中不能使用类的泛型
class Tiger<T, R, M> {
    String name;
    R r; //属性使用泛型
    M m;
    T t;

    //因为数组在 new不能确定 T的类型,就无法在内存开空间
    T[] ts;

    public Tiger(String name) {
        this.name = name;
    }

    //构造器使用泛型
    public Tiger(R r, M m, T t) {
        this.r = r;
        this.m = m;
        this.t = t;
    }

    //构造器使用泛型
    public Tiger(String name, R r, M m, T t) {
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }


    //因为静态和类是相关的,在类加载时,对象还没有创建
    //所以,如果静态方法和静态属性使用了泛型,JVM就无法完成初始化
    //static R r2;
    //public static void m1(M m) {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    //方法使用到泛型
    public void setR(R r) {
        this.r = r;
    }

    //返回类型可以使用泛型
    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}
