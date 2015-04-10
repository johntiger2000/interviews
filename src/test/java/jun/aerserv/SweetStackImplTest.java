package jun.aerserv;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SweetStackImplTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    @Test
    public void testPush() {
        SweetStack stack = new SweetStackImpl();
        stack.push(100);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPop() {
        SweetStack stack = new SweetStackImpl();
        stack.push(100);
        assertEquals(100, stack.pop());
    }

    @Test
    public void testMax() {
        SweetStack stack = new SweetStackImpl();
        stack.push(1);
        stack.push(100);
        stack.push(100);
        stack.push(99);
        assertEquals(100, stack.max());
        stack.pop();
        assertEquals(100, stack.max());
        stack.pop();
        assertEquals(100, stack.max());
        stack.pop();
        assertEquals(1, stack.max());
    }

    @Test
    public void testPopEmpty() {
        thrown.expect(RuntimeException.class);
        SweetStack stack = new SweetStackImpl();
        stack.pop();
    }

    @Test
    public void testMaxEmpty() {
        thrown.expect(RuntimeException.class);
        SweetStack stack = new SweetStackImpl();
        stack.max();
    }

}
