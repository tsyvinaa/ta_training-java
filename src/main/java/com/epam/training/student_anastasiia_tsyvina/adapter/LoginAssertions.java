package com.epam.training.student_anastasiia_tsyvina.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assertj.core.api.Assertions;

public class LoginAssertions {
    private static final Logger logger = LoggerFactory.getLogger(LoginAssertions.class);

    public static void assertError(String actualMessage, String expectedMessage) {
        if (!actualMessage.equals(expectedMessage)) {
            logger.error("ERROR TEXT MISMATCH: expected='{}' but was='{}'", expectedMessage, actualMessage);
        } else {
            logger.info("Correct error message: '{}'", actualMessage);
        }
        Assertions.assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    public static void assertSuccessUrl(String url) {
        if (!url.contains("/inventory.html")) {
            logger.error("URL did not change after login. Actual URL: {}", url);
        } else {
            logger.info("Redirected to correct URL: {}", url);
        }
        Assertions.assertThat(url).contains("/inventory.html");
    }
}
