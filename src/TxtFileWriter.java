import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TxtFileWriter {
    public static void writeToCsvFile(String fileName, String line) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", StandardCharsets.UTF_8, true))) {
            writer.write(line);
            writer.newLine();
        }
    }
}
