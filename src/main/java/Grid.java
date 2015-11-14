import java.util.ArrayList;
import java.util.List;

/**
 * Created by Berrak on 21/09/2015.
 */
public class Grid {
    private final boolean ALIVE = true;
    private final boolean DEAD = false;

    private int rowSize;
    private int colSize;
    private Cell[][] cells;

    public Grid(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        initGrid();
    }

    public Grid(int rowSize, int colSize, Cell[] liveCells) {
        this.rowSize = rowSize;
        this.colSize = colSize;

        initGrid();
        for(Cell c : liveCells) {
            cells[c.getRow()][c.getCol()] = c;
        }
    }

    public void initGrid() {
        cells =  new Cell[rowSize][colSize];
        for(int i = 0; i < rowSize; ++i) {
            for(int j = 0; j  < colSize; ++j) {
                cells[i][j] = new Cell(i,j,DEAD);
            }
        }
    }


    public int getRowSize() {
        return rowSize;
    }

    public int getColSize() {
        return rowSize;
    }

    public List<Cell> getNeighbours(Cell cell) {
        int rowLimit = rowSize - 1;
        int colLimit = colSize - 1;
        int row = cell.getRow();
        int col = cell.getCol();
        List<Cell> neighbourList = new ArrayList<Cell>();
        for (int i = row - 1; i <= row + 1; ++i) {
            for (int j = col - 1; j <= col + 1; ++j) {
                if (i < 0 || j < 0 || i > rowLimit || j > colLimit || (i == row) && (j == col)) {
                    continue;
                }
                neighbourList.add(cells[i][j]);
            }
        }
        return neighbourList;
    }

    public int getLiveNeighboursCount(List<Cell> neighbours) {
        int count = 0;
        for(int i = 0; i < neighbours.size(); ++i) {
            Cell cell = neighbours.get(i);
            if(neighbours.get(i).isAlive()) {
                ++count;
            }
        }
        return count;
    }

    public Grid nextGeneration() {
        Grid newGrid = new Grid(rowSize,colSize);
        int liveCount = 0;
        for(int i = 0; i < rowSize; ++i) {
            for(int j = 0; j < colSize; ++j) {
                List<Cell> neighbours = getNeighbours(cells[i][j]);
                liveCount = getLiveNeighboursCount(neighbours);
                Cell newCell = cells[i][j].nextGeneration(liveCount);
                newGrid.cells[i][j] = newCell;
            }
        }
        return newGrid;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Grid that = (Grid) o;
        if(this.rowSize != that.rowSize || this.colSize != that.colSize) {
            return false;
        }

        for(int i = 0; i < rowSize; ++i) {
            for(int j = 0; j < colSize; ++j) {
                if(!this.cells[i][j].equals(that.cells[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    public void print() {
        for(int i = 0; i < rowSize; ++i) {
            String row = "";
            for(int j = 0; j < colSize; ++j) {
                if(cells[i][j].isAlive()) {
                    row += "*";
                } else {
                    row += ".";
                }
            }
            System.out.println(row);
        }
        System.out.println("");
    }
}
