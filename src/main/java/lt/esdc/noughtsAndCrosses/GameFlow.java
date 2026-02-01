package lt.esdc.noughtsAndCrosses;

import java.util.Arrays;
import java.util.Scanner;

public class GameFlow {
    private static final String X = new String(Character.toChars(0x1F532));
    private static final String O = new String(Character.toChars(0x1F533));
    private static final String emptySquare = new String(Character.toChars(0x2B1C));
    private static final String inputPattern = "^[0-2]-[0-2]$";

    private String winner;
    private int[] arrayOfIndices;
    private String[][] matrix;
    private boolean exit = false;
    private boolean repeat = false;
    private int round = 0;
    private int pointsPlayerX;
    private int pointsPlayerO;


    public void init() {
        String[][] initMatrix = initializeEmptyMatrix(3, 3);
        this.setMatrix(initMatrix);
        Printer.printMatrixWithNumbers(this.getMatrix());
        reset();

        while (!this.exit) {
            startLap(GameFlow.X);
            startLap(GameFlow.O);
        }


    }

    private void reset() {
        this.winner = "";
        this.arrayOfIndices = new int[]{};
        this.round = 0;
        if (!this.repeat) {
            this.pointsPlayerX = 0;
            this.pointsPlayerO = 0;
        }
    }

    private void pointsCounter(String mark) {
        if (mark.equals(emptySquare)) return;
        if (mark.equals(X)) pointsPlayerX++;
        if (mark.equals(O)) pointsPlayerO++;
    }

    public void startLap(String mark) {
        round++;

        while (!this.exit) {
            try {
                String userInput = askUser(mark);
                int[] indices = Validator.getIntegerArray(userInput, GameFlow.inputPattern);
                setArrayOfIndices(indices);
                Validator.validateEmptyCell(this.getMatrix(), this.arrayOfIndices, emptySquare);
                placePlayerMark(mark);
                Printer.printMatrixWithNumbers(this.getMatrix());
                Validator.determineResult(this.getMatrix(), mark, this::setWinner, this.round);
                if (!this.getWinner().isBlank()) {
                    Printer.printWinner(this.winner);
                    pointsCounter(this.winner);
                    Printer.printScore(X, O, pointsPlayerX, pointsPlayerO);
                    playAgain();
                }
                break;
            } catch (NoughtsAndCrossesException ex) {
                System.err.println(ex.getMessage());
                System.err.println("\t❌ Try again...");
            }
        }

    }

    public void playAgain() {
        String repeat = askUser("repeat");
        if (repeat.equals("0")) {
            this.repeat = false;
            this.exit = true;
            return;
        }
        this.repeat = true;
        init();
    }

    public void placePlayerMark(String mark) {
        int firstIndex = arrayOfIndices[0];
        int secondIndex = arrayOfIndices[1];
        this.matrix[firstIndex][secondIndex] = mark;
    }

    public String askUser(String mark) {
        if (mark.equals("repeat")) {
            Printer.printRepeatLine();
        } else {
            Printer.printFillCell(mark);
        }

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static String[][] initializeEmptyMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (String[] one : matrix) {
            Arrays.fill(one, GameFlow.emptySquare);
        }

        return matrix;
    }


    public void setMatrix(String[][] data) {
        this.matrix = data;
    }

    public void setWinner(String mark) {
        this.winner = mark;
    }

    public String[][] getMatrix() {
        return this.matrix;
    }

    public String getWinner() {
        return this.winner;
    }

    static String getEmptySquare() {
        return emptySquare;
    }

    public void setArrayOfIndices(int[] arr) {
        this.arrayOfIndices = arr;
    }


}
