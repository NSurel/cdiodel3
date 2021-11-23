package utils;

public class PlayerController {
    private Board players;
    private Player player;

    public PlayerController(Board players, Player player){
        this.players = players;
        this.player = player;
    }

    public int getCurrentPlayerAmount(){
        return players.getPlayerCount();
    }
    public void setCurrentPlayerAmount(int player){
        players.createPlayers(player);
    }


}
