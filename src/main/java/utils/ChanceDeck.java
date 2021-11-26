package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChanceDeck {

    private List<ChanceCard> chanceDeck;
    private int numberOfCardsDrawn;

    //Constructor for the chance deck.
    public ChanceDeck()
    {
        numberOfCardsDrawn = 0;
        chanceDeck = new ArrayList<ChanceCard>();
        PopulateDeck();
        shuffle();
    }

    //Constructing the cards and giving them their actions while adding them to the chanceDeck list.
    public void PopulateDeck() {

        //Money cards
        ChanceCard Candy = new ChanceCard("You ate too much candy and must pay!");
        Candy.addAction("Money", -2);
        chanceDeck.add(Candy);

        ChanceCard Homework = new ChanceCard("You did all your homework!");
        Homework.addAction("Money", 2);
        chanceDeck.add(Homework);

        ChanceCard Birthday = new ChanceCard("It is your birthday! You receive 1 money from each other player");
        Birthday.addAction("Birthday money", 1);
        chanceDeck.add(Birthday);

        //Get out of jail free card
        ChanceCard getoutofjailfreecard = new ChanceCard("You are free to leave the JAIL!");
        getoutofjailfreecard.addAction("Escape jail", 0);
        chanceDeck.add(getoutofjailfreecard);

        //Move to a place cards
        ChanceCard Go = new ChanceCard("Move to GO and collect 2 DD!");
        Go.addAction("Move to place", 0);
        Go.addAction("Money", 2);
        chanceDeck.add(Go);

        ChanceCard SkatePark = new ChanceCard("Move to the SKATE PARK and buy it if it is vacant. Otherwise, pay rent to the owner.");
        SkatePark.addAction("Move to place", 0);
        chanceDeck.add(SkatePark);

        ChanceCard Boardwalk = new ChanceCard("Move to the BOARDWALK.");
        Boardwalk.addAction("Move to place", 0);
        chanceDeck.add(Boardwalk);

        //Special move cards
        ChanceCard Move5 = new ChanceCard("You may move up to 5 spaces.");
        Move5.addAction("Move up to 5", 0);
        chanceDeck.add(Move5);

        ChanceCard MoveOrDraw = new ChanceCard("Move 1 space or draw a card.");
        MoveOrDraw.addAction("Move or draw", 1);
        chanceDeck.add(MoveOrDraw);

        //Move to a specific color
        ChanceCard MoveToOrange = new ChanceCard("Move to an orange space. If the space is vacant then buy it, if not then pay the owner rent.");
        MoveToOrange.addAction("Move to place", 13);
        chanceDeck.add(MoveToOrange);

        ChanceCard MoveToRed = new ChanceCard("Move to a red space. If the space is vacant then buy it, if not then pay the owner rent.");
        MoveToOrange.addAction("Move to place", 1);
        chanceDeck.add(MoveToRed);

        ChanceCard MoveToLightBlue = new ChanceCard("Move to a light blue space. If the space is vacant then buy it, if not then pay the owner rent.");
        MoveToOrange.addAction("Move to place", 16);
        chanceDeck.add(MoveToLightBlue);

        //Move to one of two colors
        ChanceCard MoveToOrangeOrGreen = new ChanceCard("Move to an orange or green space. If the space is vacant then buy it, if not then pay the owner rent.");
        MoveToOrange.addAction("Move to one of two colors", 0);
        chanceDeck.add(MoveToOrangeOrGreen);

        ChanceCard MoveToPinkOrDarkBlue = new ChanceCard("Move to a pink or dark blue space. If the space is vacant then buy it, if not then pay the owner rent.");
        MoveToOrange.addAction("Move to one of two colors", 1);
        chanceDeck.add(MoveToPinkOrDarkBlue);

        ChanceCard MoveToLightBlueOrRed = new ChanceCard("Move to a light blue or red space. If the space is vacant then buy, if not then pay the owner rent.");
        MoveToOrange.addAction("Move to one of two colors", 2);
        chanceDeck.add(MoveToLightBlueOrRed);

        ChanceCard MoveToBrownOrYellow = new ChanceCard("Move to a brown or yellow space. If the space is vacant then buy, if not then pay the owner rent.");
        MoveToOrange.addAction("Move to one of two colors", 3);
        chanceDeck.add(MoveToBrownOrYellow);

        //Player cards
        /*ChanceCard CarCard = new ChanceCard("Give this card to the car player and draw a card. On the car player's next turn, that player moves to any a vacant space and buys it. If there isn't any vacant field then buy one from another player.");
        CarCard.addAction("Give card", 0);
        CarCard.addAction("Draw",0 );
        chanceDeck.add(CarCard);

        ChanceCard ShipCard = new ChanceCard("Give this card to the ship player and draw a card. On the ship player's next turn, that player moves to any vacant space and buys it. If there isn't any vacant field then buy one from another player.");
        ShipCard.addAction("Give card", 0);
        ShipCard.addAction("Draw",0 );
        chanceDeck.add(ShipCard);

        ChanceCard CatCard = new ChanceCard("Give this card to the cat player and draw a card. On the cat player's next turn, that player moves to any vacant space and buys it. If there isn't any vacant field then buy one from another player.");
        CatCard.addAction("Give card", 0);
        CatCard.addAction("Draw",0 );
        chanceDeck.add(CatCard);

        ChanceCard DogCard = new ChanceCard("Give this card to the dog player and draw a card. On the dog player's next turn, that player moves to any vacant space and buys it. If there isn't any vacant field then buy one from another player.");
        DogCard.addAction("Give card", 0);
        DogCard.addAction("Draw",0 );
        chanceDeck.add(DogCard);*/
    }

    //Method for shuffling the deck randomly.
    private void shuffle()
    {
        Random random = new Random();

        //for loop of the size of the deck where i decrements
        for (int i = chanceDeck.size() - 1; i >= 1; i--)
        {
            //Make a new random index so 0 <= i <= j
            int j = random.nextInt(i + 1);

            //puts a random card for the next position
            ChanceCard chanceCard = chanceDeck.get(i);
            chanceDeck.set(i, chanceDeck.get(j));
            chanceDeck.set(j, chanceCard);
        }
    }

    //Method for drawing cards from the chance deck. If all cards (20) are drawn the deck is reshuflled.
    public void draw(PlayerController playerController, Board board)
    {
        if (numberOfCardsDrawn >= 20){
            shuffle();
            numberOfCardsDrawn = 0;
        }
        numberOfCardsDrawn++;
        ChanceCard drawnCard = chanceDeck.get(numberOfCardsDrawn);
        drawnCard.doActions(playerController, this, board);
        board.displayChancecard(drawnCard.getString());
    }
}
