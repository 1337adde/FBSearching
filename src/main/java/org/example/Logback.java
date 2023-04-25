package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logback {
    private static final Logger logger = LoggerFactory.getLogger(Logback.class);

    public static void iO() {
        logger.error("IOException when trying to input credentials.");
    }
    public static void nullPointer() {
        logger.error("NullPointerException when trying to input credentials.");
    }
    public static void searchSuccess() {logger.info("Search was successful.");}
    public static void searchFailure() {logger.error("Search failed.");}
    public static void navigationSuccess() {logger.info("User home page loaded.");}
    public static void navigationFailure() {logger.error("User home page not loaded correctly. Is there another Chrome window open?");}
    public static void searchInputSuccess() {logger.info("Search text input was successful.");}
    public static void searchInputFailure() {logger.error("Search text input failed.");}
    public static void logURL(String url) {logger.info("URL after search: " + url);}
}
