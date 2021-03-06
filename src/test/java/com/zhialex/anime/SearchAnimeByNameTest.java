package com.zhialex.anime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchAnimeByNameTest extends BaseTest {

    static Stream<Arguments> commonSearchDataProvider() {
        return Stream.of(
                Arguments.of("Karakai Jouzu", "В классе Нисикаты учится девочка по имени Такаги."),
                Arguments.of("Vanitas no Karte", "Быть белой вороной может не только обычный человек, но и вампир.")
        );
    }

    @CsvSource(value = {
            "Naruto, Это мой путь ниндзя!",
            "Steins;Gate, Сняв в Акихабаре квартиру"
    })
    @ParameterizedTest(name = "Проверка, что находится нужное аниме : {0}")
    public void searchAnimeByNameTest(String animeName, String description) {
        open("https://smotret-anime.online/catalog/search");
        $(".row .m-big-search-input").setValue(animeName).pressEnter();
        $$x("//div[@class='m-catalog-item__description']").findBy(text(description)).shouldBe(visible);
    }

    @MethodSource("commonSearchDataProvider")
    @ParameterizedTest(name = "Проверка, что находится нужное аниме")
    public void searchAnimeByNameWithMethodSourceTest(String animeName, String description) {
        open("https://smotret-anime.online/catalog/search");
        $(".row .m-big-search-input").setValue(animeName).pressEnter();
        $$x("//div[@class='m-catalog-item__description']").findBy(text(description)).shouldBe(visible);
    }
}
