import io.appium.java_client.MobileBy;
import io.appium.java_client.Setting;
import io.appium.java_client.android.*;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.ScreenRecordingUploadOptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static io.appium.java_client.Setting.IGNORE_UNIMPORTANT_VIEWS;
//import static org.fusesource.jansi.Ansi.*;
//import static org.fusesource.jansi.Ansi.Color.*;


public class TestXueQiu {

    private AndroidDriver driver;

    //@Before
    public void beforexueqiu() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","b53bbecd");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        capabilities.setCapability("noReset", "false");
        //capabilities.setCapability("fullReset", "true");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    //@Before
    public void beforeChromeBrowser() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"b53bbecd");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0.1");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

   // @Test
    public void test2() throws InterruptedException {
        driver.get("http://saucelabs.com/test/guinea-pig");
        WebElement div = driver.findElement(By.id("i_am_an_id"));
        Assert.assertEquals("I am a div", div.getText()); //check the text retrieved matches expected value
        driver.findElement(By.id("comments")).sendKeys("My comment");
        Thread.sleep(10000);
    }

   // @Test
    public void test1() throws Exception {
        driver.ignoreUnimportantViews(true);
        driver.startRecordingScreen();
        Thread.sleep(3000);
        driver.findElementById("cancel").click();
        Thread.sleep(3000);
        driver.findElementById("user_profile_container").click();
        Thread.sleep(1000);
        driver.findElementById("tv_login").click();
        Thread.sleep(1000);
        driver.findElementById("tv_login_by_phone_or_others").click();

        driver.stopRecordingScreen(AndroidStopScreenRecordingOptions.stopScreenRecordingOptions().
                withUploadOptions(ScreenRecordingUploadOptions.uploadOptions().withRemotePath("/Users/smartmac/Downloads/demotest")));

    }

//        List<List<Object>> performanceData=
//                driver.getPerformanceData("com.xueqiu.android","memoryinfo",10);
//        for(int i=0;i<performanceData.size();i++)
//        {
//            System.out.println(ansi().eraseScreen().fg(RED).a("---------------------------").reset());
//            for(int j=0;j<performanceData.get(i).size();j++)
//            {
//                System.out.println(performanceData.get(i).get(j));
//            }
//        }

//        System.out.println(driver.getSupportedPerformanceDataTypes());
//        System.out.println(driver.manage().logs().getAvailableLogTypes());
//        Map<String,Object> settingMap = driver.getSettings();
//        Set<String> keySet = settingMap.keySet();
//        for(String key : keySet)
//        {
//            String value = settingMap.get(key).toString();
//            System.out.format("Key: %s, Value: %s",key,value);
//        }

//        LogEntries logEntries1 = driver.manage().logs().get("logcat");
//        //List<LogEntry> listLog = logEntries1.getAll();
//        Iterator<LogEntry> iterator = logEntries1.iterator();
//        System.out.println(ansi().eraseScreen().fg(RED).a("-------------Logcat--------------").reset());
//        int temp=1;
//        while(iterator.hasNext())
//        {
//            System.out.print("*******");
//            System.out.println(temp);
//            LogEntry logEntry = iterator.next();
//            System.out.println(logEntry.getMessage());
//            System.out.println(logEntry.getLevel().getName());
//            System.out.println(logEntry.getLevel().toString());
//            System.out.println(logEntry.getTimestamp());
//            System.out.println(logEntry.toString());
//            temp=temp+1;
//
//        }
//        System.out.println(ansi().eraseScreen().fg(RED).a("-------------END--------------").reset());

