package utils;
import java.util.ArrayList;

public class PlayerController {
    private ArrayList<Player> players;
    private Player currentPlayer;
    private  int currentPlayerNum;

    public PlayerController()
    {
        currentPlayerNum = 1;
    }

    public int getPlayerAmount(){
        return players.size();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<Player> getAllPlayers()
    {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setCurrentPlayer() {
        currentPlayerNum++;
        if (currentPlayerNum >= players.size())
        {
            currentPlayerNum = 1;
        }
    }


}
