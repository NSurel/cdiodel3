package utils;
public class Property extends Field{

//Very simple code, idk if you wanna use it. - Simon BS
// Ty - MW

    //waiting for GUI elements etc, idc what they wanna add.
    private  int rent;

    public Property(String name, String subtext, int rent, String owner, boolean isbuyable){
        super(name, subtext, owner, true);
        this.rent=rent;
    }
    // method for making a Player buy the field
    public void buyField(Player buyer){
        setOwner(buyer.getName());
        setIsbuyable(false);
        buyer.updateWallet(-this.rent);
    }
    /* need something to check if the rent should be doubled. i.e.
    a player owns 2 of the same type of amusemnet/property (maybe add a new field)? - MW
     */
    public void doubleRent(Property [] array) {
        for (int i = 0; i < array.length-1; i++)
            if (array[i].getOwner().equals(array[i+1].getOwner()) ) {
                array[i].setRent(this.rent*2);
            }
    }
    //get and set for rent
    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
