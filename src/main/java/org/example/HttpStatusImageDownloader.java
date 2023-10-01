package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpStatusImageDownloader {
    private static final HttpStatusChecker checker = new HttpStatusChecker();

    public void downloadStatusImage(int code){
        String outputFile = ".\\src\\main\\resources\\" + code + ".jpg";

        try {
            Connection connection = Jsoup.connect(checker.getStatusImage(code)).ignoreContentType(true);
            InputStream inputStream = connection.execute().bodyStream();
            OutputStream outputStream = new FileOutputStream(outputFile);
            byte [] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();
            System.out.println("Image downloaded and saved as " + outputFile);
        } catch (Exception e){
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
