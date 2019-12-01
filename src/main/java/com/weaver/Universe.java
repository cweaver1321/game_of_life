package com.weaver;

public class Universe {
    private Cell[][] cells;
    private int rows;
    private int columns;

    public Universe(Cell[][] cells, int rows, int columns){
        this.cells = cells;
        this.rows = rows;
        this.columns = columns;
    }

    public Cell getCell(int row, int columns){
        return cells[row][columns];
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void print(){
        printExplicit(0, rows, 0, columns);
    }

    public void printExplicit(int rowStart, int rowEnd, int columnStart, int columnEnd){

        printGenerationSeparator(columnStart, columnEnd);
        for(int i = rowStart; i < rowEnd; i++) {
            for (int j = columnStart; j < columnEnd; j++)
                System.out.print(cells[i][j].printCell());
            System.out.println();
        }
        printGenerationSeparator(columnStart, columnEnd);
    }

    protected void printGenerationSeparator(int columnStart, int columnEnd) {
        for (int j = columnStart; j < columnEnd; j++)
            System.out.print("_");
        System.out.println();
    }

}
