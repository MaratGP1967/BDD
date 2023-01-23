package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;
import static com.codeborne.selenide.Selenide.$;

public class RefillPage {

    private SelenideElement transferAmount = $("[data-test-id=amount] input");
    private SelenideElement cardNumberInput = $("[data-test-id=from] input");
    private SelenideElement confirmButton = $("[data-test-id=action-transfer]");

    public PersonalAreaPage getStartRefillPage(DataHelper.CardNumber code, int sum) {
        transferAmount.setValue(String.valueOf(sum));
        cardNumberInput.setValue(code.getCode());
        confirmButton.click();
        return new PersonalAreaPage();
    }

}