//        LogEntries logEntries2 = driver.manage().logs().get("bugreport");
//        int len = logEntries2.getAll().size();
//        System.out.println("-----bugreport: " + len);
//        System.out.println(ansi().eraseScreen().fg(RED).a("-----bugreport: "+len).reset());
//        if (len>0) {
//            Iterator<LogEntry> iterator2 = logEntries2.iterator();
//            System.out.println(ansi().eraseScreen().fg(RED).a("-------------bugreport--------------").reset());
//            int i1 = 0;
//            while (iterator2.hasNext()) {
//                ++i1;
//                System.out.println("*******" + i1);
//                LogEntry logEntry = iterator.next();
//                System.out.println(logEntry.getMessage());
//                System.out.println(logEntry.getLevel().getName());
//                System.out.println(logEntry.getLevel().toString());
//                System.out.println(logEntry.getTimestamp());
//                System.out.println(logEntry.toString());
//
//            }
//            System.out.println(ansi().eraseScreen().fg(RED).a("-------------END--------------").reset());
//        }

//        LogEntries logEntries3 = driver.manage().logs().get("server");
//        if(logEntries3.getAll().size()>0) {
//            Iterator<LogEntry> iterator3 = logEntries3.iterator();
//            System.out.println(ansi().eraseScreen().fg(RED).a("-------------server--------------").reset());
//            int i2 = 0;
//            while (iterator3.hasNext()) {
//                i2++;
//                System.out.println("*******" + i2);
//                LogEntry logEntry = iterator.next();
//                System.out.println(logEntry.getMessage());
//                System.out.println(logEntry.getLevel().getName());
//                System.out.println(logEntry.getLevel().toString());
//                System.out.println(logEntry.getTimestamp());
//                System.out.println(logEntry.toString());
//
//            }
//            System.out.println(ansi().eraseScreen().fg(RED).a("-------------END--------------").reset());
//        }

//        LogEntries logEntries4 = driver.manage().logs().get("client");
//        Iterator<LogEntry> iterator4 = logEntries4.iterator();
//        if(logEntries4.getAll().size()>0) {
//            System.out.println(ansi().eraseScreen().fg(RED).a("-------------client--------------").reset());
//            int i3 = 0;
//            while (iterator4.hasNext()) {
//                i3++;
//                System.out.println("*******" + i3);
//                LogEntry logEntry = iterator.next();
//                System.out.println(logEntry.getMessage());
//                System.out.println(logEntry.getLevel().getName());
//                System.out.println(logEntry.getLevel().toString());
//                System.out.println(logEntry.getTimestamp());
//                System.out.println(logEntry.toString());
//
//            }
//            System.out.println(ansi().eraseScreen().fg(RED).a("-------------END--------------").reset());
//        }


//        driver.
//                findElementByXPath("//*[@resource-id=\"com.xueqiu.android:id/listview\"]/*[@resource-id=\"com.xueqiu.android:id/today_topic_container\"][1]//*[@resource-id=\"com.xueqiu.android:id/topic_text\"]").
//                click();

//        Thread.sleep(2000);
//        driver.startActivity(new Activity("io.appium.android.apis",".ApiDemos"));
//        System.out.println(driver.getCurrentPackage());
//        System.out.println(driver.currentActivity());
//        Thread.sleep(2000);

//    }

