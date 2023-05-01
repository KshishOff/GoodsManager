package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RepositoryTest {
    @Test
    public void testRepositoryDeleteById() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Бег", 200, "Булгаков");
        Book book2 = new Book(2, "Лёд", 220, "Сорокин");
        Book book3 = new Book(3, "Дым", 150, "Сорокин");
        Smartphone smartphone1 = new Smartphone(4, "Samsung", 20000, "Korea");
        Smartphone smartphone2 = new Smartphone(5, "Nokia", 16000, "Finland");
        Smartphone smartphone3 = new Smartphone(6, "Nokia", 21000, "China");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);

        repo.deleteById(2);

        Product[] expected = repo.findAll();
        Product[] actual = {book1, book3, smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepositoryDeleteByIdDoesNotExist() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Бег", 200, "Булгаков");
        Book book2 = new Book(2, "Лёд", 220, "Сорокин");
        Book book3 = new Book(3, "Дым", 150, "Сорокин");
        Smartphone smartphone1 = new Smartphone(4, "Samsung", 20000, "Korea");
        Smartphone smartphone2 = new Smartphone(5, "Nokia", 16000, "Finland");
        Smartphone smartphone3 = new Smartphone(6, "Nokia", 21000, "China");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
                repo.deleteById(7);
        });

    }
}