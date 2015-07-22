/**
 * Created by amacavei on 7/22/2015.
 */

public class Exception8 {

    public void outofMemory() throws OutOfMemoryError{
        throw new OutOfMemoryError();
    }

    public void stackOverflow() throws StackOverflowError{
        throw new StackOverflowError();
    }
}
