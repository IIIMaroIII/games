package lt.esdc.noughtsAndCrosses;

public class NoughtsAndCrossesException extends Exception {
    public NoughtsAndCrossesException(String msg) {
        super(msg);

    }

    public NoughtsAndCrossesException(String msg, Throwable ex) {
        super(msg, ex);
    }
}

// new NoughtsAndCrossesException("asdasdasd")
