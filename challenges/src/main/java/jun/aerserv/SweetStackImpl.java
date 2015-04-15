package jun.aerserv;

public class SweetStackImpl extends SimpleStack implements SweetStack {

    SimpleStack maxValues = new SimpleStack();
    
    @Override
    public void push(int val) {
        super.push(val);
        if (maxValues.size() > 0) {
            if (maxValues.head.val <= val) {
                maxValues.push(val);
            }
        } else {
            maxValues.push(val);
        }
    }

    @Override
    public int pop() {
        int ret = super.pop();
        if (maxValues.head.val <= ret) {
            maxValues.pop();
        }
        return ret;
    }

    @Override
    public int max() {
        if (size() <= 0) {
            throw new RuntimeException("No max in empty stack!");
        }
        return maxValues.head.val;
    }

}
