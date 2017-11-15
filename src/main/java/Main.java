import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.name("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.className("employee_avatar_small"))).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.id("header_logout"))).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.name("submitLogin")));
        driver.findElement(By.name("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.className("title")));

/*

        for (int i = 0; i < 13; i++) {
            String xpath;
            switch (i) {
                case 0:
                    xpath = ".//*[@id='tab-AdminDashboard']/a";
                    break;
                case 1:
                    xpath = ".//*[@id='subtab-AdminParentOrders']/a";
                    break;
                case 2:
                    xpath = ".//*[@id='subtab-AdminCatalog']/a";
                    break;
                case 3:
                    xpath = ".//*[@id='subtab-AdminParentCustomer']/a";
                    break;
                case 4:
                    xpath = ".//*[@id='subtab-AdminParentCustomerThreads']/a";
                    break;
                case 5:
                    xpath = ".//*[@id='subtab-AdminStats']/a";
                    break;
                case 6:
                    xpath = ".//*[@id='subtab-AdminParentModulesSf']/a";
                    break;
                case 7:
                    xpath = ".//*[@id='subtab-AdminParentThemes']/a";
                    break;
                case 8:
                    xpath = ".//*[@id='subtab-AdminParentShipping']/a";
                    break;
                case 9:
                    xpath = ".//*[@id='subtab-AdminParentPayment']/a";
                    break;
                case 10:
                    xpath = ".//*[@id='subtab-AdminInternational']/a";
                    break;
                case 11:
                    xpath = ".//*[@id='subtab-ShopParameters']/a";
                    break;
                case 12:
                    xpath = ".//*[@id='subtab-AdminAdvancedParameters']/a";
                    break;
                    default:
                        xpath = "";
            }
            driver.findElement(By.xpath(xpath)).click();
            Thread.sleep(5000);
            try {
                System.out.println(driver.findElement(By.cssSelector("h2.page-title")).getText());
            } catch (Exception e) {
                System.out.println(driver.findElement(By.cssSelector("h2.title")).getText());
            }
            */

        Thread.sleep(5000);
        int size = driver.findElements((By.xpath(".//body/div/div/nav/ul/li"))).size();
        for (int i = 1; i <= size; i++) {
            try {
                driver.findElement(By.xpath(".//body/div/div/nav/ul/li[" + i + "]/a")).click();
            } catch (Exception e) {
                driver.findElement(By.xpath(".//body/div/div/nav/ul/li[" + (++i) + "]/a")).click();
            }
            Thread.sleep(5000);
            try {
                System.out.println(driver.findElement(By.cssSelector("h2.page-title")).getText());
            } catch (Exception ex) {
                System.out.println(driver.findElement(By.cssSelector("h2.title")).getText());
            }
        }


        /*for (int i = 1; i <= driver.findElements((By.xpath(".//body/div/div/nav/ul/li/a"))).size(); i++) {

            driver.findElement(By.xpath(".//body/div/div/nav/ul/li[" + i + "]/a")).click();
            Thread.sleep(5000);
            try{
                System.out.println(driver.findElement(By.cssSelector("h2.page-title")).getText());
            } catch (Exception ex){
                System.out.println(driver.findElement(By.cssSelector("h2.title")).getText());
            }
        }*/
/*

        driver.findElement(By.xpath(".//*[@id='tab-AdminDashboard']/a")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("h2.page-title")).getText());

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentOrders']/a")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("h2.page-title")).getText());

        driver.findElement(By.xpath(".//*[@id='subtab-AdminCatalog']/a")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("h2.title")).getText());

        driver.findElement(By.xpath(".//text()[. = 'Клиенты']")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("h2.title")).getText());
*/

        driver.close();
    }

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}