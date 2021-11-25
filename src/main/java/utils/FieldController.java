package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FieldController {
    private Field[] fields;
    private Field field;


    public FieldController(){
        this.fields = new Field[24];
    }

    public String getCurrentField(){
        return field.getName();
    }
   /* public void setCurrentField(String Fields){
        fields.setName(Fields);

    }*/
    public static void initializeFields(FieldController fields) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("TestTranslate.txt"));
        if (fields.getFields().length != 24){
            throw new IllegalArgumentException("Board is not the right size");
        }
        for (int i = 0; i < fields.getFields().length ; i++) {
            switch (i){
                case 0:
                    //the names should be read from a file
                    fields.getFields()[0]= new Start(reader.readLine(), reader.readLine());
                    break;
                case 3:
                case 9:
                case 15:
                case 21:
                    fields.getFields()[i] = new Property( reader.readLine(), reader.readLine(),2,null);
                    break;
                case 18:
                    fields.getFields()[i] = new Jail(reader.readLine(), reader.readLine(), false);
                    break;
                case 6:
                    fields.getFields()[i] = new Jail(reader.readLine(), reader.readLine(), true);
                    break;
                default:
                    fields.getFields()[i]= new Property(reader.readLine(),reader.readLine(),1,null );
                    break;
            }


        }
        reader.close();
    }

    public Field[] getFields() {
        return fields;
    }
    /*public String getCurrentOwner(){
        return fields.getOwner();
    }
    public void setCurrentOwner(String owner){
        fields.setOwner(owner);
    }*/

    //TODO
    // Make an initilazier for the fields.
    // DO it right - MW.
}
