package CANetworks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


    public static void main(String[] args) {
        System.out.println("ECTC, MaxUtil & BTC Job Generator");
        System.out.println("\nEnter the number of Jobs required...");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input < 1 || input > 50000)
            throw new InputMismatchException("Value is insufficient");

        try {
            populateFile(input);
            String filePath = "src/CANetworks/";
            System.out.printf("%d jobs successfully created in '%s/%s'", input,  System.getProperty("user.dir"), filePath);
        }
        catch (Exception e) {
            System.out.println("Job creation unsuccessful: " + e.toString());
        }
    }


    public static ArrayList<Data> generateData(int fileSize) {
        ArrayList<Data> dataList = new ArrayList<>();
        SecureRandom rand = new SecureRandom();

        for (int i = 0; i < fileSize; i++) {
            int procTimeAdd = rand.nextInt(20 - 3 + 3) + 3;
            int util = ThreadLocalRandom.current().nextInt(2, 7 + 1) * 10;

            int increment = ThreadLocalRandom.current().nextInt(3, 9);
            int arrival;

            if (i == 0)
                arrival = 0;
             else
                arrival = dataList.get(i - 1).getArrivalTime() + increment;

            Data data = new Data(i, arrival, procTimeAdd, util);
            dataList.add(data);
        }
        return dataList;
    }


    public static void populateFile(int input) throws IOException {
        String fileName = String.format("src/CANetworks/%dJobs.txt", input);
        ArrayList<Data> output = generateData(input);
        try {
            File file = new File(fileName);
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(file))) {
                for (Data s : output) {
                    pw.println(s);
                }
            }
        } catch (Exception e) {
            throw new IOException();
        }
    }
}
