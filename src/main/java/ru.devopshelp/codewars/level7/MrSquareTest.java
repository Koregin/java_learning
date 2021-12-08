package codewars.level7;

import org.junit.Test;

import static org.junit.Assert.*;

public class MrSquareTest {
    @Test
    public void fixedTtest() {
        assertEquals(true, MrSquare.fitIn(1, 2, 3, 2));
        assertEquals(false, MrSquare.fitIn(1, 2, 2, 1));
        assertEquals(false, MrSquare.fitIn(3, 2, 3, 2));
        assertEquals(false, MrSquare.fitIn(1, 2, 1, 2));
        assertEquals(false, MrSquare.fitIn(6, 5, 8, 7));
    }
}