package utils;


public class Account {
    private int balance;

    public Account() {
        balance = 35;
    }
    public String updateScore(int update){
        if(balance + update <= 0){
            balance = 0;
            return "\tTransaction could not be completed as balance would be below 0";
        } else{
            balance += update;
            return "\tTransaction complete";
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int x) {
        balance = x;
    }
}
