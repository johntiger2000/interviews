package jun.rxlogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import junit.framework.TestCase;

public class FizzBuzzTest extends TestCase {

    InputStream input;
    BufferedReader reader;
    OutputStream output;
    BufferedWriter writer;
    
    protected static void setUpBeforeClass() throws Exception {
    }

    protected static void tearDownAfterClass() throws Exception {
    }

    protected void setUp() throws Exception {
        input  = new FileInputStream(new File("src/test/resources/FizzBuzz.sample"));
        reader = new BufferedReader(new InputStreamReader(input));
        output = new FileOutputStream(new File("src/test/resources/FizzBuzz.out.txt"));
        writer = new BufferedWriter(new OutputStreamWriter(output));
    }

    protected void tearDown() throws Exception {
        reader.close();
        input.close();
        writer.close();
        output.close();
    }

    public void testFb() throws IOException {
        FizzBuzz fb = new FizzBuzz();
        fb.fb(reader, writer);
    }

}
