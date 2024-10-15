#language:en
#encoding:UTF-8


@BDD_test
Feature: Тест входа пользователя в систему
Scenario: Проверка входа
Given открыта страница "https://www.saucedemo.com/"
And в поле Username введено "standard_user"
And в поле Password введено "secret_sauce"
And нажата кнопка "Login"
Then осуществлен переход на страницу "https://www.saucedemo.com/inventory.html"