package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import ru.netology.page.PersonalAreaPage;
import ru.netology.page.RefillPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

    @BeforeEach
    void setup() {
        Configuration.holdBrowserOpen = true;
        //open("http://localhost:9999");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        //var loginPage = new LoginPage();
        //var authInfo = DataHelper.getAuthInfo();
        //var verificationPage = loginPage.validLogin(authInfo);
       // var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
       // verificationPage.validVerify(verificationCode);
        var personalPage = new PersonalAreaPage();
        personalPage.getMaxCardBalance();
        if (personalPage.getNumberMax().equals("first")) {
            //var cardNumber = DataHelper.getCardNumberOne();
            //var refillPage = new RefillPage();
            //refillPage.getStartRefillPage(cardNumber);
        } else if (personalPage.getNumberMax().equals("second")) {
            //var cardNumber = DataHelper.getCardNumberTwo();
            //var refillPage = new RefillPage();
            //refillPage.getStartRefillPage(cardNumber);
        }
        var personalPageNew = new PersonalAreaPage();
        if (PersonalAreaPage.getNumberMax().equals("first")) {
            int expected1 = PersonalAreaPage.getCardBalanceMax()-PersonalAreaPage.getDifferenceToReduce();
            int actual1 = personalPageNew.getCardBalanceFirst();
            assertEquals(expected1, actual1);
            int expected2 = PersonalAreaPage.getCardBalanceMin()+PersonalAreaPage.getDifferenceToReduce();
            int actual2 = personalPageNew.getCardBalanceSecond();
            assertEquals(expected2, actual2);
        } else if (PersonalAreaPage.getNumberMax().equals("second")) {
            int expected1 = PersonalAreaPage.getCardBalanceMax()-PersonalAreaPage.getDifferenceToReduce();
            int actual1 = personalPageNew.getCardBalanceSecond();
            assertEquals(expected1, actual1);
            int expected2 = PersonalAreaPage.getCardBalanceMin()+PersonalAreaPage.getDifferenceToReduce();
            int actual2 = personalPageNew.getCardBalanceFirst();
            assertEquals(expected2, actual2);
        }
    }

}