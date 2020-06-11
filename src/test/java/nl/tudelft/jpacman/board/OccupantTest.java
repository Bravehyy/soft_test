package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        assertThat(unit).isNotNull();
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Square squre=new BasicSquare();
        unit.occupy(squre);
        assertThat(unit.getSquare()).isEqualTo(squre);
        assertThat(squre.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
    	//arrange:GIVEN
    	Square squre=new BasicSquare();
    	//act:WHEN
        unit.occupy(squre);
        unit.occupy(squre);
        //assert:THEN
        assertThat(unit.getSquare()).isEqualTo(squre);
        assertThat(squre.getOccupants()).contains(unit).containsOnlyOnce(unit); 
    }
}
