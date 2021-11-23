package utils;

public class PlayerController {
    private Board players;
    private Player player;

    public PlayerController(Board players, Player player){
        this.players = players;

    }
    public int getPlayerAmount(){
        return players.getPlayerCount();
    }
    public void setPlayerAmount(int player){
        players.createPlayers(player);
    }


}
