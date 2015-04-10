package jun.aerserv;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Here you declare your BufferedReader object and instance it.
        SweetStack stack = new SweetStackImpl();
        while (true) {
            try {
                System.out.println(String.format("Current stack size: %d", stack.size()));
                if (stack.size() > 0) {
                    System.out.println(String.format("Current max value: %d", stack.max()));
                }
                System.out.print("Type an integer to push, or enter to pop; type 'x' to exit: ");
                String input = br.readLine();
                if (input == null || input.equals("")) {
                    int val = stack.pop();
                    System.out.println(String.format("poped value: %d", val));
                } else if (input.equals("x")) {
                    break;
                } else {
                    int val = Integer.parseInt(input);
                    stack.push(val);
                    System.out.println(String.format("pushed value: %d", val));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

}
