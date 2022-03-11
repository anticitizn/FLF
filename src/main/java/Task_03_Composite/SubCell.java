package Task_03_Composite;

public class SubCell extends Cell{

    public  SubCell(){
        addSmallCell();
    }

    public void addSmallCell(){
        for (int i = 0; i < 10; i++) {
            addCell(new SmallCell());
        }
    }
}
