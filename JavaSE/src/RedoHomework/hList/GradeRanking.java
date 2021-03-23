package RedoHomework.hList;

/*
3.分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，如果成绩一样，
那在成绩排序的基础上按照年龄由小到大排序。

姓名（String）年龄（int）分数（float）
liusan			20				90.0F
lisi			22				90.0F
wangwu			20				99.0F
sunliu			22				100.0F

编写一个Student类用来实现Comparable<Student>接口,并在其中重写CompareTo(Student o)方法　
在主函数中使用Comparable 与 Comparator分别对ArrayList进行排序.
*/

/*
* 排序方法1
*           TreeSet存放的类 实现Comparable接口 重写compareTo方法
* 排序方法2
*           构造TreeSet的时候传比较器对象实现Comparator接口
*           TreeSet<Student> students1 = new TreeSet<>(new Comparator<Student>()
*           用匿名内部类 重写compare方法
 * 注:
*       1.  仅仅自动排序的TreeSet可以使用这几种方法
*       2.  o - this 降序    o2 - o1 降序
* */

/*
    结果
        ----------------------
        Student{name='Dave', age=22, grade=100.0}
        Student{name='Cathy', age=20, grade=99.0}
        Student{name='Ben', age=22, grade=90.0}
        Student{name='Amy', age=20, grade=90.0}
        ----------------------
        ----------------------
        Student{name='David', age=22, grade=100.0}
        Student{name='Cara', age=20, grade=99.0}
        Student{name='Bob', age=22, grade=90.0}
        Student{name='Alex', age=20, grade=90.0}
        ----------------------
*/

import java.util.Comparator;
import java.util.TreeSet;

public class GradeRanking {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Amy",20,90.0F));
        students.add(new Student("Cathy",20,99.0F));
        students.add(new Student("Ben",22,90.0F));
        students.add(new Student("Dave",22,100.0F));

        System.out.println("----------------------");
        for ( Student s : students ) {
            System.out.println(s);
        }
        System.out.println("----------------------");

        TreeSet<Student> students1 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.grade == o2.grade){
                    return o2.age - o1.age;
                }else{
                    return (int) (o2.grade - o1.grade);
                }
            }
        });
        students1.add(new Student("Alex",20,90.0F));
        students1.add(new Student("Cara",20,99.0F));
        students1.add(new Student("Bob",22,90.0F));
        students1.add(new Student("David",22,100.0F));

        System.out.println("----------------------");
        for ( Student s : students1 ) {
            System.out.println(s);
        }
        System.out.println("----------------------");

    }
}

class Student implements Comparable<Student>{
    String name;
    int age;
    float grade;

    public Student() {
    }

    public Student(String name, int age, float grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.grade == o.grade){
            return o.age - this.age;
        }else{
            return (int) (o.grade - this.grade);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

}
