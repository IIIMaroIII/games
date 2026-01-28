package lt.esdc.naughtsAndCrosses;

public class NaughtsAndCrossesException extends Exception {
    public NaughtsAndCrossesException(String msg) {
        super(msg);

    }

    public NaughtsAndCrossesException(String msg, Throwable ex) {
        super(msg, ex);
    }
}