//    public void before() throws MalformedURLException
//    {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName","emulator-5554");
//        capabilities.setCapability("platformName","Android");
//        capabilities.setCapability("appPackage","io.appium.android.apis");
//        capabilities.setCapability("appActivity",".ApiDemos");
//        capabilities.setCapability("automationName", "uiautomator2");
//        //capabilities.setCapability("noReset", "false");
//        //capabilities.setCapability("fullReset", "true");
//        driver=new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    }
//
//
//    public void before1() throws MalformedURLException
//    {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName","emulator-5554");
//        capabilities.setCapability("platformName","Android");
//        capabilities.setCapability("appPackage","io.appium.android.apis");
//        capabilities.setCapability("appActivity",".ApiDemos");
//        capabilities.setCapability("automationName", "uiautomator2");
//        //capabilities.setCapability("noReset", "false");
//        //capabilities.setCapability("fullReset", "true");
////        driver=new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
////        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver1= new AndroidDriver(new URL("http://127.0.0.1:5723/wd/hub"),capabilities);
//        driver1.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testAPIS() throws InterruptedException {
//        driver1.findElementByAccessibilityId("Views").click();
//        driver1.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Popup Menu\"));").click();
//        driver1.findElementByAccessibilityId("Make a Popup!").click();
//        //System.out.println(driver1.getPageSource());
//        Thread.sleep(1000);
//        driver1.findElementByXPath("//android.widget.TextView[@text='Add']").click();
//        for(int i=0;i<5;i++)
//        {
//            System.out.println(driver1.getPageSource());
//            System.out.println("Toast");
//            System.out.println(driver1.findElementByXPath("//*[@class='android.widget.Toast']").getText());
//        }
//    }

    //@Test
    public void printPS() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());

    }

   // @Test
    public void demo() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElementByXPath("//*[@text='自选']").click();
        driver.findElementByXPath("//*[@text='美股']").click();
    }


    //@Test
    public  void testScroll() throws InterruptedException {
        Thread.sleep(20000);

        Dimension size = driver.manage().window().getSize();
        int width=size.width;
        int height=size.height;

        //Point p1 = driver.findElementByXPath("//*[@text='基金']").getLocation();

       /* (new TouchAction(driver)).
                press(PointOption.point((int) (width * 0.5), (int) (height * 0.5))).
                moveTo(PointOption.point((int) (width * 0.5), (int) (height * 0.8))).
                release().perform();*/

        Thread.sleep(20000);
    }

    //@Test
    public void testToast() throws InterruptedException, IOException {


        Thread.sleep(5000);
        //System.out.println(driver.getPageSource());
        driver.findElementByXPath("//*[@text='Views']").click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"android:id/list\")).getChildByText("
                        + "new UiSelector().className(\"android.widget.TextView\"), \"Popup Menu\")"));
        //(new TouchAction(driver)).press(748,2220).moveTo(748,300).release().perform();
        //driver.findElementByAccessibilityId("Popup Menu").click();
        element.click();
        driver.findElementByXPath("//*[@text='MAKE A POPUP!']").click();

        Thread.sleep(2000);
        driver.findElementByXPath("//*[contains(@text,'Search')]").click();

       // for(int i=0;i<50;i++)
       // {


            WebDriverWait waiter = new WebDriverWait(driver, 10);
            WebElement toastElement =
                    waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.Toast']")));//android.widget.Toast
            System.out.println(toastElement.getText());


            /*if(driver.findElementsByXPath("//*[@class='android.widget.Toast']")) {
                System.out.println(driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
            }
            else {
                System.out.println(driver.getPageSource());
                System.out.println();
                Thread.sleep(10);
            }*/
       // }

    }

 //   @Test
//    public void testWebView() throws InterruptedException {
//
//
//        //driver.findElementByXPath("//*[@text='Views']").click();
//        WebElement views = driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"android:id/list\")).getChildByText("
//                        + "new UiSelector().className(\"android.widget.TextView\"), \"Views\")"));
//        views.click();
//
//        WebElement webview = driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView("
//                        + "new UiSelector().text(\"WebView\"));"));
//
//       /* WebElement webview = driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"android:id/content\")).scrollIntoView("
//                        + "new UiSelector().text(\"WebView\"));"));*/
//        webview.click();
//        System.out.println(driver.getContextHandles());
//
//        for(WebElement e : driver.findElementsByXPath("//*")){
//            System.out.println(e.getTagName());
//            System.out.println(e.getText());
//        }
//
//        driver.context(driver.getContextHandles().toArray()[1].toString());
//
//
//
//        for(WebElement e : driver.findElementsByXPath("//*")){
//            System.out.println(e.getTagName());
//            System.out.println(e.getText());
//        }
//
//        Thread.sleep(10000);
//    }


   // @After
    public void teardown() throws IOException {

//        System.out.println(driver.getPageSource());
//        File srcFile=driver.getScreenshotAs(OutputType.FILE);
//        String filename= UUID.randomUUID().toString();
//        File targetFile=new File("/Users/smartmac/Pictures/"+filename+".jpg");
//        FileUtils.copyFile(srcFile,targetFile);

        //System.out.println(driver1.getPageSource());

        //driver.removeApp("io.appium.android.apis");
        driver.quit();
    }

}


