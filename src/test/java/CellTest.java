/**
 * Created by Berrak on 21/09/2015.
 */
import org.junit.*;

import static junit.framework.Assert.*;

public class CellTest {
    private static final boolean ALIVE = true;
    private static final boolean DEAD = false;

    @Test
    public void testgetRowWhenCellIsCreatedWithRowFiveThenItWillReturnFive(){
        Cell cell = new Cell(5,0,ALIVE);
        assertEquals(5,cell.getRow());
    }


    @Test
    public void testgetRowWhenCellIsCreatedWithRowThreeThenItWillReturnThree(){
        Cell cell = new Cell(3,0,DEAD);
        assertEquals(3,cell.getRow());
    }


    @Test
    public void testgetColWhenCellIsCreatedWithColFiveThenItWillReturnFive(){
        Cell cell = new Cell(0,5,DEAD);
        assertEquals(5,cell.getCol());
    }

    @Test
    public void testSetStatusWhenCellIsAliveThenItWillReturnTrue(){
        Cell cell = new Cell(0,5,ALIVE);
        assertTrue(cell.isAlive());
    }

    @Test
    public void testSetStatusWhenCellIsDeadThenItWillReturnFalse(){
        Cell cell = new Cell(0,5,DEAD);
        assertFalse(cell.isAlive());
}

    @Test
    public void testNextGenerationWhenLiveCellHasLessThanTwoNeighbourItWillBeDead(){
        Cell cell = new Cell(0,4,ALIVE);
        Cell newCell = cell.nextGeneration(1);
        assertFalse(newCell.isAlive());
    }

    @Test
    public void testNextGenerationWhenLiveCellHasTwoNeighbourItWillBeAlive(){
        Cell cell = new Cell(0,4,ALIVE);
        Cell newCell = cell.nextGeneration(2);
        assertTrue(newCell.isAlive());
    }

    @Test
    public void testNextGenerationWhenLiveCellHasThreeNeighbourItWillBeAlive(){
        Cell cell = new Cell(0,4,ALIVE);
        Cell newCell = cell.nextGeneration(2);
        assertTrue(newCell.isAlive());
    }

    @Test
    public void testNextGenerationWhenLiveCellHasMoreThanThreeNeighbourItWillBeDead(){
        Cell cell = new Cell(0,4,ALIVE);
        Cell newCell = cell.nextGeneration(4);
        assertFalse(newCell.isAlive());
    }

    @Test
    public void testNextGenerationWhenDeadCellHasThreeNeighbourItWillBeAlive(){
        Cell cell = new Cell(0,4,DEAD);
        Cell newCell = cell.nextGeneration(3);
        assertTrue(newCell.isAlive());
    }

    @Test
    public void testNextGenerationWhenDeadCellHasTwoNeighbourItWillBeDead(){
        Cell cell = new Cell(0,4,DEAD);
        Cell newCell = cell.nextGeneration(2);
        assertFalse(newCell.isAlive());
    }
}
