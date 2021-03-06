package utils;

public class Jail extends Field {
   private Boolean isVisiting;

    public Jail(String name, String subtext,  boolean isVisiting){
        super(name, subtext,  null, false);
        this.isVisiting = isVisiting;
    }
    public void goToJail(Player player){
        //we need to make some method that moves a player
        if (!getVisiting()) {
            player.setJail(true);
        }
    }
    public void outOfJail(Player player){
        if(player.GetGetoutofjailfreecard()) {
            player.setGetoutofjailfreecard(false);
        }
        else{
            player.updateWallet(-1);
        }
        player.setJail(false);
    }

    public Boolean getVisiting() {
        return isVisiting;
    }

    @Override
    public String getFieldType() {
        return "Jail";
    }

    @Override
    public int getRent() {
        return 0;
    }

    @Override
    public void landedOn() {

    }

    @Override
    public void landedOn(ChanceDeck chanceDeck, PlayerController playerController, Board board) {
        goToJail(playerController.getCurrentPlayer());
    }

    @Override
    public String getColor() {
        return null;
    }
}
