package utils;

import gui_fields.*;
import gui_main.GUI;
import java.awt.*;
import java.util.ArrayList;

public class Board {

    //todo
    // work on a translator with .txt file to read from

    //todo
    // change order of methods, to make more sense and make it more readable.
    // Change methods to be ready for controllers input to the GUI
    GUI_Car car0 = new GUI_Car(Color.RED, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Car car1 = new GUI_Car(Color.BLUE, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Car car2 = new GUI_Car(Color.PINK, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Car car3 = new GUI_Car(Color.YELLOW, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);
    GUI_Car[] cars = new GUI_Car[]{car0,car1,car2,car3};
    private int carNumber = 0;
    private ArrayList<GUI_Player> gui_Players = new ArrayList<>();
    private final GUI gui;
    private final GUI_Field[] gui_fields;
    GUI_Ownable[] fieldsOwned;
    GUI_Player[] players;

    public Board(int size, ArrayList<Field> fields){
        //todo
        // make a GUI_Field[] that matches the actual game one
        // with correspondings titles, subtexts, and backgroundcolors
        gui_fields = new GUI_Field[size];
        Color color = new Color(74,204,84);
        for (int i = 0; i < gui_fields.length; i++) {
            GUI_Street test = new GUI_Street();
            gui_fields[i] = test;
        }
        setFieldTexts(fields,gui_fields);
        fieldsOwned = new GUI_Ownable[size];
        for (int i = 0; i < fieldsOwned.length; i++) {
            fieldsOwned[i] = (GUI_Ownable) gui_fields[i];
        }
        gui_fields[1].setBackGroundColor(Color.RED);
        gui_fields[2].setBackGroundColor(Color.RED);
        gui = new GUI(gui_fields,color);

    }

    public void msg (String msg){
        gui.showMessage(msg);
    }



    //Set the gui fields titles and subtext to the same as the field[]'s.
    public void setFieldTexts(ArrayList<Field> fields, GUI_Field[] gui_fields){
        for (int i = 0; i < fields.size(); i++) {
            gui_fields[i].setTitle(fields.get(i).getName());
            gui_fields[i].setDescription(fields.get(i).getSubtext());
            gui_fields[i].setSubText(String.valueOf(fields.get(i).getRent()));
            if (fields.get(i).getRent()==0)
            {
                gui_fields[i].setSubText("");
            }
        }
    }

    public String getPlayerName(String playerAndNumber){
        return gui.getUserString(playerAndNumber + " please type in your name");
    }

    public int setPlayerAmount(){
        return Integer.valueOf(gui.getUserSelection("how many players?", "2", "3", "4"));
    }


    public void addGuiPlayer(Player player)
    {

        GUI_Player guiPlayer = new GUI_Player(player.getName(),35,cars[carNumber]);
        gui.addPlayer(guiPlayer);
        gui_fields[0].setCar(guiPlayer,true );
        gui_Players.add(guiPlayer);
        carNumber++;
    }

    //todo
    // change to find the Player's location and not GUI_Player
    //
    public int getLocation(GUI_Player player){
        int i = 0;
        while(!gui_fields[i].hasCar(player)){
            i++;
        }
        return i;
    }


    public void moveGui_Player(Player player,GUI_Player gui_player,int spaces){
        gui.setDie(spaces);
        gui_fields[getLocation(gui_player)].setCar(gui_player, false);
        gui_fields[player.getPos()].setCar(gui_player,true);
    }

    public GUI_Player getGui_player(int player){

        return gui_Players.get(player-1);
        //return players[player-1];
    }

    public void displayChancecard(String msg){
        gui.displayChanceCard(msg);
    }

    public String askMoveOrDraw(){return gui.getUserSelection("Move or draw?","Move","Draw");}

    public int askMoveUpto5() { return Integer.parseInt(gui.getUserSelection("How fare do you want to move?", "1","2","3","4","5"));}

    public void updateOwner(int player, int fieldnum){
        fieldsOwned[fieldnum].setBorder(getGui_player(player).getPrimaryColor());
    }


    //todo
    // display chancecard method that takes a string as input and shows the players
    // update gui player score from the player's score
    // update fieldowner
}
