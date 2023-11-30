package exceptions.homework3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer implements FileWriteble{
    /**
     * Writes line to file
     * @param filePath file name
     * @param line String line
     */
    @Override
    public void writeToFile(String filePath, String line) {
        File file = new File(filePath);
            try(FileWriter fileWriter = new FileWriter(file,true)) {
                fileWriter.write(line + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
