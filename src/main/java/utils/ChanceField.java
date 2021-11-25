package utils;

public class ChanceField extends Field
{
    public ChanceField(String title, String subtext)
    {
        super(title, subtext, "", false);
    }


    @Override
    public int getRent() {
        return 0;
    }

    @Override
    public void landedOn() {

    }

    @Override
    public void landedOn(ChanceDeck chanceDeck, PlayerController playerController) {
        chanceDeck.draw(playerController);
    }
}
