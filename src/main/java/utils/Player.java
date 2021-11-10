package utils;

public class Player {
    private Account account;
    private boolean turn;
    private boolean win;
    private String name;

    public Player(String Name){
        account = new Account();
        turn = false;
        win  = false;
       this.name = Name;
    }
    public void setTurn(){
        turn = !turn;
    }
    public void setWin(boolean x) {
        win = x;
    }
    public Account getAccount(){
        return account;
    }
    public boolean getTurn(){
        return turn;
    }
    public boolean getWin(){
        return win;
    }
    public String getName(){
        return name;
    }
}
