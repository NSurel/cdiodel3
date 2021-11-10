package utils;
import java.util.Random;

public class Die {
    private Random roll;
    private int facevalue;
    private int sides;
    public Die(int size) {
        facevalue = 1;
        sides = size;
    }
    public void rollDie(){
        roll = new Random();
        facevalue = roll.nextInt(sides)+1;
    }
    public int getFacevalue(){
    return facevalue;
    }
    public void setFacevalue(int x){
        facevalue = x;
    }

}
