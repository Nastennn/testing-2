import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvLogger {
    private String filePath = "src/";

    private double step;
    private double start;
    private double end;
    private final char CSV_SEPARATOR = ' ';

    public CsvLogger(String fileName, double start, double end, double step) {
        this.filePath = filePath + fileName;
        this.start = start;
        this.end = end;
        this.step = step;
    }

    public void setFilePath(String fileName) {
        this.filePath = "src/test/resources/" + fileName;
    }

    public void log(Function function) {
        String csvString = "";

        try {
            Files.deleteIfExists(Paths.get(this.filePath));
        } catch (IOException e) {
        }

        try (PrintStream printStream = new PrintStream(new FileOutputStream(filePath, true))) {
            for (double i = start; i < end; i += step) {
                double result = function.calculate(i);
                csvString = String.format("%f%s %f\n", i, CSV_SEPARATOR, result);
                printStream.print(csvString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
