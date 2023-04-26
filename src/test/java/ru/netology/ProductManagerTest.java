package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ProductManagerTest {

    @Test
    public void addTestBook() {
        Repository repo = new Repository();
        ProductManager productManager = new ProductManager(repo);

        Book book1 = new Book(1, "Бег", 200, "Булгаков");
        Book book2 = new Book(2, "Лёд", 220, "Сорокин");
        Book book3 = new Book(3, "Дым", 150, "Тургенев");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);

        Product[] expected = repo.findAll();
        Product[] actual = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addTestSmartphone() {
        Repository repo = new Repository();
        ProductManager productManager = new ProductManager(repo);

        Smartphone smartphone1 = new Smartphone(4, "Samsung", 20000, "Korea");
        Smartphone smartphone2 = new Smartphone(5, "Nokia", 16000, "Finland");
        Smartphone smartphone3 = new Smartphone(6, "Nokia", 21000, "China");

        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] expected = repo.findAll();
        Product[] actual = {smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByOneProductsFound() {
        Repository repo = new Repository();
        ProductManager productManager = new ProductManager(repo);

        Book book1 = new Book(1, "Бег", 200, "Булгаков");
        Book book2 = new Book(2, "Лёд", 220, "Сорокин");
        Book book3 = new Book(3, "Дым", 150, "Тургенев");
        Smartphone smartphone1 = new Smartphone(4, "Samsung", 20000, "Korea");
        Smartphone smartphone2 = new Smartphone(5, "Nokia", 16000, "Finland");
        Smartphone smartphone3 = new Smartphone(6, "Nokia", 21000, "China");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] expected = productManager.searchBy("Лёд");
        Product[] actual = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByZeroProductsFound() {
        Repository repo = new Repository();
        ProductManager productManager = new ProductManager(repo);

        Book book1 = new Book(1, "Бег", 200, "Булгаков");
        Book book2 = new Book(2, "Лёд", 220, "Сорокин");
        Book book3 = new Book(3, "Дым", 150, "Сорокин");
        Smartphone smartphone1 = new Smartphone(4, "Samsung", 20000, "Korea");
        Smartphone smartphone2 = new Smartphone(5, "Nokia", 16000, "Finland");
        Smartphone smartphone3 = new Smartphone(6, "Nokia", 21000, "China");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] expected = productManager.searchBy("Лед");
        Product[] actual = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByManyProductsFound() {
        Repository repo = new Repository();
        ProductManager productManager = new ProductManager(repo);

        Book book1 = new Book(1, "Бег", 200, "Булгаков");
        Book book2 = new Book(2, "Лёд", 220, "Сорокин");
        Book book3 = new Book(3, "Дым", 150, "Сорокин");
        Smartphone smartphone1 = new Smartphone(4, "Samsung", 20000, "Korea");
        Smartphone smartphone2 = new Smartphone(5, "Nokia", 16000, "Finland");
        Smartphone smartphone3 = new Smartphone(6, "Nokia", 21000, "China");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] expected = productManager.searchBy("Nokia");
        Product[] actual = {smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }
}