package jp.ac.uryukyu.ie.e165733;

public class Hero extends LivingThing{
    public Hero (String name, int hitPoint, int attack) {
        super(name,hitPoint,attack);
    }

    public void wounded(int damage){
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("%sは道半ばで力尽きた\n", getName());
        }
    }

    public void attack(LivingThing opponent) {
        if (isDead() == false) {
            int M = (int) (Math.random() * 10);
            int damage = (int) (Math.random() * getAttack());
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",getName(),opponent.getName());
            }else if (M < 3) {
                int d = damage * 2;
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n",getName(),opponent.getName(),d);
            }else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
    }
}