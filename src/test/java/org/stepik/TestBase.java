package org.stepik;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.aviakassa.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @BeforeEach
    void setUp() {
        open("");
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
