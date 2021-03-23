package RedoHomework.fArray;

/*
武器作业

	写一个类Army,代表一支军队，这个类有一个属性Weapon数组w（用来存储该军队所拥有的所有
	武器），	该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能
	拥有的最大武器数量,并用这一大小来初始化数组w。

	该类还提供一个方法addWeapon(Weapon wa),表示把参数wa所代表的武器加入到数组w中。
	在这个类中还定义两个方法attackAll()让w数组中的所有武器攻击；
	以及moveAll()让w数组中的所有可移动的武器移动。

	写一个主方法去测试以上程序。
*/

/*
* 思路
* 1 抽象类Weapon
* 2 接口AttackAble MoveAble   方法attack move
* 3 子类4
* 4 数组类Army     属性 Weapon数组 max index
*                 方法 addWeapon(Weapon wa)
*                      attackAll() moveAll()
* */

public class WeaponTest {
    public static void main(String[] args) {
        Army army = new Army();
        army.addWeapon(new Gun());
        army.addWeapon(new Tank());
        army.addWeapon(new Plane());
        army.addWeapon(new Gun());
        army.addWeapon(new Gun());

        army.attackAll();
        army.moveAll();
    }
}

class Army{
    private Weapon[] weapons;
    private int max;
    private int index;

    //-------------------------

    public Army() {
        this.max = 4;
        this.weapons = new Weapon[this.max];
        this.index = -1;
    }

    public Army(int max) {
        this.max = max;
        this.weapons = new Weapon[this.max];
        this.index = -1;
    }

    //--------------------------------------

    public void addWeapon(Weapon weapon){
        if (this.index >= weapons.length-1){
            System.out.println("数组已满,添加失败");
            return;
        }else{
            weapons[++index] = weapon;
            System.out.println("添加武器成功");
        }
    }

    public void attackAll(){
        for (int i = 0; i < weapons.length; i++) {
            if (weapons[i] instanceof AttackAble){
                AttackAble attackAble = (AttackAble)weapons[i];
                attackAble.attack();
            }
        }
    }
    public void moveAll(){
        for (int i = 0; i < weapons.length; i++) {
            if (weapons[i] instanceof MoveAble){
                MoveAble moveAble = (MoveAble)weapons[i];
                moveAble.move();
            }
        }
    }

    //---------------------------------------

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

abstract class Weapon{
    public Weapon() {
    }
}

interface AttackAble{
    void attack();
}
interface MoveAble{
    void move();
}

class Gun extends Weapon implements AttackAble{
    public Gun() {
    }

    @Override
    public void attack() {
        System.out.println("Guns attack");
    }
}
class Tank extends Weapon implements AttackAble,MoveAble{
    public Tank() {
    }

    @Override
    public void attack() {
        System.out.println("Tanks attack");
    }

    @Override
    public void move() {
        System.out.println("Tanks move");
    }
}
class Plane extends Weapon implements MoveAble{
    public Plane() {
    }

    @Override
    public void move() {
        System.out.println("Planes move");
    }
}
