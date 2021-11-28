package blin.ann.pages.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {
    public CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    void credentialsTests() {
        String login = credentials.login();
        String password = credentials.password();
        String message = format(login, password);
        System.out.println("Логин: " + login);
        System.out.println("Пароль: " + password);

    }
}
