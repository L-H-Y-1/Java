package RedoHomework.bObject;

/**
    定义丈夫类 Husband 和妻子类 Wife，
        丈夫类的属性包括：身份证号，姓名，出生日期，妻子。
        妻子类的属性包括：身份证号，姓名，出生日期，丈夫。

     分别给这两个类提供构造方法（无参数构造方法和有参数构造方法都要提供），
        编写测试程序，创建丈夫对象，然后再创建妻子对象，丈夫对象关联妻子对象，
        妻子对象关联丈夫对象，要求能够输出这个“丈夫对象”的妻子的名字，
        或者能够输出这个“妻子对象”的丈夫的名字。要求能够画出程序执行过程的内存图。
        并且要求在程序中演示出空指针异常的效果。

        .后面只是一个单词，没有小括号，表示访问的是属性。
        .后面有一个单词，单词后面有小括号，表示访问的是方法。

    这个一定要画出内存图，很有研究价值。
*/
public class HusbandWife {
    public static void main(String[] args) {
        Husband husband = new Husband("John");
        Wife wife = new Wife("Zoe");
        /*System.out.println( "丈夫的名字是" + husband.getName());
        System.out.println( "妻子的名字是" + wife.getName());*/

        husband.setWife(wife);
        System.out.println(husband.getName() + "的妻子是" + husband.getWife().getName());
        //System.out.println(wife.getName()+"的丈夫是"+ wife.getHusband().getName());

        wife.setHusband(husband);
        System.out.println(husband.getName() + "的妻子是" + husband.getWife().getName());
        System.out.println(wife.getName()+"的丈夫是"+ wife.getHusband().getName());
    }
}

/**
 * 定义丈夫类 Husband 和妻子类 Wife，
 *         丈夫类的属性包括：身份证号，姓名，出生日期，妻子。
 *         妻子类的属性包括：身份证号，姓名，出生日期，丈夫。
 */
class Husband{
    private String idNum;
    private String name;
    private String birthDate;
    private Wife wife;

    public Husband() {
    }
    public Husband(String name) {
        this.name = name;
    }
    public Husband(String idNum, String name, String birthDate) {
        this.idNum = idNum;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
class Wife{
    private String idNum;
    private String name;
    private String birthDate;
    private Husband husband;

    public Wife() {
    }
    public Wife(String name) {
        this.name = name;
    }
    public Wife(String idNum, String name, String birthDate) {
        this.idNum = idNum;
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
