import java.util.ArrayList;
import java.util.List;

class Phone {
    String brand;

    Phone(String brand) {
        this.brand = brand;
    }
}

class Person implements Cloneable {

    String name;
    int age;
    ArrayList<String> list;
    String[] str = new String[2];
    Phone phone = null;

    public Person(String name, int age, List<String> list, String string){
        this.name = name;
        this.age = age;
        this.list = new ArrayList<String>(list);
        this.phone = new Phone(string);
        str[0] = "str1";
        str[1] = "str2";
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public Person clone() {  //重写clone()方法
        Person p = null;
        try {
             p = (Person)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
    
    @Override
    public int hashCode(){
        return this.name.hashCode() + age;
    }
    
    /*
    @Override
    public boolean equals(Object obj) {
        Person p = (Person)obj;
        if(this.name.equals(p.name) && this.age == p.age)
            return true;
        return false;
    }
    */
    
    public void print(){
        System.out.println("name\t" + this.name);
        System.out.println("age\t" + this.age);
        System.out.println("list\t" + this.list);
        System.out.println("str\t"+str[0] + " " + str[1]);
        System.out.println("phone\t"+this.phone.brand);
        System.out.println();
    }
}

public class CloneTest {
    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test2");
        
        Person p1 = new Person("tom", 22,list,"NOKIA");
        Person p2 = p1;
        Person p3 = p1.clone();
        
        
        p1.age = 23;    //修改p1.age
        p1.name = "jack";   //修改p1.name
        p1.list.set(0, "test"); //修改p1.list
        p1.str[0] = "str";      //修改p1.str数组
        p1.phone.brand = "APPLE"; //修改p1中phone对象的值

        p1.print();
        p2.print();
        p3.print();
    }
}