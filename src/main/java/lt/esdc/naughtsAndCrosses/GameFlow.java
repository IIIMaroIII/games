package lt.esdc.naughtsAndCrosses;

import java.util.Scanner;
import java.util.function.Consumer;

public class GameFlow {
    private final String X = new String(Character.toChars(0x1F532));
    private final String O = new String(Character.toChars(0x1F533));
    private final String emptySquare = new String(Character.toChars(0x2B1C));
    private String winner = "";

    public void main(String[] args) throws NaughtsAndCrossesException {
        Printer printer = new Printer();
        GameFlow gameFlow = new GameFlow();
        Consumer<String> onWin = mark -> gameFlow.setWinner(mark);
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = gameFlow.initializeEmptyMatrix(3, 3);
        printer.printMatrixWithNumbers(matrix);
        validator.determineWinnerByMark(matrix, gameFlow.getO(), onWin);
        printer.printFillCell(this.getX());
        int playerX = validator.parseInt(scanner.nextLine());
        printer.clearTerminal();

    }

    public void startRound() {

    }


    public String[][] initializeEmptyMatrix(int rows, int cols) throws NaughtsAndCrossesException {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 2 && col == 0 || row == 1 && col == 1 || row == 0 && col == 2) {
                    matrix[row][col] = this.getO();
                    continue;
                }
                matrix[row][col] = this.getEmptySquare();

            }
        }

        return matrix;
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

    public void setWinner(String mark) {
        this.winner = mark;

    }

    public String getWinner() {
        return this.winner;
    }


}