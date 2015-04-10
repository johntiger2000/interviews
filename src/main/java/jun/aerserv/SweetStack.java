package jun.aerserv;

public interface SweetStack {

    public void push(int val); //pushes the value into the stack
    public int pop(); //pops the top of the stack and returns it
    public long size(); //returns the size of the stack
    public int max(); //returns the current max in the stack

}
