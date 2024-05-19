package org.stepik;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.stepik.data.Language;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelectLanguageTest extends TestBase {

    @EnumSource(Language.class)
    @ParameterizedTest(name = "Для языка {0} должен измениться заголовок")
    @DisplayName("После выбора языка изменяется заголовок")
    void siteShouldDisplayCorrectTitleTest(Language language) {
        $(".Link__Content").click();
        $$(".DropdownSelect__Item").find(text(language.name())).click();
        $(".H1Title__H1").shouldHave(text(language.description));
    }

    @MethodSource
    @ParameterizedTest(name = "Для языка {0} должны отображаться кнопки на соответствующем языке")
    @DisplayName("После выбора языка изменяются названия кнопок")
    void siteShouldDisplayCorrectButtons(Language language, List<String> expectedButtons) {
        $(".Link__Content").click();
        $$(".DropdownSelect__Item").find(text(language.name())).click();
        $$(".Nav__Item").filter(visible)
                .shouldHave(texts(expectedButtons));
    }

    static Stream<Arguments> siteShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(
                        Language.English,
                        List.of("Flights", "Rail tickets", "Charters", "Hotels")
                ),
                Arguments.of(
                        Language.Русский,
                        List.of("Авиабилеты", "Ж/Д билеты", "Чартеры", "Отели", "Онлайн-путешествия")
                )
        );
    }
    
@ValueSource(strings = {
        "Москва", "Нижневартовск", "Мурманск"
})
@ParameterizedTest(name = "Город {0} должен быть выбран в поле \"Город отправления\"")
@DisplayName("В поле \"Город отправления\" можно ввести несколько значений")
    void cityShouldBeSelectInCityFrom(String searchQuery) {
        $("[fieldname = 'from']").setValue(searchQuery);
        $(".AviaAirportInput__Suggestion__Value").
                $(byText(searchQuery)).click();
    }
}
