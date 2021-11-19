package utils;
import java.util.HashMap;

/*
Easier cards:
-Homework: Add 2 to account.
-Candy: Subtract 2 from account.
-MoveToGo: Move to go and add 2 to account.
-Boardwalk: Move to beach promenade.
-SkaterPark: Move to the skater park, if vacant buy it, if not then pay rent to owner.
-Birthday: The other players each give you 1 to account.

Moderate cards:
-GetOutOfJail (needs to be able to be kept in the hand): Get out of jail for free, the player can keep this card until needed.
-Move5 (player has a choice of how many spaces): Move up to 5 spaces.
-Move1OrDraw (player has a choice of two actions): Move 1 space or draw a new card.

-->Move to color, players have a choice of which specific space to move to:
-MoveToOrange: Move to an orange space, if vacant get it for free if not then pay rent to owner.
-MoveToRed: Move to an red space, if vacant get it for free if not then pay rent to owner.
-MoveToLightBlue: Move to a light blue space, if vacant get it for free if not then pay rent to owner.

-->Move to colors, players have choice between two colors and which specific space:
-MoveToOrangeOrGreen: Move to an orange or green space, if vacant get it for free if not then pay rent to owner.
-MoveToPinkOrDarkBlue: Move to a pink or dark blue space, if vacant get it for free if not then pay rent to owner.
-MoveToLightBlueOrRed: Move to a light blue or red space, if vacant get it for free if not then pay rent to owner.
-MoveToBrownOrYellow: Move to a brown or yellow space, if vacant get it for free if not then pay rent to owner.

Difficult cards:
-->Player cards, needs to be able to be kept in the hand:
-CarCard: Give to car player, draw new card. On the car player's next turn that player moves to a vacant space and buys it,
if there is not a vacant space then buy it from another player.
-ShipCard: Give to ship player, draw new card. On the ship player's next turn that player moves to a vacant space and buys it,
if there is not a vacant space then buy it from another player.
-CatCard: Give to cat player, draw new card. On the cat player's next turn that player moves to a vacant space and buys it,
if there is not a vacant space then buy it from another player.
-DogCard: Give to dog player, draw new card. On the dog player's next turn that player moves to a vacant space and buys it,
if there is not a vacant space then buy it from another player.
 */


public class ChanceCard {

    private String text;
    public HashMap<String, Integer> actions;

    //Set and get methods
    void setString(String text) {this.text = text;}
    String getString() {return text;}


    //Constructor for cards with HashMap because some cards have more than one action.
    ChanceCard(String text) {
        this.text = text;
        actions = new HashMap<String, Integer>();
    }

    //Method for giving cards the action(s) associated with the card.
    void addAction(String action, int value) {
         actions.put(action, value);
     }

     //Constructing the cards and giving them their actions too.
     ChanceCard Birthday = new ChanceCard("It is your birthday! You receive 1 money from each other player");
     Birthday.addAction("Birthday money", 1);

     ChanceCard Candy = new ChanceCard("You ate too much candy and must pay!");
     Candy.addAction("Money",-2);

     ChanceCard Homework = new ChanceCard("You did all your homework!");
     Homework.addAction("Money",2);

     ChanceCard SkatePark = new ChanceCard("Move to the skate park and buy it if it is vacant. Otherwise, pay rent to the owner.");
     SkatePark.addAction("Move to", 10);

     ChanceCard Boardwalk = new ChanceCard("Move to the boardwalk.");
     Boardwalk.addAction("Move to", 23);

     ChanceCard Go = new ChanceCard("Move to the boardwalk.");
     Go.addAction("Move to", 0);

     ChanceCard getoutofjailfreecard = new ChanceCard("You are free to leave the jail!");
     getoutofjailfreecard.addAction("Escape jail", 1);

//If else statements for each action when "processing" the cards, used for later, needs to be a loop with a for each loop.
     if (action.equals("bank money")){
        //update user's money with value
    }else if (action.equals("birthday money")){
        //update user's money with value*number of players
    }else if (action.equals("move")){
        //update user's position with value
    }else if (action.equals("Escape jail")){
        //give the user the getoutofjailfreecard
    } else if (action.equals("...")){
        //whatever
    }
}
