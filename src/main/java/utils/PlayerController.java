package utils;
import java.util.List;

public class PlayerController {
    private List<Player> players;
    private int currentPlayer;

    public PlayerController()
    {
        currentPlayer = 1;
    }

    public int getPlayerAmount(){
        return players.size();
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer() {
        currentPlayer++;
        if (currentPlayer >= players.size())
        {
            currentPlayer = 1;
        }
    }


}
