import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DominoTester {

    Domino domino;
    Domino otherDomino;
    DominoPile dominoPile;

    public void setUp() {
        domino = new Domino();
        otherDomino = new Domino(6,2);
        dominoPile = new DominoPile();
        dominoPile.getPile();
    }

    public void tearDown() {
        dominoPile = null;
        otherDomino = null;
        dominoPile = null;
    }

    @Test
    public void testDominoDefaultConstructorAndGetTop() {
        setUp();
        assertTrue("Ensure that your default constructor and getTop method in the Domino class has been implemented correctly!", domino.getTop() == 0);
        tearDown();
    }

    @Test
    public void testDominoDefaultConstructorAndGetBottom() {
        setUp();
        assertTrue("Ensure that your default constructor and getBottom method in the Domino class has been implemented correctly!", domino.getBottom() == 0);
        tearDown();
    }

    @Test
    public void testDominoOverloadedConstructorAndGetTop() {
        setUp();
        assertTrue("Ensure that your default constructor and getBottom method in the Domino class has been implemented correctly!", otherDomino.getTop() == 6);
        tearDown();
    }

    @Test
    public void testDominoOverloadedConstructorAndGetBottom() {
        setUp();
        assertTrue("Ensure that your default constructor and getBottom method in the Domino class has been implemented correctly!", otherDomino.getBottom() == 2);
        tearDown();
    }


    @Test
    public void testSetTop() {
        setUp();
        domino.setTop(6);
        assertTrue("Ensure that your setTop method in the Domino class has been implemented correctly!", domino.getTop() == 6);
        tearDown();
    }

    @Test
    public void testSetTopTwo() {
        setUp();
        domino.setTop(6);
        assertTrue("Ensure that your setTop method in the Domino class has been implemented correctly!", domino.getBottom() == 0);
        tearDown();
    }

    @Test
    public void testSetBottom() {
        setUp();
        domino.setBottom(6);
        assertTrue("Ensure that your setBottom method in the Domino class has been implemented correctly!", domino.getBottom() == 6);
        tearDown();
    }

    @Test
    public void testSetBottomTwo() {
        setUp();
        domino.setBottom(6);
        assertTrue("Ensure that your setBottom method in the Domino class has been implemented correctly!", domino.getTop() == 0);
        tearDown();
    }

    @Test
    public void testFlip() {
        setUp();
        domino.setBottom(6);
        domino.flip();
        assertEquals("Ensure that your flip method in the Domino class has been implemented correctly!", 6, domino.getTop());
        tearDown();
    }

    @Test
    public void testFlipTwo() {
        setUp();
        domino.setBottom(6);
        domino.flip();
        assertEquals("Ensure that your flip method in the Domino class has been implemented correctly!", 0, domino.getBottom());
        tearDown();
    }

    @Test
    public void testSettle() {
        setUp();
        domino.setTop(6);
        domino.setBottom(5);
        domino.settle();
        assertEquals("Ensure that your settle method in the Domino class has been implemented correctly!", 5, domino.getTop());
        tearDown();
    }

    @Test
    public void testSettleTwo() {
        setUp();
        domino.setTop(6);
        domino.setBottom(5);
        domino.settle();
        assertEquals("Ensure that your settle method in the Domino class has been implemented correctly!", 6, domino.getBottom());
        tearDown();
    }

    @Test
    public void testSettleThree() {
        setUp();
        domino.setTop(5);
        domino.setBottom(6);
        domino.settle();
        assertEquals("Ensure that your settle method in the Domino class has been implemented correctly!", 5,domino.getTop());
        tearDown();
    }

    @Test
    public void testSettleFour() {
        setUp();
        domino.setTop(5);
        domino.setBottom(6);
        domino.settle();
        assertEquals("Ensure that your settle method in the Domino class has been implemented correctly!", 6, domino.getBottom());
        tearDown();
    }

    @Test
    public void testCompareToReturns1() {
        setUp();
        domino.setTop(3);
        domino.setBottom(6);
        assertEquals("Ensure that your compareTo method in the Domino class has been implemented correctly!", 1, domino.compareTo(otherDomino));
        tearDown();
    }

    @Test
    public void testCompareToReturns0() {
        setUp();
        domino.setTop(6);
        domino.setBottom(2);
        assertEquals("Ensure that your compareTo method in the Domino class has been implemented correctly!", 0, domino.compareTo(otherDomino));
        tearDown();
    }

    @Test
    public void testCompareToReturnsMinus1() {
        setUp();
        domino.setTop(4);
        domino.setBottom(2);
        assertEquals("Ensure that your compareTo method in the Domino class has been implemented correctly!", -1, domino.compareTo(otherDomino));
        tearDown();
    }

    @Test
    public void testCanConnectNoConnection() {
        setUp();
        assertTrue("Ensure that your canConnect method in the Domino class has been implemented correctly!", !domino.canConnect(otherDomino));
        tearDown();
    }

    @Test
    public void testCanConnectTopTop() {
        setUp();
        domino.setTop(6);
        assertTrue("Ensure that your canConnect method in the Domino class has been implemented correctly!", domino.canConnect(otherDomino));
        tearDown();
    }

    @Test
    public void testCanConnectBottomTop() {
        setUp();
        domino.setBottom(6);
        assertTrue("Ensure that your canConnect method in the Domino class has been implemented correctly!", domino.canConnect(otherDomino));
        tearDown();
    }

    @Test
    public void testCanConnectTopBottom() {
        setUp();
        domino.setTop(2);
        assertTrue("Ensure that your canConnect method in the Domino class has been implemented correctly!", domino.canConnect(otherDomino));
        tearDown();
    }

    @Test
    public void testCanConnectBottomBottom() {
        setUp();
        domino.setBottom(2);
        assertTrue("Ensure that your canConnect method in the Domino class has been implemented correctly!", domino.canConnect(otherDomino));
        tearDown();
    }
}
