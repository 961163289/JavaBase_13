package 泛型的理解和好处;

@SuppressWarnings({"all"})
public class CustomMethodGenericExercise {
    public static void main(String[] args) {

        //T=String, R=Integer, M=Double
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);//10 会被自动装箱 Integer 10, 输出 Integer
        apple.fly(new AB());//AB

    }
}

//自定义泛型类
class Apple<T, R, M> {

    //泛型方法
    public <E> void fly(E e) {
        System.out.println(e.getClass().getSimpleName());
    }

    //public void eat(U u) {} //错误,因为 U没有声明

    public void run(M m) { //OK

    }

}

class AB {
}
