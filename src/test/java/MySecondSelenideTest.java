import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MySecondSelenideTest {

    @Test
    public void firstTest() {
    open("https://www.ukrposhta.ua/ua");
  
        $(By.xpath("//input[@value='Погоджуюсь']")).click();
        $(By.xpath("//span[text()='Розрахувати']")).click();
        $("button.submitButton[aria-label=\"Close\"]").click();
        $(By.xpath("//button[text()=\" Розрахувати вартість \"]")).shouldBe(Condition.disabled);

        $(By.xpath("//input[@id=\"fromWhere\"]")).setValue("Харків").pressEnter();
        $(By.xpath("//*[@id=\"main\"]/div/div/div/app-domestic-calculator/dynamic-form/form/form-select[1]/div/div/ul/div/button[1]")).click();
        $(By.xpath("//input[@id=\"toWhere\"]")).setValue("Харків").pressEnter();
        $(By.xpath("//*[@id=\"main\"]/div/div/div/app-domestic-calculator/dynamic-form/form/form-select[2]/div/div/ul/div/button[1]")).click();
        $("input[placeholder='кг']").setValue("20");
        $("input[placeholder='см']").setValue("20");
        $(By.xpath("//button[text()=\" Розрахувати вартість \"]")).shouldBe(Condition.enabled);

    }


}
