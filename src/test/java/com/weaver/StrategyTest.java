package com.weaver;

import org.junit.Assert;

public class StrategyTest {

    @org.junit.Test
    public void setMemento() {
        // setup
        Strategy patient = new Strategy();
        Universe universe = getTestUniverseWith(0);
        universe.getCell(1,1).setCellPreviousValue(0);
        universe.getCell(1,1).setCellCurrentValue(1);

        // test and validate
        Assert.assertEquals(0, universe.getCell(1,1).getCellPreviousValue());
        patient.setMemento(universe);
        Assert.assertEquals(1, universe.getCell(1,1).getCellPreviousValue());
    }

    @org.junit.Test
    public void getNeighbors() {
        // setup
        Strategy patient = new Strategy();
        int[] expected = {0,1,2,3,4,5,6,7,8};

        // test and validate
        for(int i = 0; i < 9; i++){
            Assert.assertEquals(expected[i], patient.getNeighbors(1,1, getTestUniverseWith(i)));
        }
    }

    private Universe getTestUniverseWith(Integer neighbors){
        Cell[][] cells = new Cell[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    cells[i][j] = new Cell(0);
                } else if(neighbors > 0) {
                    cells[i][j] = new Cell(1);
                    neighbors--;
                } else {// no neighbors are left
                    cells[i][j] = new Cell(0);
                }
            }
        }
        return new Universe(cells, 3, 3);
    }

    @org.junit.Test
    public void findNewCellValue() {
        // setup
        Strategy patient = new Strategy();
        int[][] expected = {{0,0,0,1,0,0,0,0,0},{0,0,1,1,0,0,0,0,0}};

        // test and validate
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 9; j++){
                Assert.assertEquals(expected[i][j], patient.findNewCellValue(i, j));
            }
        }
    }
}