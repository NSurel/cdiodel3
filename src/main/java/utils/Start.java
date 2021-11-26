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
    public String getFieldType() {
        return "Start";
    }

    @Override
    public int getRent() {
        return 0;
    }

    @Override
    public void landedOn() {

    }

    @Override
    public void landedOn(ChanceDeck chanceDeck, PlayerController playerController) {

    }
}
