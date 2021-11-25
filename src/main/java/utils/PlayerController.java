package utils;
import java.util.ArrayList;

public class PlayerController {
    private ArrayList<Player> players;
    private Player currentPlayer;
    private  int currentPlayerNum;
    private int playerAmount;
    private int maxPlayers = 4;

    public PlayerController()
    {
        currentPlayerNum = 1;
        players = new ArrayList<Player>();
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

    public ArrayList<Player> CreatePLayers(Board board)
    {
        playerAmount = board.setPlayerAmount();
        for (int i = 1; i <= playerAmount; i++) {
            Player newPlayer = new Player(board.getPlayerName("player " + i));
            players.add((newPlayer));
        }
        return players;
    }

    public void setCurrentPlayer() {
        currentPlayerNum++;
        if (currentPlayerNum >= players.size())
        {
            currentPlayerNum = 1;
        }
    }


}
