
package com.epam.training.student_anastasiia_tsyvina.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
            {"", "", "Epic sadface: Username is required"},
            {"standard_user", "", "Epic sadface: Password is required"},
            {"standard_user", "secret_sauce", "success"}
        };
    }
}
