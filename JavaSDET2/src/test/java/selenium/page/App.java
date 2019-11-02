package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class App extends BasePage {
    public App loginWithCookie(){
        String url="https://work.weixin.qq.com/";
        //配置webDriver路径
        System.setProperty("webdriver.chrome.driver", "/Users/cuijingbo/Webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.linkText("企业登录")).click();

        System.out.println(driver.manage().getCookies());

        driver.manage().addCookie(new Cookie("wwrtx.refid", "747844728299171"));
        driver.manage().addCookie(new Cookie("wwrtx.sid", "Ekv_2dfqJ3-ElLtGMs8rxRINIUpaT-g2UXNMMagK-shLWWbKscNVB0EC7rX0hbSj"));
        driver.navigate().refresh();
        return this;
    }
    public ContactPage toContact(){
        return new ContactPage();

    }

    public ContactPage toMemberAdd(){
        //find click
        findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }
}
