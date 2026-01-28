package lt.esdc.naughtsAndCrosses;

import java.util.Scanner;

public class GameFlow {
    private final String X = new String(Character.toChars(0x1F532));
    private final String O = new String(Character.toChars(0x1F533));
    private final String emptySquare = new String(Character.toChars(0x2B1C));

    public static void main(String[] args) throws NaughtsAndCrossesException {
        Printer printer = new Printer();
        GameFlow gameFlow = new GameFlow();
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = gameFlow.initializeEmptyMatrix(3, 3);
        printer.printMatrix(matrix);
        validator.didPlayerXWin(matrix);

        System.out.println("Player X, enter the cell: ");
        int playerX = validator.parseInt(scanner.nextLine());
//        printer.clearTerminal();
//        printer.printMatrix(gameFlow.initializeEmptyMatrix(3, 3));

    }

    public String getX() {
        return this.X;
    }

    public String getO() {
        return this.O;
    }

    public String getEmptySquare() {
        return this.emptySquare;
    }

    public String[][] initializeEmptyMatrix(int rows, int cols) throws NaughtsAndCrossesException {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0 && col == 0 || row == 1 && col == 0 || row == 2 && col == 0) {
                    matrix[row][col] = this.getX();
                    continue;
                }
                matrix[row][col] = this.getEmptySquare();

            }
        }

        return matrix;
    }

}