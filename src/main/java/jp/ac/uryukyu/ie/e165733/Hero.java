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
}