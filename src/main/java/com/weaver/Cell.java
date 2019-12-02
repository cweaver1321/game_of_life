package com.weaver;

public class Cell {
    private int cellCurrentValue;
    // Memento
    private int cellPreviousValue;

    public Cell(int cellCurrentValue){
        this.cellCurrentValue = validate(cellCurrentValue);
        this.cellPreviousValue = validate(cellCurrentValue);
    }

    public int getCellCurrentValue(){
        return cellCurrentValue;
    }

    public void setCellCurrentValue(int cellCurrentValue){
        this.cellCurrentValue = validate(cellCurrentValue);
    }

    public int getCellPreviousValue(){
        return cellPreviousValue;
    }

    public void setCellPreviousValue(int cellPreviousValue){
        this.cellPreviousValue = validate(cellPreviousValue);
    }

    // simple validator to keep constructor clean
    protected int validate(int cellValue) {
        if(!(cellValue==1 || cellValue==0))
            throw new IllegalArgumentException("Cell Values must be 0 or 1");
        return cellValue;
    }

    // helper print function
    public String printCell(){
        return (cellCurrentValue ==0?".":"*");
    }
}
