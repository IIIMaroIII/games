package lt.esdc.noughtsAndCrosses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {
    private static String fileName = "noughtsAndCrosses_result.txt";
    private static String folderName = "info";
    private static final String currentDir = System.getProperty("user.dir");

    public static void main(String[] args) {

    }

    static Path configurePath() {
        return Path.of(currentDir, "src", "main", "java", "lt", "esdc", "noughtsAndCrosses", folderName, fileName);
    }

    static void appendToFile(String str) throws NoughtsAndCrossesException {
        Validator.validateFileExist(configurePath());
        try {
            Files.writeString(configurePath(), str, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            throw new NoughtsAndCrossesException("Impossible append to a file: " + configurePath() + "\n the " +
                    "following content: " + str);
        }

    }
}
