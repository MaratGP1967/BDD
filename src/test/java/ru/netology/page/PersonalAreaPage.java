package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.*;

public class PersonalAreaPage {

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private final String locatorOne = "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button";
    private final String locatorTwo ="[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button";
    private SelenideElement firstBalanceButton = $(locatorOne);
    private SelenideElement secondBalanceButton = $(locatorTwo);
    private final String idOne = locatorOne.substring(locatorOne.indexOf('\'') + 1, locatorOne.lastIndexOf('\''));
    private final String idTwo = locatorTwo.substring(locatorTwo.indexOf('\'') + 1, locatorTwo.lastIndexOf('\''));
    private static int cardBalanceMax;
    private static String numberMax;

    public static int getCardBalanceMax() {
        return cardBalanceMax;
    }

    public static String getNumberMax() {
        return numberMax;
    }

    public RefillPage getMaxCardBalance() {
        if (getCardBalance(idTwo) >= getCardBalance(idOne)) {
            cardBalanceMax = getCardBalance(idTwo);
            numberMax = "second";
            firstBalanceButton.click();
        } else {
            cardBalanceMax = getCardBalance(idOne);
            numberMax = "first";
            secondBalanceButton.click();
        }
        return new RefillPage();
    }


    public int getCardBalance(String id) {
        val text = cards.find(Condition.attribute("data-test-id", id)).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getCardBalanceFirst() {
        return getCardBalance(idOne);
    }

}
