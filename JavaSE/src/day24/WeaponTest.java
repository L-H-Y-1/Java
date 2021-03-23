/*
开放型题目，随意发挥：
	写一个类Army,代表一支军队，这个类有一个属性Weapon数组w（用来存储该军队所拥有的所有武器），
	该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能拥有的最大武器数量,
	并用这一大小来初始化数组w。

	该类还提供一个方法addWeapon(Weapon wa),表示把参数wa所代表的武器加入到数组w中。
	在这个类中还定义两个方法attackAll()让w数组中的所有武器攻击；
	以及moveAll()让w数组中的所有可移动的武器移动。

	写一个主方法去测试以上程序。
*/

/*
* 类:
*   属性,构造方法,get+set,重写equals+toString
* */

package day24;

import java.util.Arrays;

public class WeaponTest {
    public static void main(String[] args) {

        Army army = new Army(3);
        army.addWeapon(new Plane());
        army.addWeapon(new Gun());
        army.addWeapon(new Knife());

        army.attackAll();
        army.moveAll();

    }
}

class Army{
    private Weapon[] weapons;
    private int index;

    public Army() {
        this.weapons = new Weapon[2];
        index = 0;
    }

    public Army(int num) {
        this.weapons = new Weapon[num];
        index = 0;
    }

    //------------------------------------------------------

    public void addWeapon(Weapon weapon){
        if(index >= weapons.length){
            System.out.println("武器数量已达到最大值,无法继续添加");
            return;
        }
        weapons[index++] = weapon;
    }

    public void attackAll(){
        for (int i = 0; i < weapons.length ; i++) {
            weapons[i].attack();
        }
    }

    public void moveAll(){
        for (int i = 0; i < weapons.length ; i++) {
            weapons[i].move();
        }
    }

    //------------------------------------------------------

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    //-------------------------------------------------------

    @Override
    public String toString() {
        return "Army{" +
                "weapons=" + Arrays.toString(weapons) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Weapon[])){return false;}
        if(obj==this.weapons){return  true;}
        return this.weapons.equals((Weapon[]) obj);
    }

}

class Weapon{
    public Weapon() {
    }

    //--------------------------

    public void attack() {

    }

    public void move() {
    }

    //--------------------------

    @Override
    public String toString() {
        return "Weapon{}";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

class Plane extends Weapon{

    public Plane() {
    }

    //--------------------------

    public void attack() {
        //System.out.println("The plane cannot attack");
    }

    public void move() {
        System.out.println("The plane is moving");
    }

    //--------------------------

    @Override
    public String toString() {
        return "Plane{}";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

class Gun extends Weapon{

    public Gun() {
    }

    //--------------------------

    public void attack() {
        System.out.println("The gun is attacking");
    }

    public void move() {
        //System.out.println("The gun cannot move");
    }

    //--------------------------

    @Override
    public String toString() {
        return "Gun{}";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

class Knife extends Weapon{

    public Knife() {
    }

    //--------------------------

    public void attack() {
        System.out.println("The knife is attacking");
    }

    public void move() {
        //System.out.println("The knife cannot move");
    }

    //--------------------------

    @Override
    public String toString() {
        return "Knife{}";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

/*
输出结果:
    The gun is attacking
    The knife is attacking
    The plane is moving
*/