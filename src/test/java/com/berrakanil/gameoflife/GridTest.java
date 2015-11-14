package com.berrakanil.gameoflife; /**
 * Created by Berrak on 21/09/2015.
 */

import com.berrakanil.gameoflife.Cell;
import com.berrakanil.gameoflife.Grid;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class GridTest {
    private final boolean ALIVE = true;
    private final boolean DEAD = false;
    @Test
    public void testGetRowSize() {
        Grid grid = new Grid(5,5);
        assertEquals(5,grid.getRowSize());
    }

    @Test
    public void testGetColSize() {
        Grid grid = new Grid(5,5);
        assertEquals(5,grid.getColSize());
    }

    @Test
    public void testGetNeighboursWhenCellCoordinatesAreZeroZeroThenItWillReturnNeighbours(){
        Grid grid = new Grid(5,5);
        Cell cell = new Cell(0,0,DEAD);
        List<Cell> neighbourList = new ArrayList<Cell>();
        neighbourList.add(new Cell(0,1,DEAD));
        neighbourList.add(new Cell(1,0,DEAD));
        neighbourList.add(new Cell(1,1,DEAD));
        assertEquals(grid.getNeighbours(cell), neighbourList);
    }



    @Test
    public void testGetNeighboursWhenGridRowSizeIsFiveEightAndCellCoordinatesAreZeroZeroThenItWillReturnNeighbours(){
        Grid grid = new Grid(5,8);
        Cell cell = new Cell(0,0,DEAD);
        List<Cell> neighbourList = new ArrayList<Cell>();
        neighbourList.add(new Cell(0,1,DEAD));
        neighbourList.add(new Cell(1,0,DEAD));
        neighbourList.add(new Cell(1,1,DEAD));
        assertEquals(grid.getNeighbours(cell), neighbourList);
    }

    @Test
    public void testGetNeighboursWhenCellCoordinatesAreTwoThreeThenItWillReturnNeighbours(){
        Grid grid = new Grid(4,4);
        Cell cell = new Cell(2,3,DEAD);
        List<Cell> neighbourList = new ArrayList<Cell> ();
        neighbourList.add(new Cell(1,2,DEAD));
        neighbourList.add(new Cell(1,3,DEAD));
        neighbourList.add(new Cell(2,2,DEAD));
        neighbourList.add(new Cell(3,2,DEAD));
        neighbourList.add(new Cell(3,3,DEAD));
        assertEquals(grid.getNeighbours(cell), neighbourList);
    }

    @Test
    public void testGetLiveNeighboursCountWhenCellHasTwoLiveCellsThenItWillReturnTwo() {
        Cell[] liveCells = new Cell[2];
        liveCells[0] = new Cell(0,1,ALIVE);
        liveCells[1] = new Cell(1,0,ALIVE);
        Grid grid = new Grid(5,5,liveCells);
        Cell cell = new Cell(0,0,ALIVE);
        assertEquals(2,grid.getLiveNeighboursCount(grid.getNeighbours(cell)));
    }

    @Test
    public void testGetLiveNeighboursCountWhenCellHasThreeLiveCellsThenItWillReturnThree() {
        Cell[] liveCells = new Cell[3];
        liveCells[0] = new Cell(0,1,ALIVE);
        liveCells[1] = new Cell(1,0,ALIVE);
        liveCells[2] = new Cell(1,1,ALIVE);
        Grid grid = new Grid(5,5,liveCells);
        Cell cell = new Cell(0,0,ALIVE);
        assertEquals(3,grid.getLiveNeighboursCount(grid.getNeighbours(cell)));
    }

    @Test
    public void testNextGeneration() {
        Cell[] liveCells = new Cell[3];
        liveCells[0] = new Cell(2,1,ALIVE);
        liveCells[1] = new Cell(2,2,ALIVE);
        liveCells[2] = new Cell(2,3,ALIVE);
        Grid grid = new Grid(5,5,liveCells);

        Cell[] liveCellsNext = new Cell[3];
        liveCellsNext[0] = new Cell(1,2,ALIVE);
        liveCellsNext[1] = new Cell(2,2,ALIVE);
        liveCellsNext[2] = new Cell(3,2,ALIVE);
        Grid gridNext = new Grid(5,5,liveCellsNext);

        assertEquals(gridNext,grid.nextGeneration());
    }

}
