package blin.ann.pages.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Вывод данных из credentials.properties")
@Tag("properties")
public class OwnerTests {
    public CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    @DisplayName("Вывод логина и пароля")
    void credentialsTests() {
        step("Читаем данные", () -> {
            String login = credentials.login();
            String password = credentials.password();
            step("Выводим данные", () -> {
                System.out.println("Логин: " + login);
                System.out.println("Пароль: " + password);
            });
        });
    }
}
