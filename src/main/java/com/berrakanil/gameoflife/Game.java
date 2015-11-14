package com.berrakanil.gameoflife;

import static java.lang.Thread.sleep;

/**
 * Created by Berrak on 22/09/2015.
 */
public class Game {

    public static void main(String[] args) {
        System.out.println("com.berrakanil.gameoflife.Game of Life");

        Cell[] liveCellsNext = new Cell[18];

        int totalCells = 0;

        /*Sample pattern*/
        for (int i = 3; i != 6; i++) {
            for (int j = 3; j != 6; j++) {
                liveCellsNext[totalCells++] = new Cell(i, j, Cell.ALIVE);
                liveCellsNext[totalCells++] = new Cell(i + 3, j + 3, Cell.ALIVE);
            }
        }
        Grid gridNext = new Grid(12,12,liveCellsNext);

        while(true) {
            gridNext.print();
            gridNext = gridNext.nextGeneration();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
