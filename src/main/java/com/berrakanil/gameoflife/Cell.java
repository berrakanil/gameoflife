package com.berrakanil.gameoflife;

/**
 * Created by Berrak on 21/09/2015.
 */
public class Cell {

    public static boolean ALIVE = true;
    public static boolean DEAD = false;

    private int row;
    private int col;
    private boolean status;

    public Cell(int row, int col, boolean status) {
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAlive() {
        return status;
    }

    public Cell nextGeneration(int neighbourCount) {
        Cell cell = new Cell(row,col,status);
        if(cell.isAlive()) {
            if (neighbourCount < 2 || neighbourCount > 3) {
                cell.setStatus(DEAD);
            }
        } else {
            if(neighbourCount == 3) {
                cell.setStatus(ALIVE);
            }
        }
        return cell;
    }

    @Override
    public String toString() {
        return "(" + row + "," + col + ") -> " + isAlive();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell that = (Cell) o;

        if(this.getRow() == that.getRow() && this.getCol() == that.getCol()) {
            return true;
        }

        return false;
    }
}
