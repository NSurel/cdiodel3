package utils;

public class Player {
    private int pos;
    private Account account;
    private boolean win;
    private String name;
    private boolean jail;
    private boolean getoutofjailfreecard;
    private int playerNum;
    private FieldController fieldController;

    public Player(String Name, int playerNum, FieldController fieldController){
        this.pos = 0 ;
        this.account = new Account();
        this.win  = false;
        this.name = Name;
        this.jail = false;
        this.getoutofjailfreecard = false;
        this.playerNum = playerNum;
        this.fieldController = fieldController;

    }
    public void updatePos(int poschange, Board board){
        this.pos += poschange;
        if(this.getPos() >= 24 ) {
            this.pos = this.getPos() % 24;
            this.updateWallet(2);
        }
        board.moveGui_Player(this);
    }
    public void setPos(int pos,Board board, ChanceDeck chanceDeck, PlayerController playerController){
        if(pos < getPos()) {
            this.updateWallet(2);
        }
        this.pos = pos;
        board.moveGui_Player(this);
        Field fieldLandedOn = fieldController.getFields().get(pos);
        fieldLandedOn.landedOn(chanceDeck,playerController,board);
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
