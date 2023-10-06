package lab1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BatchFileCreator {
    public static void main(String[] args) {

        String batchFileName = "lab1.bat";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(batchFileName));

            writer.write("@echo off");
            writer.newLine();
            writer.write("echo Hello, World!");
            writer.newLine();
            writer.write("pause");
            writer.newLine();

            writer.close();

            System.out.println("Batch file created successfully: " + batchFileName);

            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", batchFileName);
            Process process = processBuilder.start();
            process.waitFor();

            System.out.println("Batch file executed successfully.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
