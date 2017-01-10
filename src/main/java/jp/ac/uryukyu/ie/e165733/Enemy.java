package jp.ac.uryukyu.ie.e165733;

public class Enemy extends LivingThing {
    public Enemy (String name, int maximumHP, int attack) {
        super(name,maximumHP, attack);
    }

    public void wounded(int damage){
        setHitPoint(getHitPoint() - damage);
        if( getHitPoint() < 0 ) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

    public void attack(LivingThing opponent) {
        if (isDead() == false) {
            int M = (int) (Math.random() * 10);
            int damage = (int) (Math.random() * getAttack());
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n",getName(),opponent.getName());
            }else if (M < 2) {
                int d = damage * 2;
                System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n",getName(),opponent.getName(),d);
            }else{
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
    }
}