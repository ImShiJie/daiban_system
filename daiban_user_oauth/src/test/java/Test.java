import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

/**
 * @program: daiban_System
 * @description:
 * @author: 施
 * @create: 2020-02-17 12:23
 **/

public class Test {

    public static void main(String[] args) throws Exception {
        Class<ServiceStudent> serviceStudentClass = ServiceStudent.class;
        Method[] methods = serviceStudentClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("show")){
                System.out.println("有这个方法");
            }
        }
        String[] str = {"String"};
        execute("ServiceStudent", "show", str);
//        execute("ServiceStudent", "sleep", str);

    }

    public static Object execute(String className, String methodName, Object args[]) throws Exception {
        Class cls = Class.forName(className);
        Method[] methods = cls.getMethods();
        Object obj = cls.newInstance();
        for (Method method : methods) {
            // 获取方法所需要参数的Class对象数组
            Class[] types = method.getParameterTypes();
            // 判断methodName是否和方法名一致，若一致，再判断传递的参数个数是否一致。参数个数一致后再判断参数类型是否一致
            if (isEqualParamAndTypes(args, types)){
                System.out.println("参数不匹配");
            }
            if (method.getName().equals(methodName) && args.length == types.length) {
                // 都一致 执行该方法
                return method.invoke(obj, args);
            }
        }
        System.out.println("没有这个方法或参数不匹配");
        return null;
    }

    /**
     * 判断参数数组的类型是否与方法所需要的参数类型是否一致
     * @param args 方法调用参数
     * @param types 方法所需要的参数类型
     * @return true代表一致，false不一致
     */
    private static boolean isEqualParamAndTypes(Object[] args, Class[] types) {
        boolean flag = false;
        for (int i = 0; i < args.length; i++) {
            String clsName = args[i].getClass().toString();
            String typeName = types[i].toString();
            // 上面获取参数的Class对象的字符串表示形式，是为了更好的去判断参数是否为基本数据类型。
            // 这里还需要去判断方法参数是否为基本数据类型。 如果是，那么照样是可以通过的
            if (clsName.equals(typeName) || isBasicType(clsName).equals(typeName)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 判断字节码文件对象的字符串表示形式是否为基本数据类型的包装类型，若是，则返回基本数据类型的class对象的字符串表示形式
     * @param clsName 字节码文件(Class)对象的字符串表示形式
     * @return 若是包装类型，返回对应类型的基本数据类型的class对象表示形式，若不是，则返回该字符串本身
     */
    private static String isBasicType(String clsName) {
        switch (clsName) {
            case "class java.lang.Byte":
                return "byte";
            case "class java.lang.Short":
                return "short";
            case "class java.lang.Integer":
                return "int";
            case "class java.lang.Long":
                return "long";
            case "class java.lang.Float":
                return "float";
            case "class java.lang.Double":
                return "double";
            case "class java.lang.Character":
                return "char";
            case "class java.lang.Boolean":
                return "boolean";
            default:
                return clsName;
        }
    }
}

//发送端

/**
 * UDP接收数据：
 * 因为接收端不知道发送端什么时候停止发送，故采用死循环接收
 */
class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端的Socket对象(DatagramSocket)
        DatagramSocket ds = new DatagramSocket(12345);

        while (true) {
            //创建一个数据包，用于接收数据
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);

            //调用DatagramSocket对象的方法接收数据
            ds.receive(dp);

            //解析数据包，并把数据在控制台显示
            System.out.println("数据是：" + new String(dp.getData(), 0, dp.getLength()));
        }
        //关闭接收端
//        ds.close();
    }
}

//接收端
class SendDemo{
    public static void main(String[] args) throws IOException{
        //创建发送端的Socket对象(DatagramSocket)
//        DatagramSocket ds = new DatagramSocket();

        //自己封装键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            //输入的数据时886，发送数据结束
            if ("886".equals(line)){
                break;
            }

            //创建数据，并把数据打包
            byte[] bys = line.getBytes();
            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.1.66"), 12345);

            //调用DatagramSocket对象的方法发送数据
//            ds.send(dp);
        }
        //关闭发送端
//        ds.close();
    }
}


class ServiceStudent{
    public ServiceStudent() {
    }

    public void show(String name){
        name = "我是张三";
        System.out.println(name);
    }

    public void sleep(String name,int age){
        name = "李四";
        age = 18;
        System.out.println("我叫："+name+"，我今年："+age);
    }
}



class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getAge() {
        return age;
    }

//    public void setAge(int age) {
//        this.age = age;
//    }
}
class Student1{
    private String name;
    private int age;

    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Test02{

    @Resource(name = "student",type = Student.class)
    private Student student;
    public static void main(String[] args) {
            List list = new LinkedList();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

            List list1 = new ArrayList();
            list1.add("张三");
            list1.add("李四");
            list1.add("王五");
            list1.add("赵六");
            list1.add("赵四");
            list1.add("扎弄起");

        Long startDate;
        Long endDate;
            startDate = new Date().getTime();
        for (Object o : list) {
            if ("998".equals(o))
                System.out.println(o);
        }
        endDate = new Date().getTime();

        System.out.println(endDate - startDate);
    }


    public void test(){

    }
}


































