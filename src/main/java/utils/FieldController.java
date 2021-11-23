package utils;

public class FieldController {
    private Field field;


    public FieldController(Field field){
        this.field = field;
    }

    public String getCurrentField(){
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
    }
}
