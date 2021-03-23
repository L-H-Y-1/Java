package day24.overwrite;
/*
重写武器作业

	写一个类Army,代表一支军队，这个类有一个属性Weapon数组w（用来存储该军队所拥有的所有
	武器），	该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能
	拥有的最大武器数量,并用这一大小来初始化数组w。

	该类还提供一个方法addWeapon(Weapon wa),表示把参数wa所代表的武器加入到数组w中。
	在这个类中还定义两个方法attackAll()让w数组中的所有武器攻击；
	以及moveAll()让w数组中的所有可移动的武器移动。

	写一个主方法去测试以上程序。
*/

/*思路
* 1 接口类      CanMove     move()
*              CanAttack    attack()
* 2 父类Weapon    私有属性无
*                构造方法
*                重写toString
* 3 实现子类继承父类,实现接口
*               私有属性无
*               构造方法
*               实现接口方法
*               重写toString
* 4 调用类       私有属性    武器数组,栈帧
*               构造方法    初始化武器数组,存放武器对象
*               方法      addWeapon():超出数量,抛出异常
*                         attackAll(),All()
* 5 异常类       构造方法2
* 6 main方法      new调用对象
*                new实现对象
*                添加武器到数组
*                移动,攻击
* */

public class Test {
    public static void main(String[] args) {
        Army army = new Army();
        try {

            army.addweapon( new Tank() );
            army.addweapon( new Cannon() );
            army.addweapon( new Plane() );
            army.addweapon( new Cannon() );
            army.addweapon( new Plane() );

        } catch (WeaponsAddException e) {
            System.out.println(e.getMessage());
        }

        army.moveAll();
        army.attackAll();
    }
}

class Army{
    private Weapon[] weapons;
    private int index;

    //-----------------------------

    public Army() {
        weapons = new Weapon[4];
        index = 0;
    }

    //--------------------------------

    public void addweapon(Weapon weapon) throws WeaponsAddException {

        if(index>=weapons.length){
            throw new WeaponsAddException("Weapons outnumbered");
        }else{
            weapons[index++] = weapon;
            System.out.println(weapon + "is ready");
            return;
        }
    }

    public void attackAll(){
        for (int i = 0; i < weapons.length; i++) {
            if(weapons[i] instanceof CanAttack){
                CanAttack canAttack = (CanAttack)weapons[i];
                canAttack.attack();
            }
        }
    }

    public void moveAll(){
        for (int i = 0; i < weapons.length; i++) {
            if(weapons[i] instanceof CanMove){
                CanMove canMove = (CanMove)weapons[i];
                canMove.move();
            }
        }
    }
}

interface CanMove{
    void move();
}
interface CanAttack{
    void attack();
}

class Weapon{
    //----------------------
    public Weapon() {
    }
    //-----------------------
    @Override
    public String toString() {
        return "Weapon{}";
    }
}

class Tank extends Weapon implements CanMove,CanAttack{
    //-------------------------

    public Tank() {
    }

    //-------------------------------

    @Override
    public void move() {
        System.out.println("Tank is moving");
    }

    @Override
    public void attack() {
        System.out.println("Tank is attacking");
    }

    //----------------------------------------

    @Override
    public String toString() {
        return "Tank{}";
    }
}
class Cannon extends Weapon implements CanAttack{
    //-------------------------

    public Cannon() {
    }

    //-------------------------------

    @Override
    public void attack() {
        System.out.println("Cannon is attacking");
    }

    //----------------------------------------

    @Override
    public String toString() {
        return "Cannon{}";
    }
}
class Plane extends Weapon implements CanMove{
    //------------------------------------

    public Plane() {
    }

    //--------------------------------------

    @Override
    public void move() {
        System.out.println("Plane is moving");
    }

    //-----------------------------------

    @Override
    public String toString() {
        return "Plane{}";
    }
}

class WeaponsAddException extends Exception{
    public WeaponsAddException() {
    }

    public WeaponsAddException(String message) {
        super(message);
    }
}