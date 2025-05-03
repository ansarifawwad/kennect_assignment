package org.example;

import net.sourceforge.tess4j.TesseractException;
import org.example.CommonUtils.Commons;
import org.example.ExcelUtilities.DataProviders;
import org.example.POM.Dashboard;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;


public class DashboardTest extends MainClass {

    @Test(dataProvider = "DownloadKennectSheet", dataProviderClass = DataProviders.class)
    public void dashboardTest(String username, String password,String enterName,String toDo) throws InterruptedException, IOException, TesseractException {

        Dashboard dashboard = new Dashboard(MainClass.driver);
        Commons commons = new Commons(MainClass.driver);

        Thread.sleep(3000);
        commons.sendKeys(dashboard.enterUsername, username);
        commons.sendKeys(dashboard.enterPassword,password);
        commons.click(dashboard.loginButton);
        Thread.sleep(40000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        commons.click(dashboard.clickAddTests);
        commons.sendKeys(dashboard.clickAddTests, enterName);
        Thread.sleep(3000);
        commons.click(dashboard.clickPatient);
        Thread.sleep(5000);
        commons.click(dashboard.clickDiscountsList);
        commons.click(dashboard.clickDiscount);
        Thread.sleep(3000);
        commons.click(dashboard.clickAddToDo);
        commons.sendKeys(dashboard.enterTodo,toDo);




//        MainClass.driver.findElement(By.xpath("//option[@value='" + district + "']")).click();
//        commons.click(downloadElectrolRolls.assemblyConsituencyDropdown);
//        Thread.sleep(3000);
//        //MainClass.driver.findElement(By.xpath("//option[normalize-space()='" + assemblyConstituency + "']")).click();
//        MainClass.driver.findElement(By.xpath("//option[@value='73']")).click();
//        commons.click(downloadElectrolRolls.getPollingStatus);
//        if (isTelugu.equals("Yes")) {
//            int i = Integer.parseInt(poolingStation + 1);
//            MainClass.driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_ctl" + i + "_lnkTelugu")).click();
//            Thread.sleep(5000);
//            download();
//        } else {
//            int i = Integer.parseInt(poolingStation + 1);
//            MainClass.driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_ctl" + i + "_lnkEnglish")).click();
//            Thread.sleep(5000);
//            download();
        }
    }

//    public static void download() throws InterruptedException, IOException, TesseractException {
//
//        Commons commons = new Commons(MainClass.driver);
//        DownloadElectrolRolls downloadElectrolRolls = new DownloadElectrolRolls(MainClass.driver);
//
//        String mainWindowHandle = driver.getWindowHandle();
//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String handle : windowHandles) {
//            if (!handle.equals(mainWindowHandle)) {
//                driver.switchTo().window(handle);
//                break;
//            }
//        }
//        WebElement imageElement = MainClass.driver.findElement(By.id("Image2"));
//        File src = imageElement.getScreenshotAs(OutputType.FILE);
//        String projectPath = System.getProperty("user.dir");
//        String path = projectPath+"/src/test/resources/CaptchImages/cropped-image.png";
//        FileHandler.copy(src, new File(path));
//        Thread.sleep(5000);
//        ITesseract tesseract = new Tesseract();
//        String temp = "/opt/homebrew/bin/tesseract";
//        //tesseract.setDatapath("/opt/homebrew/share/tessdata"); // Path to tessdata directory
//        tesseract.setDatapath(temp);
//        String recognizedText = tesseract.doOCR(new File(path));
//        recognizedText = recognizedText.replaceAll("\\n", "");
//        commons.sendKeys(downloadElectrolRolls.verificationCode,recognizedText);
//        commons.click(downloadElectrolRolls.submit);
//    }


