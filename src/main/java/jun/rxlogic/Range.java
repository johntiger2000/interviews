package jun.rxlogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Range {
    
    public void printRange(BufferedReader reader, BufferedWriter writer) throws IOException {
        String input;
        while ((input = reader.readLine()) != null) {
            String[] tokens = input.split("\\s+");
            // assume all numbers are sorted
            if (tokens.length > 0) {
                int start = Integer.parseInt(tokens[0]);
                int end = start;
                StringBuffer sb = new StringBuffer();
                for (int i = 1; i < tokens.length; ++i) {
                    int num = Integer.parseInt(tokens[i]);
                    if (end + 1 == num) {
                        end = num;
                    } else {
                        if (start < end) {
                            sb.append(start).append("-").append(end).append(" ");
                        }
                        start = num;
                        end = start;
                    }
                }
                if (start < end) {
                    sb.append(start).append("-").append(end).append(" ");
                }
                writer.write(sb.toString().trim());
                writer.newLine();
            }
        }
    }

}
