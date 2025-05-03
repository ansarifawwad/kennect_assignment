package org.example.ExcelUtilities;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.MainClass;

import java.io.*;
import java.nio.file.Paths;

public class ExcelDownload extends MainClass {

    String projectPath = System.getProperty("user.dir");
    String fileLocation = "src/main/java/org/example/ExcelUtilities/InputData.xlsx";
    String downloadPath = Paths.get(projectPath, fileLocation).toString();

    public void downloadExcel() {

        String fileUrl = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSVICW5wNRHf9CmUcl_sUde0WUpZl234mW5Wjf3Or3i6ZaFJOMCWYlfefeKj-puUPnW23JJoFxNtsml/pub?output=xlsx";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(fileUrl);

        httpGet.addHeader("Cache-Control", "no-cache");
        httpGet.addHeader("Pragma", "no-cache");

        try {
            HttpResponse response = httpClient.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();

            File outputFile = new File(downloadPath);
            FileOutputStream outputStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded successfully to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteExcel() {
        File file = new File(downloadPath);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}
