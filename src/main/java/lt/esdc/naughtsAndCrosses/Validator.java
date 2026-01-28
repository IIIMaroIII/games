package lt.esdc.naughtsAndCrosses;

public class Validator {
    public int parseInt(String str) throws NaughtsAndCrossesException {
        if (str == null) throw new NaughtsAndCrossesException("String is null");
        if (str.isBlank()) throw new NaughtsAndCrossesException("String is empty");
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new NaughtsAndCrossesException("The string " + str + " is not parsable.");
        }
    }
}