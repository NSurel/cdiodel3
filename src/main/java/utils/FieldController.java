package utils;

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
    private void initializeFields(Field[] fields){
        if (fields.length != 24){
            throw new IllegalArgumentException("Board is not the right size");
        }
        for (int i = 0; i < fields.length; i++) {
            switch (i){
                case 0:
                    //the names should be read from a file
                    fields[0]= new Start("name", "get 2");
                    break;
                case 3:
                case 9:
                case 15:
                case 21:
                    //fields[i] = new Chancefield( "readfrom file", draw)
                    break;
                case 18:
                    fields[i] = new Jail("name", "subtext", false);
                    break;
                case 6:
                    fields[i] = new Jail("name", "subtext", true);
                    break;
                default:
                   // fields[i]= new Property(i,, 3 );
                    break;
            }

        }
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
