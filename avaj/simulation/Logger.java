package avaj.simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static javafx.application.Platform.exit;

public class Logger {
    private PrintWriter writer;
    public String exception = null;

    public Logger(String filePath) {
        try {
            this.writer = new PrintWriter(new FileWriter(filePath));
        } catch (IOException e) {
            this.exception = e.getMessage();
        }
    }

    public void writeLine(String text) {
        writer.println(text);
    }

    public void closeLogger() {
        this.writer.close();
    }
}
