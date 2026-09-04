import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class LoginTests {
    /*
    adsfasdf\
    автоматизация входа
    */

    @Test
    void SccsessefullLoginTest(){
        Configuration.holdBrowserOpen = true;
        open("https://school.qa.guru/cms/system/login");
        // $(By.name("user.name")).setValue("johny");
        $(".login-form").shouldHave(text("Войти")); // Waits until element gets text
        $("[name=email]").setValue("menkuzin@bk.ru");
        $("[name=password]").setValue("menkuzin@bk.ru"); //.pressEnter();
        $("[id=xdgetr4464_1_1_1]").click(); //альтернатива нажатия на кнопку, вместо энтера сверху
        $("[id=xdgetr2637_1_1_1]").click();
    }

    @Test
    void UnSccsessefullLoginTest(){

    }

}
