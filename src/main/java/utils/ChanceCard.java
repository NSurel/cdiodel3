package utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private HashMap<String, Integer> actions;

    //Set and get methods
    void setString(String text) {this.text = text;}
    String getString() {return text;}


    //Constructor for cards with HashMap because some cards have more than one action.
    public ChanceCard(String text) {
        this.text = text;
        actions = new HashMap<String, Integer>();
    }

    //Method for giving cards the action(s) associated with the card.
    public void addAction(String action, int value) {
         actions.put(action, value);
     }


     //Possible actions for the chance cards.
    public void doActions(PlayerController playerController, ChanceDeck deck, Board board)
    {
        for (Map.Entry<String,Integer> entry : this.actions.entrySet())
        {
            String action = entry.getKey();
            int value = entry.getValue();

            if(action.equals("Money"))
            {
                playerController.getCurrentPlayer().updateWallet(value);
            }
            if(action.equals("Birthday money"))
            {
                for (Player p : playerController.getAllPlayers()) {
                    playerController.getCurrentPlayer().updateWallet(value);
                    p.updateWallet(-value);
                }
            }
            if(action.equals("Escape jail"))
            {
                playerController.getCurrentPlayer().setJail(true);
            }
            if(action.equals("Move to place"))
            {
                playerController.getCurrentPlayer().setPos(value, board);
            }
            if(action.equals("Move up to 5"))
            {
                playerController.getCurrentPlayer().updatePos(board.askMoveUpto5(),board);
            }
            if(action.equals("Move"))
            {
                playerController.getCurrentPlayer().updatePos(value, board);
            }
            if(action.equals("Move to one of two colors"))
            {
                String answer = board.askMoveToColor(value);
                switch (answer){
                    case "Orange":
                        playerController.getCurrentPlayer().setPos(10, board);
                        break;
                    case "Green":
                        playerController.getCurrentPlayer().setPos(19, board);
                        break;
                    case "Pink":
                        playerController.getCurrentPlayer().setPos(7, board);
                        break;
                    case "Dark Blue":
                        playerController.getCurrentPlayer().setPos(22, board);
                        break;
                    case "Light Blue":
                        playerController.getCurrentPlayer().setPos(4, board);
                        break;
                    case "Red":
                        playerController.getCurrentPlayer().setPos(13, board);
                        break;
                    case "Brown":
                        playerController.getCurrentPlayer().setPos(1,board);
                        break;
                    case "Yellow":
                        playerController.getCurrentPlayer().setPos(16,board);
                }
            }
            if (action.equals("Move or draw"))
            {
                String answer = board.askMoveOrDraw();
                if (answer == "Move"){
                    playerController.getCurrentPlayer().updatePos(value,board);
                } else if (answer == "Draw"){
                    deck.draw(playerController, board);
                }
            }
            if(action.equals("Draw"))
            {
                deck.draw(playerController, board);
            }
        }
    }

//If else statements for each action when "processing" the cards, used for later, needs to be a loop with a for each loop.
   /*  if (action.equals("bank money")){
        //update user's money with value
    }else if (action.equals("birthday money")){
        //update user's money with value*number of players
    }else if (action.equals("move")){
        //update user's position with value
    }else if (action.equals("Escape jail")){
        //give the user the getoutofjailfreecard
    } else if (action.equals("...")){
        //whatever
    }*/
}
