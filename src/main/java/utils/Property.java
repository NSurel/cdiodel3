package utils;
public class Property extends Field{
    private  int rent;
    private String color;

    public Property(String name, String subtext, int rent, Player owner, String color){
        super(name, subtext, owner, true);
        this.rent=rent;
        this.color=color;
    }
    // method for making a Player buy the field
    public void buyField(Player buyer){
        setOwner(buyer);
        setIsbuyable(false);
        buyer.updateWallet(-this.rent);
    }

    public void payRent(PlayerController playerController)
    {
        playerController.getCurrentPlayer().updateWallet(-rent);
        getOwner().updateWallet(rent);
    }

    @Override
    public String getFieldType() {
        return "Property";
    }

    //get and set for rent
    @Override
    public int getRent() {
        return rent;
    }

    @Override
    public void landedOn() {
    }

    @Override
    public void landedOn(ChanceDeck chanceDeck, PlayerController playerController, Board board) {
        if(isIsbuyable()) {
            buyField(playerController.getCurrentPlayer());
            setIsbuyable(false);
        } else {
            payRent(playerController);
        }
    }
    public String getColor(){
        return color;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
