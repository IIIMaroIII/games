package lt.esdc.naughtsAndCrosses;

public class Printer {
    private final String ANSIclearTerminal = new String("\u001B[2J\u001B[H");

    public void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.print("\t\t");
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    public void clearTerminal() {
        System.out.println(this.ANSIclearTerminal);
    }

}