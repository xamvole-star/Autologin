import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @BeforeAll
    static void setUp() {
        // Настройка User-Agent и скрытие флага автоматизации
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        Configuration.browserCapabilities = options;
        Configuration.timeout = 6000; // Увеличил таймаут, так как Google бывает "тяжелым"
    }

    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");

        // В Google поле поиска сейчас часто имеет тег textarea
        $("textarea[name='q']").setValue("selenide").pressEnter();

        // Проверка результата
        $("#search").shouldHave(text("https://selenide.org"));
    }
}
