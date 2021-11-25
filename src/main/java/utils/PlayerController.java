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
        for (int i = 1; i < playerAmount+1; i++) {
            Player newPlayer = new Player(board.getPlayerName("player " + i),i);
            players.add((newPlayer));
            board.addGuiPlayer(newPlayer);
        }
        for (Player p: players) {
            if(p.getPlayerNum() == 1){
                currentPlayer = p;
            }
        }
        return players;
    }

    public void setCurrentPlayer() {
        currentPlayerNum++;
        if (currentPlayerNum >= players.size()+1)
        {
            currentPlayerNum = 1;
        }
        for (Player p : players) {
            if (p.getPlayerNum() == currentPlayerNum){
                currentPlayer = p;
            }
        }
    }


}
