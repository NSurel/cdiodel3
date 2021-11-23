package utils;
//this class can be made abstract if we wish it.
public abstract class Field {
    /*
        The field name is the title of a field ie. water park.
     */
   private String name;
    /*
        the field subtext shows the cost of buying the field and when it's bought
        the rent and the name of the owner
     */
    private String subtext;
    /*
    The field owner references which player owns the field
     */
    private String owner;
    /*
    the field isbuyable sees if a Field can be bought by a player
    examples of Fields that can be bought is Properties
    and fields that cannot be bought is Jail
     */
    private boolean isbuyable;

    public Field(String name, String subtext, String owner, boolean isbuyable){
        this.name = name;
        this. subtext = subtext;
        this.owner = owner;
        this.isbuyable = isbuyable;
    }
    // get set methods for all the fields
    public boolean isIsbuyable() {
        return isbuyable;
    }

    public void setIsbuyable(boolean isbuyable) {
        this.isbuyable = isbuyable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public abstract int getRent();

    public abstract void landedOn();

    public abstract void landedOn(ChanceDeck chanceDeck);

}