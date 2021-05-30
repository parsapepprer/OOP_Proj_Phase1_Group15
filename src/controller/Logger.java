package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public abstract class Logger {

    public static void log(String type, String event) {
        try {
            File file = new File("src\\resource\\log.txt");
            if (!file.exists()) file.createNewFile();

            FileWriter fileWriter = new FileWriter(file, true);
            Date date = new Date();

            fileWriter.write(String.format("%02d/%02d/%04d - %02d:%02d:%02d, [%s], %s\n",
                    date.getDate(), date.getMonth(), date.getYear(), date.getHours(), date.getMinutes(), date.getSeconds(), type, event));

            fileWriter.close();
        } catch (IOException ignored) {
        }
    }
}
