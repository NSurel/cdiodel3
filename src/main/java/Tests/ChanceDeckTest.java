package Tests;

import org.junit.jupiter.api.Test;
import utils.Board;
import utils.ChanceDeck;
import utils.FieldController;
import utils.PlayerController;

import java.io.FileNotFoundException;

class ChanceDeckTest {

    @Test
    void testDraw() throws FileNotFoundException {
        ChanceDeck testChanceDeck = new ChanceDeck();
        FieldController fieldController = new FieldController();
        Board board = new Board(24,fieldController.getFields());
        PlayerController playerController = new PlayerController();
        playerController.createPlayers(board);
        for (int i = 0; i > 100; i++){
            testChanceDeck.draw(playerController,board);
        }
    }

}