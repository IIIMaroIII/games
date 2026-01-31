package lt.esdc.noughtsAndCrosses;

import java.util.function.Consumer;

public class Validator {
    public int parseInt(String str) throws NoughtsAndCrossesException {
        if (str == null) throw new NoughtsAndCrossesException("String is null");
        if (str.isBlank()) throw new NoughtsAndCrossesException("String is empty");
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new NoughtsAndCrossesException("The string " + str + " is not parsable.");
        }
    }

    public Validator validateStringIsNull(String str) throws NoughtsAndCrossesException {
        if (str == null) throw new NoughtsAndCrossesException("String is null");
        return this;
    }

    public Validator validateStringIsEmpty(String str) throws NoughtsAndCrossesException {
        if (str.isBlank()) throw new NoughtsAndCrossesException("String is empty");
        return this;
    }

    public boolean isStringFollowsPattern(String input, String regex) throws NoughtsAndCrossesException {
        this.validateStringIsNull(input).validateStringIsEmpty(input);
        boolean isMatched = input.matches(regex);
        if (!isMatched)
            throw new NoughtsAndCrossesException("User input doesn't match with pattern '2-2', " + "'5-4' etc");
        return true;
    }

    public boolean isCellEmpty(String[][] matrix, int[] indices, String emptyMark) {
        int row = indices[0];
        int col = indices[1];
        return matrix[row][col].equals(emptyMark);
    }

    public void determineWinnerByMark(String[][] matrix, String mark, Consumer<String> setter) {
        threeInRow(matrix, mark, setter).threeInColumn(matrix, mark, setter)
                .threeInMainDiagonal(matrix, mark, setter)
                .threeInSecondaryDiagonal(matrix, mark, setter);
    }

    private Validator threeInRow(String[][] matrix, String mark, Consumer<String> setter) {
        for (int r = 0; r < matrix.length; r++) {
            int count = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals(mark)) {
                    count++;
                }
            }
            if (count == 3) {
                System.out.println("Row is crossed, row number is: " + r);
                setter.accept(mark);
            }
        }
        return this;
    }

    private Validator threeInColumn(String[][] matrix, String mark, Consumer<String> setter) {
        for (int c = 0; c < matrix[0].length; c++) {
            int count = 0;
            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][c].equals(mark)) {
                    count++;
                }
            }
            if (count == 3) {
                System.out.println("Column is crossed, column number is: " + c);
                setter.accept(mark);
            }
        }
        return this;
    }

    private Validator threeInMainDiagonal(String[][] matrix, String mark, Consumer<String> setter) {
        int mainDiagonalCounter = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][r].equals(mark)) {
                    mainDiagonalCounter++;
                    break;
                }
            }

        }
        if (mainDiagonalCounter == 3) {
            System.out.println("Main diagonal is crossed");
            setter.accept(mark);
        }
        return this;
    }

    private Validator threeInSecondaryDiagonal(String[][] matrix, String mark, Consumer<String> s) {
        int secondaryDiagonalCounter = 0;
        for (int r = 0; r < matrix.length; r++) {
            int step = matrix.length - r - 1;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][step].equals(mark)) {
                    secondaryDiagonalCounter++;
                    break;
                }
            }

        }
        if (secondaryDiagonalCounter == 3) {
            System.out.println("Secondary diagonal is crossed");
            s.accept(mark);
        }
        return this;
    }


}