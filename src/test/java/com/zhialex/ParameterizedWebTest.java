package com.zhialex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedWebTest {

    static Stream<Arguments> commonSearchDataProvider() {
        return Stream.of(
                Arguments.of("Selenide", false, List.of("1", "2")),
                Arguments.of("Junit", true, List.of("3", "4"))
        );
    }

    //    @MethodSource("commonSearchDataProvider")
    @CsvSource(value = {
            "Selenide, Вышла Selenide",
            "JUnit, 5 is the next generation of"
    })
//    @ValueSource(strings = {"Selenide", "Allure"})
    @ParameterizedTest(name = "search algorithm check with params: {0}")
    void searchTest(String testData, String expectedResult) {
        open("https://ya.ru");
        $("#text").setValue(testData).pressEnter();
        $$("li.serp-item").first().shouldHave(text(expectedResult));
    }
}
