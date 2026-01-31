package lt.esdc.naughtsAndCrosses;

import java.util.Arrays;

public class GameFlow {
    private static final String X = new String(Character.toChars(0x1F532));
    private static final String O = new String(Character.toChars(0x1F533));
    private static final String emptySquare = new String(Character.toChars(0x2B1C));
    private String winner = "";
    private static final String inputPattern = "^[0-2]-[0-2]$";

    public void main(String[] args) {
        initializeEmptyMatrix(3,3);



    }

    private void startRound() {
        printMatrix(String[][] matrix);

        while(true){
            printLineToAskPlayer(String mark);
            String choice = getUserChoice(String input);
            validateUserChoice(choice); // If not valid throw NoughtsAndCrossesException
            validateIsUserChoiceFollowPattern(choice, String regex); // If not follow throw
            // NoughtsAndCrossesException;
            int[][] playerChoiceIndices = getPlayerChoiceIndices(choice)
            setPlayerChoice(playerChoiceIndices);

            if(getPlayerChoiceIndices.length != 0) break;
        }

        boolean isCellEmpty=  checkIsCellEmpty(String[][] matrix, int[] indices, String emptyMark);
        while(isCellEmpty) {
            setUserChoiceToMatrix(String[][], int[] indices, String mark);

        }
    }


    public String[][] initializeEmptyMatrix(int rows, int cols) throws NoughtsAndCrossesException {
        String[][] matrix = new String[rows][cols];
        for (String[] one : matrix) {
            Arrays.fill(one, this.getEmptySquare());
        }

        return matrix;
    }

    static String getX() {
        return X;
    }

    static String getO() {
        return O;
    }

    static String getEmptySquare() {
        return emptySquare;
    }

    static String getInputPattern() {

    }

    public void setWinner(String mark) {
        this.winner = mark;

    }

    public String getWinner() {
        return this.winner;
    }

}
