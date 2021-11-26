package utils;
import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class FieldController {
    private ArrayList<Field> fields;


    public FieldController() throws FileNotFoundException {
        fields = new ArrayList<>();
        Scanner s = new Scanner(new File("Fields.txt"));
        while (s.hasNextLine()) {
            String line =  s.nextLine();
            String fieldName = line.split(",")[1];
            String fieldTxt = line.split(",")[2];
            if (line.startsWith("Start"))
            {
                Start start = new Start(fieldName,fieldTxt);
                fields.add(start);
            }
            if (line.startsWith("Jail"))
            {
                boolean visiting = Boolean.valueOf(line.split(",")[3]);
                Jail jail = new Jail(fieldName,fieldTxt,visiting);
                fields.add(jail);
            }
            if (line.startsWith("Property"))
            {
                int propertyRent = Integer.parseInt(line.split(",")[3]);
                String color = line.split(",")[4];
                Property newProperty = new Property(fieldName,fieldTxt,propertyRent,null,color);
                fields.add(newProperty);
            }
            if (line.startsWith("ChanceField"))
            {
                ChanceField chanceField = new ChanceField(fieldName ,fieldTxt);
                fields.add(chanceField);
            }
        }
        s.close();
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    /*public String getCurrentField(){
        return field.getName();
    }
    public void setCurrentField(String Fields){
        field.setName(Fields);

    }
    public String getCurrentOwner(){
        return field.getOwner();
    }
    public void setCurrentOwner(String owner){
        field.setOwner(owner);
    }*/
}
