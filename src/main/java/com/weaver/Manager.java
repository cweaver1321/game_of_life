package com.weaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Manager will use the raw inputs provided to
 * create and run the Universe. The Strategy class
 * will be provided by the calling class.
 */
public class Manager {
    private Universe universe;
    private Strategy strategy;
    private final int generations;
    private final long millisBetweenGenerations;

    public Manager(String filename, Strategy strategy, int generations, long millisBetweenGenerations) throws FileNotFoundException {
        this.strategy = strategy;
        this.universe = seedUniverseFromFile(filename);
        this.generations = generations;
        this.millisBetweenGenerations = millisBetweenGenerations;
    }

    public void start() throws InterruptedException {
        for (int i = 1; i < generations; i++) {
            this.universe.printExplicit(1, universe.getRows() - 1, 1, universe.getColumns() - 1);
            strategy.createNextGeneration(universe);
            Thread.sleep(millisBetweenGenerations);
        }
    }

    // Load seed data from file
    protected Universe seedUniverseFromFile(String filename) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File(filename));
        int rows = Integer.parseInt(inputFile.nextLine()) + 2;
        int columns = Integer.parseInt(inputFile.nextLine()) + 2 ;
        Cell[][] cells = new Cell[rows][columns];

        // Build center of universe using seed
        for(int i = 1; i < rows - 1; i++){
            String nextLine = inputFile.nextLine();
            String[] rowOfCellValues = nextLine.split("");
            for(int j = 1; j < columns - 1; j++){
                cells[i][j] = new Cell(Integer.parseInt(rowOfCellValues[j-1]));
            }
        }

        // Add top and bottom row cells to have starting value of zero
        for(int j = 0; j < columns; j++) {
            cells[0][j] = new Cell(0);
            cells[rows-1][j] = new Cell(0);
        }

        // Add the two sides
        for(int i = 1; i < rows - 1; i++) {
            cells[i][0] = new Cell(0);
            cells[i][columns-1] = new Cell(0);
        }

        return new Universe(cells, rows, columns);
    }

}
