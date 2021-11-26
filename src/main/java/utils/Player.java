package utils;

public class Player {
    private int pos;
    private Account account;
    private boolean win;
    private String name;
    private boolean jail;
    private boolean getoutofjailfreecard;
    private int playerNum;

    public Player(String Name, int playerNum){
        this.pos = 0 ;
        this.account = new Account();
        this.win  = false;
        this.name = Name;
        this.jail = false;
        this.getoutofjailfreecard = false;
        this.playerNum = playerNum;

    }
    public void updatePos(int poschange, Board board){
        this.pos += poschange;
        if(this.getPos() >= 24 ) {
            this.pos = this.getPos() % 24;
            this.updateWallet(2);
        }
        board.moveGui_Player(this);
    }
    public void setPos(int pos,Board board){
        this.pos = pos;
        board.moveGui_Player(this);
    }
    public int getPos() {
        return pos;
    }
    public int getPlayerNum() {
        return playerNum;
    }
    public void updateWallet(int i) { account.updateScore(i);}
    public void setWin(boolean x) {
        win = x;
    }
    public Account getAccount(){
        return account;
    }
    public boolean getWin(){
        return win;
    }
    public String getName(){
        return name;
    }
    public Boolean getJail() {
        return jail;
    }
    public void setJail(Boolean jail) {
        this.jail = jail;
    }

    public boolean GetGetoutofjailfreecard() {
        return getoutofjailfreecard;
    }
    public void setGetoutofjailfreecard(boolean getoutofjailfreecard) {
        this.getoutofjailfreecard = getoutofjailfreecard;
    }
}
