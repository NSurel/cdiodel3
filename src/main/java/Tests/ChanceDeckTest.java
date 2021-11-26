package Tests;

import org.junit.jupiter.api.Test;
import utils.Board;
import utils.ChanceDeck;
import utils.FieldController;
import utils.PlayerController;

import java.io.FileNotFoundException;

class ChanceDeckTest {

    //Tests the draw method in the chance deck class to see if it is possible to draw a 100 cards without error.
    @Test
    void testDraw() throws FileNotFoundException {
        /*
        Constructs a new chance deck, field controller, bord and  player controller.
         */
        ChanceDeck testChanceDeck = new ChanceDeck();
        FieldController fieldController = new FieldController();
        Board board = new Board(24,fieldController.getFields());
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(board,fieldController);
        //The for loop draws one hundred cards from the deck.
        for (int i = 0; i > 100; i++){
            testChanceDeck.draw(playerController,board);
        }
    }

}