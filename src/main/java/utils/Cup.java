package utils;

public class Cup {
    private Board gui;
    private Die die1;
    private Die die2;
    public Cup(Board Gui ,int sides){
        die1 = new Die(sides);
        die2 = new Die(sides);
        gui = Gui;

    }
    public Cup(int sides){
        die1 = new Die(sides);
        die2 = new Die(sides);

    }
    public int rollCup() {
        die1.rollDie();
        die2.rollDie();
        gui.setDice(die1.getFacevalue(), die2.getFacevalue());
        return getSum();
    }
    public void rollCupTest() {
        die1.rollDie();
        die2.rollDie();
    }

    public Die getDie1() {
        return die1;
    }

    public Die getDie2() {
        return die2;
    }

    public int getSum(){
        int res = die1.getFacevalue() + die2.getFacevalue();
        return res;
    }


}
