package Task_03_Composite;

import java.util.ArrayList;
import java.util.List;


public abstract class Cell {
    protected int indentDepth = 0;
    protected List<Cell> cellList;


    public Cell(){
        cellList = new ArrayList<>();

    }

    public void addCell(Cell cell) {
        cellList.add(cell);
    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public final boolean isComposite() {
        return !cellList.isEmpty();
    }


    protected String indent(int depth) {
        StringBuilder stringBuilder = new StringBuilder();

        do {
            stringBuilder.append("+ ");
        } while (depth-- > 0);

        return stringBuilder.toString();
    }

    public final void printStructure() {
        System.out.println(indent(indentDepth) +  (isComposite() ? " (node)" : " (leaf)"));
        for (Cell cell : cellList) {
            cell.indentDepth = indentDepth + 1;
            cell.printStructure();
        }
    }


}
