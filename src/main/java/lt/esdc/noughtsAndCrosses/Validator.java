package lt.esdc.noughtsAndCrosses;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

public final class Validator {
    private Validator() {
    }

    static void validateFileExist(Path path) throws NoughtsAndCrossesException {
        if (!Files.exists(path))
            throw new NoughtsAndCrossesException("File at the given path doesn't exist: " + path);
    }

    static int parseInt(String str) throws NoughtsAndCrossesException {
        if (str == null) throw new NoughtsAndCrossesException("String is null");
        if (str.isBlank()) throw new NoughtsAndCrossesException("String is empty");
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new NoughtsAndCrossesException("\t❌ The string " + str + " is not parsable.");
        }
    }

    static void validateStrings(String... strings) throws NoughtsAndCrossesException {
        for (String one : strings) {
            if (one == null) throw new NoughtsAndCrossesException("\t❌ String is null");
            if (one.isBlank()) throw new NoughtsAndCrossesException("\t❌ String is empty");
        }
    }

    static void fitToPattern(String input, String regex) throws NoughtsAndCrossesException {
        validateStrings(input, regex);
        if (!input.strip().matches(regex))
            throw new NoughtsAndCrossesException("\t❌ User input doesn't match with pattern -> " + regex);
    }

    static int[] getIntegerArray(String str, String regex) throws NoughtsAndCrossesException {
        validateStrings(str, regex);
        fitToPattern(str, regex);
        String[] arr = str.split("-");

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = parseInt(arr[i]);
        }

        return res;
    }

    static void validateEmptyCell(String[][] matrix, int[] indices, String emptyMark) throws NoughtsAndCrossesException {
        int row = indices[0];
        int col = indices[1];
        if (!matrix[row][col].equals(emptyMark)) {
            String errMsg =
                    "\t❌ The cell at the row " + row + " and column " + col + " is not " + "empty";
            throw new NoughtsAndCrossesException(errMsg);
        }
    }

    static void determineResult(String[][] matrix, String mark, Consumer<String> setter,
                                int round) {

        threeInRow(matrix, mark, setter);
        threeInColumn(matrix, mark, setter);
        threeInMainDiagonal(matrix, mark, setter);
        threeInSecondaryDiagonal(matrix, mark, setter);
        if (round >= 8) tie(matrix, mark, setter);

    }

    private static void threeInRow(String[][] matrix, String mark, Consumer<String> setter) {
        for (int r = 0; r < matrix.length; r++) {
            int count = 0;
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals(mark)) {
                    count++;
                }
            }
            if (count == 3) {
                System.out.println("\t\t========================================");
                System.out.printf("\t\t=== Row is crossed, row number is %d ===\n", r);
                setter.accept(mark);
            }
        }
    }

    private static void tie(String[][] matrix, String mark, Consumer<String> setter) {
        int counter = 0;
        for (String[] strings : matrix) {
            for (String one : strings) {
                if (!one.equals(GameFlow.getEmptySquare())) counter++;
            }
        }
        if (counter == 9) {
            setter.accept(GameFlow.getEmptySquare());
        }

    }

    private static void threeInColumn(String[][] matrix, String mark, Consumer<String> setter) {
        for (int c = 0; c < matrix[0].length; c++) {
            int count = 0;
            for (int r = 0; r < matrix.length; r++) {
                if (matrix[r][c].equals(mark)) {
                    count++;
                }
            }
            if (count == 3) {
                System.out.println("\t\t========================================");
                System.out.printf("\t\tColumn is crossed, column number is %d\n", c);
                setter.accept(mark);
            }
        }
    }

    private static void threeInMainDiagonal(String[][] matrix, String mark,
                                            Consumer<String> setter) {
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
            System.out.println("\t\t========================================");
            System.out.println("\t\t====== Main  diagonal is crossed =======");
            setter.accept(mark);
        }
    }

    private static void threeInSecondaryDiagonal(String[][] matrix, String mark,
                                                 Consumer<String> setter) {
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
            System.out.println("\t\t========================================");
            System.out.println("\t\t==== Secondary  diagonal is crossed ====");
            setter.accept(mark);
        }
    }


}
