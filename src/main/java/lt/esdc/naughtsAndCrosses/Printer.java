package lt.esdc.naughtsAndCrosses;

public class Printer {
    private final String ANSIclearTerminal = "\u001B[2J\u001B[H";
    private final String stepFromTheLeft = "\t\t";

    public void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.print(this.stepFromTheLeft + r + " ");
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    public void clearTerminal() {
        System.out.println(this.ANSIclearTerminal);
    }

    public void printMatrixWithNumbers(String[][] matrix) {
        System.out.println(this.stepFromTheLeft + "  0  1  2");
        printMatrix(matrix);
    }

    public void printFillCell(String mark) {
        System.out.print("\t👉 Player " + mark + " , enter the cell: ");
    }

    public void printWinner(String mark) {
        System.out.println("\t🎉 Winner is: Player " + mark);
    }

}