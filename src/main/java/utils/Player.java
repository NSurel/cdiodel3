package utils;

public class Player {
    private int pos;
    private Account account;
    private boolean turn;
    private boolean win;
    private String name;
    private boolean jail;
    private boolean getoutofjailfreecard;

    public Player(String Name){
        this.pos =0 ;
        this.account = new Account();
        this.turn = false;
        this.win  = false;
        this.name = Name;
        this.jail = false;
        this.getoutofjailfreecard = false;

    }
    public void updatePos(Player player, int poschange){

        if(player.getPos() >= 24 ) {
            this.pos = player.getPos() % 24;
            player.updateWallet(2);
        }
        else{
            this.pos+=poschange;
        }
    }
    public void setPos(int pos){
        this.pos = pos;
    }
    public int getPos() {
        return pos;
    }
    public void updateWallet(int i){}
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
