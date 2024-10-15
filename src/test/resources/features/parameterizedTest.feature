#language:ru
#encoding:UTF-8


  @BDD
  Функционал: Параметризированный запуск тестов 2

  Структура сценария: Проверка цены товара
    Допустим открыта страница "https://www.saucedemo.com/inventory.html"
    И выполнено нажатие на ссылку "<productName>"
    Тогда цена товара равна "<itemPrice>"


    Примеры:
      | productName                       | itemPrice |
      | Sauce Labs Backpack               | $29.99    |
      | Sauce Labs Fleece Jacket          | $15.99    |
      | Test.allTheThings() T-Shirt (Red) | $15.99    |
