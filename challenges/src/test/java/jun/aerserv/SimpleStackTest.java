package jun.aerserv;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SimpleStackTest {
    
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    
    @Test
    public void testPush() {
        SimpleStack stack = new SimpleStack();
        stack.push(100);
        assertEquals(1, stack.size());
    }

    @Test
    public void testPop() {
        SimpleStack stack = new SimpleStack();
        stack.push(1);
        stack.push(2);
        stack.push(100);
        assertEquals(100, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPopEmpty() {
        thrown.expect(RuntimeException.class);
        SimpleStack stack = new SimpleStack();
        stack.pop();
    }

    @Test
    public void testSize() {
        SimpleStack stack = new SimpleStack();
        stack.push(100);
        assertEquals(1, stack.size());
        stack.push(100);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

}
