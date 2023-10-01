package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    private static final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
    private static final Scanner scanner = new Scanner(System.in);

    public void askStatus(){
        System.out.println("Enter HTTP status code:");
        boolean available = true;

        while (available){
            String code = scanner.nextLine();

            if (isNumber(code)) {
                downloader.downloadStatusImage(Integer.parseInt(code));
                available = false;
            } else {
                System.out.println("Please enter valid number");
            }
        }

        scanner.close();
    }

    private static boolean isNumber(String number){
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}