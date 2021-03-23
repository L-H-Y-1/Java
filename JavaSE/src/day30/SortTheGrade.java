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
*思路
* 1 创建Student类
*       属性  姓名 年龄 成绩
*       方法  构造方法2
*       重写  toString (compareTo)
* 2 创建Student对象和TreeSet集合,将对象加入集合
* 3 排序1     实现Comparable接口
*       Student类实现Comparable<Student>
*       Student类重写compareTo方法
*           注:  o - this 降序
*                this - o 升序
* 4 排序2     使用Comparator比较器
*       方法1
*           创建集合TreeSet时,使用匿名内部类
*           参数中new Comparator<Student>
*           匿名内部类重写compare方法
*               注: o2 - o1   降序
*                   o1 - o2升序
*       方法2
*           创建集合TreeSet时,参数中new StudentComparator()
*           编写比较器类StudentComparator()实现Comparator<Student>接口
*           比较器类重写compare方法
* 5 foreach遍历集合TreeSet
* */

package day30;

import java.util.Comparator;
import java.util.TreeSet;

public class SortTheGrade {
    public static void main(String[] args) {
        //创建学生对象
        Student student1 = new Student("liusan",20,90.0F);
        Student student2 = new Student("lisi",22,90.0F);
        Student student3 = new Student("wangwu",20,99.0F);
        Student student4 = new Student("sunliu",22,100.0F);

        //创建TreeSet集合
        TreeSet<Student> students = new TreeSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        //遍历集合实现Comparable接口排序
        System.out.println("-----------------------------");
        System.out.println("实现Comparable接口排序:");
        for (Student s: students ) {
            System.out.println(s);
        }
        System.out.println("-----------------------------");

        //创建TreeSet集合,传递比较器,使用匿名内部类
        TreeSet<Student> students2 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.grade == o2.grade){
                    return o2.age - o1.age;
                }else{
                    return (int) (o2.grade - o1.grade);
                }
            }
        });
        students2.add(student1);
        students2.add(student2);
        students2.add(student3);
        students2.add(student4);

        //遍历集合实现比较器排序
        System.out.println("实现匿名内部类比较器排序:");
        for (Student s: students2 ) {
            System.out.println(s);
        }
        System.out.println("-----------------------------");

        //创建TreeSet集合,传递比较器,编写单独比较器类
        TreeSet<Student> students3 = new TreeSet<>(new StudentComparator());
        students3.add(student1);
        students3.add(student2);
        students3.add(student3);
        students3.add(student4);

        //遍历集合实现比较器排序
        System.out.println("实现比较器类比较器排序:");
        for (Student s: students3 ) {
            System.out.println(s);
        }
        System.out.println("-----------------------------");
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.grade == o.grade){
            return o.age - this.age;
        }else{
            return (int) (o.grade - this.grade);
        }

    }
}

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.grade == o2.grade){
            return o2.age - o1.age;
        }else{
            return (int) (o2.grade - o1.grade);
        }
    }
}

/*
结果:
        -----------------------------
        实现Comparable接口排序:
        Student{name='sunliu', age=22, grade=100.0}
        Student{name='wangwu', age=20, grade=99.0}
        Student{name='lisi', age=22, grade=90.0}
        Student{name='liusan', age=20, grade=90.0}
        -----------------------------
        实现匿名内部类比较器排序:
        Student{name='sunliu', age=22, grade=100.0}
        Student{name='wangwu', age=20, grade=99.0}
        Student{name='lisi', age=22, grade=90.0}
        Student{name='liusan', age=20, grade=90.0}
        -----------------------------
        实现比较器类比较器排序:
        Student{name='sunliu', age=22, grade=100.0}
        Student{name='wangwu', age=20, grade=99.0}
        Student{name='lisi', age=22, grade=90.0}
        Student{name='liusan', age=20, grade=90.0}
        -----------------------------
* */
