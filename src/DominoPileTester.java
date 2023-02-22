import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DominoPileTester {

    private DominoPile dominoPile;

    public void setUp() {
        dominoPile = new DominoPile();
    }

    public void tearDown() {
        dominoPile = null;
    }

    @Test
    public void testConstructor() {
        setUp();
        assertTrue("Ensure that your constructor in the DominoPile class has been implemented correctly!", dominoPile != null);
        tearDown();
    }

    @Test
    public void testGetPile() {
        setUp();
        assertTrue("Ensure that your getPile method in the DominoPile class has been implemented correctly!", dominoPile.getPile() != null);
        tearDown();
    }

    @Test
    public void testNewStack6AllDominosPresent() {
        setUp();
        int top = 0;
        int bottom = 0;
        dominoPile.newStack6();
        System.out.println(dominoPile.getPile());
        for (int i = 0; i < dominoPile.getPile().size(); i++) {
            assertTrue("Ensure that your newStack6 method in the DominoPile class has been implemented correctly!", dominoPile.getPile().get(i).getTop() == top);
            assertTrue("Ensure that your newStack6 method in the DominoPile class has been implemented correctly!", dominoPile.getPile().get(i).getBottom() == bottom);
            System.out.println("Expected Top: " + top + " Observed Top: " + dominoPile.getPile().get(i).getTop());
            System.out.println("Expected Bottom: " + bottom + " Observed bottom: " + dominoPile.getPile().get(i).getBottom());
            if (bottom == 6) {
                top++;
                bottom = top;
            }
            else {
                bottom++;
            }
        }

        tearDown();
    }

    @Test
    public void testNewStack6AllNoDuplicates() {
        setUp();
        dominoPile.newStack6();
        System.out.println(dominoPile.getPile().size());
        assertTrue("Ensure that your newStack6 method in the DominoPile class has been implemented correctly!", dominoPile.getPile().size() == 28);
        tearDown();
    }

    /** Note that there is a very small probability that this test fails on a correct implementation.
     *  This is because there is a very small chance that the call to shuffleOptionOne produces a
     *  result that shuffles the tiles into the same order as they were originally.
     *  This would cause this test to fail, despite the implementation of shuffleOptionOne being correct.
     */
   @Test
   public void testShuffleOptionOne() {
        setUp();
        dominoPile.newStack6();
        dominoPile.shuffleOptionOne();
        int top = 0;
        int bottom = 0;
        boolean allInSameOrder = true;
        for (int i = 0; i < dominoPile.getPile().size(); i++) {
            if (!(dominoPile.getPile().get(i).getTop() == top && dominoPile.getPile().get(i).getBottom() == bottom)) allInSameOrder = false;

            if (bottom == 6) {
                top++;
                bottom = top;
            }

            bottom++;
        }
       assertTrue("Ensure that your shuffleOption1 method in the DominoPile class has been implemented correctly!", !allInSameOrder);
   }

}
