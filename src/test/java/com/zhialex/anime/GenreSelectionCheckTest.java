package com.zhialex.anime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GenreSelectionCheckTest extends BaseTest{

    @ValueSource(strings = {"Экшен", "Этти"})
    @ParameterizedTest(name = "Проверка, что выбирается верный жанр : {0}")
    public void genreSelectionCheckTest(String testData) {
        open("https://smotret-anime.online/");
        $x("//div[@class='card']//a[text()='Поиск по жанрам']").click();
        $x("//div[@class='card']//a[text()='" + testData + "']").click();
        $(".card h1").shouldHave(text("Каталог аниме в жанре " + testData.toLowerCase()));
    }
}
