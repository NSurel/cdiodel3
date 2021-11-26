package Tests;

import org.junit.jupiter.api.Test;
import utils.Board;
import utils.ChanceDeck;
import utils.FieldController;
import utils.PlayerController;

import java.io.FileNotFoundException;

class ChanceDeckTest {

    /*Tests the draw method in the chance deck to see if it is possible to draw 100 cards from it.
    Constructs a new chance deck, a new field controller, a new board and a new player controller.
     */
    @Test
    void testDraw() throws FileNotFoundException {
        ChanceDeck testChanceDeck = new ChanceDeck();
        FieldController fieldController = new FieldController();
        Board board = new Board(24,fieldController.getFields());
        PlayerController playerController = new PlayerController();
        playerController.createPLayers(board);
        /*
        With a for loop, we draw a card one hundred times.
         */
        for (int i = 0; i > 100; i++){
            testChanceDeck.draw(playerController,board);
        }
    }

}