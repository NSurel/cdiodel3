package utils;

public class Cup {
    private Die die1;
    private Die die2;
    public Cup(int sides){
        die1 = new Die(sides);

    }

    public int rollCup() {
        die1.rollDie();
        return die1.getFacevalue();
    }


    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }



}
