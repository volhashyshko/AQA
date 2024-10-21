#language:en
#encoding:UTF-8

@BDD_test
Feature: Тест входа пользователя в систему
Scenario Outline: Проверка входа
Given открыта страница "https://www.saucedemo.com/"
And в поле Username введено "<login>"
And в поле Password введено "<password>"
And нажата кнопка "Login"
Then осуществлен переход на страницу "https://www.saucedemo.com/inventory.html"

  Examples:
    | login                | password       |
    | standard_user        | secret_sauce   |
    | problem_user         | secret_sauce   |
    | visual_user          | secret_sauce   |
    | error_user           | secret_sauce   |