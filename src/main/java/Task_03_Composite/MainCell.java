package Task_03_Composite;

public class MainCell extends Cell{

    public  MainCell(){
        addSubCell();
    }

    public void addSubCell(){
        for (int i = 0; i < 100; i++) {
            addCell(new SubCell());
        }
    }
}
