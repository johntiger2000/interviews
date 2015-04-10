package jun.rxlogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FizzBuzz {
    
    public void fb(BufferedReader reader, BufferedWriter writer) throws IOException {
        String input;
        while ((input = reader.readLine()) != null) {
            String[] tokens = input.split("\\s+");
            if (tokens.length < 3) {
                // log error input
                continue;
            }
            int A = Integer.parseInt(tokens[0]);
            int B = Integer.parseInt(tokens[1]);
            int N = Integer.parseInt(tokens[2]);
            StringBuffer sb = new StringBuffer();
            // assure A B N are in the right constraints
            for (int i = 1; i <= N; ++i) {
                if (i % A == 0 && i % B == 0) {
                    sb.append("FB ");
                } else if (i % A == 0) {
                    sb.append("F ");
                } else if (i % B == 0) {
                    sb.append("B ");
                } else {
                    sb.append(i).append(" ");
                }
            }
            writer.write(sb.toString().trim());
            writer.newLine();
        }
    }

}
