package ru.forma.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage<P extends BasePage<P>> {
    private static final String MAIN_HEADER_XPATH = "//*[contains(@class,'MainHeader__wrapper')]";


    public ModalMenuHeader openModalMenu() {
        $(By.xpath(MAIN_HEADER_XPATH + "//button[@class='MainHeader__item']/span[text()='меню']")).click();
        return new ModalMenuHeader();
    }

    public class ModalMenuHeader {
        private static final String MODAL_MENU_XPATH = "//*[contains(@class,'BurgerMenu show')]";

        public AboutPage openAbout(){
            $(By.xpath(MODAL_MENU_XPATH + "//a[@href='/about']")).click();
            return new AboutPage();
        }

        public P close() {
            $(By.xpath(MODAL_MENU_XPATH + "//*[contains(@class,'ModalCloser')]")).click();
            return (P) BasePage.this;
        }

    }
}
