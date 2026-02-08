package com.ranjit.harmony.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            ChromeOptions options = new ChromeOptions();

            // Jenkins / CI detection
            if (System.getenv("JENKINS_HOME") != null ||
                    "true".equalsIgnoreCase(System.getProperty("headless"))) {

                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            driver.set(new ChromeDriver(options));
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
