package com.zhialex.anime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchAnimeByNameTest extends BaseTest {

    @CsvSource(value = {
            "Naruto, Это мой путь ниндзя!",
            "Steins;Gate, Сняв в Акихабаре квартиру"
    })
    @ParameterizedTest(name = "Проверка, что находится нужное аниме : {0}")
    public void searchAnimeByNameTest(String animeName, String description) {
        open("https://smotret-anime.online/");
        $x("//div[@class='card']//a[text()='Поиск по названию']").click();
        $(".row .m-big-search-input").setValue(animeName).pressEnter();
        $$(".m-catalog-item__description").first().shouldHave(text(description));
    }
}
