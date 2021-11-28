package blin.ann.pages.properties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка браузера")
public class SystemPropertiesTests {
    @Test
    @Tag("properties")
    void someTests() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }
}

