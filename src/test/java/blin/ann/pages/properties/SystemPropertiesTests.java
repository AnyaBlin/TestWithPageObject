package blin.ann.pages.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Tag("properties")
    void someTests () {
        String value = System.getProperty("value","default_value");
        System.out.println(value);
    }
}
