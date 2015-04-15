package jun.rxlogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class DuplicateRemover {
    
    class Node {
        int value;
        Node next;
    }
    
    public void removeDup(BufferedReader reader, BufferedWriter writer) throws IOException {
        String input;
        if ((input = reader.readLine()) != null) {
            String[] tokens = input.split(",");
            if (tokens.length > 0) {
                Node head = new Node();
                head.value = Integer.parseInt(tokens[0]);
                for (int i = 1; i < tokens.length; ++i) {
                    int val = Integer.parseInt(tokens[i].trim());
                    Node curr = head;
                    Node prev = null;
                    while (curr != null) {
                        if (curr.value == val) {
                            break;
                        }
                        prev = curr;
                        curr = curr.next;
                    }
                    if (curr == null) {
                        Node node = new Node();
                        node.value = val;
                        prev.next = node;
                    }
                }
                StringBuffer sb = new StringBuffer();
                Node curr = head;
                while (curr != null) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(curr.value);
                    curr = curr.next;
                }
                writer.write(sb.toString().trim());
                writer.newLine();
            }
        }
    }

}
