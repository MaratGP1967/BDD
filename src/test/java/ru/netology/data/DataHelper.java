package ru.netology.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo(String login,String password) {
        return new AuthInfo(login, password);
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(String code) {
        return new VerificationCode(code);
    }

    @Value
    public static class CardNumber {
        private String code;
    }

    public static CardNumber getCardNumberOne() {
        return new CardNumber("5559 0000 0000 0001");
    }
    public static CardNumber getCardNumberTwo() {
        return new CardNumber("5559 0000 0000 0002");
    }
}