package utils;

public class Jail extends Field {
   private Boolean isVisiting;

    public Jail( String subtext,  boolean isVisiting){
        super("Jail", subtext,  null, false);
    }
    public void goToJail(Player player, Jail jail){
        //we need to make some method that moves a player
        if (!jail.getVisiting()) {
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
}
