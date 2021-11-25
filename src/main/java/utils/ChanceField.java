package utils;

public class ChanceField extends Field
{
    public ChanceField(String subtext, String owner, boolean isVisiting)
    {
        super("ChanceField", subtext,  owner, false);
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
