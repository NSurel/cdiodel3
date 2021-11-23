package utils;

public class Start extends Field{
    private int fare;
    public Start(String name, String subtext){
        super(name, subtext,null, false);
        fare = 2;
    }
    public int getFare(){
        return this.fare;
    }

    @Override
    public int getRent() {
        return 0;
    }
}
