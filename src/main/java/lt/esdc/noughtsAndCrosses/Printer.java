package lt.esdc.noughtsAndCrosses;

public class Printer {
    private static final String ANSIClearTerminal = "\u001B[2J\u001B[H";
    private static final String stepFromTheLeft = "\t\t";

    static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.print(Printer.stepFromTheLeft + r + " ");
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    static void clearTerminal() {
        System.out.println(Printer.ANSIClearTerminal);
    }

    static void printMatrixWithNumbers(String[][] matrix) {
        clearTerminal();
        System.out.println(Printer.stepFromTheLeft + "  0  1  2");
        printMatrix(matrix);
    }

    static void printFillCell(String mark) {
        System.out.println("👉 Player " + mark + " , enter value followed by a format " + "'row" + "-column' (1-2,0-0 etc):" + " ");
    }

    static void printString(String str) {
        System.out.println(str);
    }

    static void printRepeatLine() {
        System.out.println("\t\t========================================");
        System.out.println("\t\t❓ Would you like to repeat the game ❓");
        System.out.println("\t\t========================================");
        System.out.println("\t\t== Please enter any key or 0 for exit ==");
        System.out.println("\t\t========================================");
    }

    static void printExiting() {
        System.out.println("\t\t========================================");
        System.out.println("\t\t========= Exiting the game ... ========= ");
        System.out.println("\t\t👋 Thanks for playing, catch you later 🥺");
        System.out.println("\t\t========================================");
    }

    static String createWinnerString(String mark) {
        if (mark.equals(GameFlow.getEmptySquare())) {
            String msg = "\t\t========================================\n\t\t💥==== Nobody's won! "
                    + "Here's a tie! " + "=====\n\t\t========================================\n";
            return msg;
        }
        String msg = "\t\t========================================\n\t\t🎉 ===== Winner is: " +
                "Player " + mark + " " + "=====\n\t\t========================================\n";
        return msg;
    }

    static String createScoreString(String X, String O, int pointsX, int pointsO) {
        return String.format("\t\t========================================\n" + "\t\t -- Player " + "%s: %d -- VS " + "--" + " Player %s: %d--\n" + "\t\t" + "========================================\n", X, pointsX, O, pointsO);

    }
}
