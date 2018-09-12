import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.scene.web.WebView;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TestZarker {

    private AppiumDriver<WebElement> driver;



    public void beforeZarker() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.testerhome.android");
        capabilities.setCapability("appActivity","com.testerhome.android.MainActivity");
        capabilities.setCapability("showChromedriverLog","true");
        //capabilities.setCapability("chromedriverExecutableDir","/Users/smartmac/chromedrivers/2.30/");
        //capabilities.setCapability("dontStopAppOnReset",true);
        //capabilities.setCapability("noReset",true);
        driver=new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

   // @Test
    public void testBrowser() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5556");
        capabilities.setCapability("showChromedriverLog","true");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url,capabilities);
        driver.get("https://testerhome.com");
       // System.out.println(driver.getPageSource());
        WebElement searchInput = driver.findElementByCssSelector("input[placeholder='搜索本站内容，按回车']");
        searchInput.sendKeys("小程序");
        //((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.ENTER);
        driver.pressKeyCode(AndroidKeyCode.ENTER);
        Thread.sleep(10000);
        driver.quit();

    }

   // @Test
    public void testZaker() throws InterruptedException {
       Thread.sleep(8000);

        System.out.println("****"+driver.getContextHandles());
        System.out.println("----"+driver.getContext());

        driver.context("WEBVIEW_com.testerhome.android");
        System.out.println(driver.getPageSource());
        driver.findElementByPartialLinkText("STF").click();
        Thread.sleep(20000);

    }

   // @Test
    public void testXiaoChengXu() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","b53bbecd");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.tencent.mm");
        capabilities.setCapability("appActivity",".ui.LauncherUI");
        capabilities.setCapability("showChromedriverLog","true");
        capabilities.setCapability("fastReset", "false");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("noReset", "true");
        driver=new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        System.out.println(driver.getContextHandles());
        System.out.println(driver.getContext());
        driver.findElementByXPath("//*[@text='发现']").click();
        driver.findElementByXPath("//*[@text='小程序']").click();
        driver.findElementByXPath("//*[contains(@text, '美团外卖')]").click();
        System.out.println(driver.getContextHandles());
        Thread.sleep(5000);

        driver.quit();
    }

  //  @Test
    public void TestXueQiuWebView() throws IOException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","b53bbecd");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        capabilities.setCapability("showChromedriverLog","true");
        capabilities.setCapability("fastReset", "false");
        capabilities.setCapability("fullReset", "false");
        capabilities.setCapability("noReset", "true");
        driver=new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Thread.sleep(3000);
        System.out.println("1------"+driver.getContextHandles()+"------");
        driver.findElementByXPath("//*[@text='交易']").click();
        Thread.sleep(5000);
        System.out.println("2------"+driver.getContextHandles()+"------");
        driver.findElementByXPath("//*[@text='基金']").click();
        Thread.sleep(10000);
        System.out.println("3------"+driver.getContextHandles()+"------");
        driver.findElementByAccessibilityId("已有蛋卷基金账户登录").click();
        //driver.findElementByXPath("//*[@text='已有蛋卷基金账户登录']").click();
        Thread.sleep(3000);
        System.out.println("4------"+driver.getContextHandles()+"------");

        driver.findElementByAccessibilityId("使用密码登录").click();
        Thread.sleep(1000);
        System.out.println("5------"+driver.getContextHandles()+"------");
        driver.findElementById("telno").sendKeys("phoneID");
        Thread.sleep(1000);
        WebElement passInput = driver.findElementById("pass");
        passInput.click();
        passInput.sendKeys("passWord");
        Thread.sleep(1000);
        driver.findElementById("next").click();
        Thread.sleep(5000);

        System.out.println("6------"+driver.getContextHandles()+"------");

        //take a screenshot of the last page
        File srcFile=driver.getScreenshotAs(OutputType.FILE);
        String filename= UUID.randomUUID().toString();
        File targetFile=new File("/Users/smartmac/Pictures/"+filename+".jpg");
        FileUtils.copyFile(srcFile,targetFile);

        driver.quit();
    }

    public  void close()
    {
        driver.quit();
    }



}
