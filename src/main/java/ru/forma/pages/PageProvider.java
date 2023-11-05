package ru.forma.pages;

import com.codeborne.selenide.Selenide;

import java.lang.reflect.InvocationTargetException;

public class PageProvider {
    public static PageProvider PAGE = new PageProvider();

    private PageProvider() {
    }

    public static <E extends BasePage<E>> E openPageByUrl(final Class<E> pageClass, String url) {
        Selenide.open(url);
        return get(pageClass);
    }

    public static <E extends BasePage<E>> E get(final Class<E> pageClass) {
        try {
            return pageClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }

    public MainPage getMainPage(){
        return new MainPage();
    }
}
