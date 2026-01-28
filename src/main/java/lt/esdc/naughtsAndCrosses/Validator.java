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

    public boolean isCellEmpty(String[][] matrix, int row, int col) {
        String emptyCell = new GameFlow().getEmptySquare();
        return matrix[row][col].equals(emptyCell);
    }

    public boolean didPlayerXWin(String[][] matrix) {
        String cross = new GameFlow().getX();

        int resultInRow = 0;
        int resultInCol = 0;
        for (int r = 0; r < matrix.length; r++) {
            int innerInRow = 0;
            int innerInCol = 0;


            for (int c = 0; c < matrix[r].length; c++) {
                if (!matrix[r][c].equals(cross) || matrix[c][r].equals(cross)) continue;
                if (matrix[r][c].equals(cross)) {
                    innerInRow++;
                }
                if (matrix[c][r].equals(cross)) {
                    innerInCol++;
                }

            }
            if (innerInRow == 3 || innerInCol == 3) {
                System.out.println("Exiting ...");
                break;
            }
            resultInRow += innerInRow;
            resultInCol += innerInCol;


        }

        System.out.println("Counter in a col: " + resultInCol);
        return false;
    }
}