package com.alekseysamoylov.serviceprices.util;

import java.math.BigDecimal;

/**
 * Хранилище всей информации о пользователе
 */
public class CustomerInformation {
    public static Long userId = 5L;
    public static BigDecimal userBonuses = BigDecimal.valueOf(900);
    private static boolean isAuthenticated = true;

    public static boolean userIsAuthenticated() {
        return isAuthenticated;
    }

    public static void logOut() {
        isAuthenticated = false;
    }

    public static void logIn(Long userId) {
        if (userId != null) {
            CustomerInformation.userId = userId;
            isAuthenticated = true;
        } else {
            isAuthenticated = false;
            CustomerInformation.userId = null;
        }
    }
}
