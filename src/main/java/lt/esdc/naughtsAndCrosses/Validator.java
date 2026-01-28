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

    public boolean isCellEmpty(String[][] matrix, int row, int col, String mark) {
        return matrix[row][col].equals(mark);
    }

    public String didPlayerWin(String[][] matrix, String mark) {

// Check only 3 in a row
        for (int r = 0; r < matrix.length; r++) {
            int count = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals(mark)) {
                    count++;
                }
            }
            if (count == 3) {
                System.out.println("Row is crossed, row number is: " + r);
                return mark;
            }
        }

        // Check only 3 in column
        for (int c = 0; c < matrix[0].length; c++) {
            int count = 0;
            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][c].equals(mark)) {
                    count++;

                }
            }
            if (count == 3) {
                System.out.println("Column is crossed, column number is: " + c);
                return mark;
            }
        }

        return null;
    }
}