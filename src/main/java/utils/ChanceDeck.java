package utils;

import java.util.List;
import java.util.Random;

public class ChanceDeck {

    private List<ChanceCard> chanceDeck;
    private int numberOfCardsDrawn;

    public ChanceDeck()
    {
        PopulateDeck();
        shuffle();
    }
    //Constructing the cards and giving them their actions too.
    public void PopulateDeck() {
        ChanceCard Birthday = new ChanceCard("It is your birthday! You receive 1 money from each other player");
        Birthday.addAction("Birthday money", 1);
        Birthday.addAction("Take money", -1);
        chanceDeck.add(Birthday);

        ChanceCard Candy = new ChanceCard("You ate too much candy and must pay!");
        Candy.addAction("Money", -2);
        chanceDeck.add(Candy);

        ChanceCard Homework = new ChanceCard("You did all your homework!");
        Homework.addAction("Money", 2);
        chanceDeck.add(Homework);

        ChanceCard SkatePark = new ChanceCard("Move to the skate park and buy it if it is vacant. Otherwise, pay rent to the owner.");
        SkatePark.addAction("Move to", 10);
        chanceDeck.add(SkatePark);

        ChanceCard Boardwalk = new ChanceCard("Move to the boardwalk.");
        Boardwalk.addAction("Move to", 23);
        chanceDeck.add(Boardwalk);

        ChanceCard Go = new ChanceCard("Move to the boardwalk.");
        Go.addAction("Move to", 0);
        chanceDeck.add(Go);

        ChanceCard getoutofjailfreecard = new ChanceCard("You are free to leave the jail!");
        getoutofjailfreecard.addAction("Escape jail", 1);
        chanceDeck.add(getoutofjailfreecard);

    }

    private void shuffle()
    {
        Random random = new Random();

        // start from the end of the list
        for (int i = chanceDeck.size() - 1; i >= 1; i--)
        {
            // get a random index `j` such that `0 <= j <= i`
            int j = random.nextInt(i + 1);

            // swap element at i'th position in the list with the element at
            // randomly generated index `j`
            ChanceCard chanceCard = chanceDeck.get(i);
            chanceDeck.set(i, chanceDeck.get(j));
            chanceDeck.set(j, chanceCard);
        }
    }
}
