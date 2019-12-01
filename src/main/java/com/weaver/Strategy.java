package com.weaver;

public class Strategy {

    public void createNextGeneration(Universe universe){
        Cell cell;
        int cellValue;
        for(int i = 1; i < universe.getRows() - 1; i++){
            for(int j = 1; j < universe.getColumns() - 1; j++){
                cell = universe.getCell(i,j);
                int neighbors = getNeighbors(i,j,universe);
                // using the cell value memento set the cell value
                cellValue = findNewCellValue(cell.getPreviousCellValue(), neighbors);
                cell.setCellCurrentValue(cellValue);
            }
        }
        // once all updates are made update the memento for the next generation
        setMemento(universe);
    }

    protected void setMemento(Universe universe) {
        Cell cell;
        for(int i = 1; i < universe.getRows() - 1; i++){
            for(int j = 1; j < universe.getColumns() - 1; j++){
                cell = universe.getCell(i,j);
                cell.setPreviousCellValue(cell.getCellCurrentValue());
            }
        }
    }

    protected int getNeighbors(int row, int column, Universe universe) {
        int counter = 0, iterations = 0;
        for (int i = row - 1; i <= row + 1; i++){
            for (int j = column - 1; j <= column + 1; j++) {
                if (i != row || j != column) {
                    // get previous as we are updating the current cell value
                    counter = counter + universe.getCell(i, j).getPreviousCellValue();
                }
            }
        }
        return counter;
    }

    protected int findNewCellValue(int cellValue, int neighbors) {
        int newCellValue = cellValue; // in case it does not change
        if(cellValue==(1)){
            if(neighbors < 2 || neighbors > 3) // under/over population
                newCellValue = 0;
        }
        else {
            if (neighbors == 3) // reproduction
                newCellValue = 1;
        }
        return newCellValue;
    }
}
