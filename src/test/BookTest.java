package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app.models.material.Book;

public class BookTest {
    @Test
    public void testBookConstructor() {
        Book book = new Book("Título", "Autor", 2023, "Género");
        assertEquals("Título", book.getTitle());
        assertEquals("Autor", book.getAuthor());
        assertEquals(2023, book.getPublished());
        assertEquals("Género", book.getGenre());
    }

    @Test
    public void testSetGenre() {
        Book book = new Book("Título", "Autor", 2023, "Género");
        book.setGenre("Nuevo Género");
        assertEquals("Nuevo Género", book.getGenre());
    }

    @Test
    public void testLend() {
        Book book = new Book("Título", "Autor", 2023, "Género");
        assertFalse(book.lend());
        assertTrue(book.lend());
    }

    @Test
    public void testRenew() {
        Book book = new Book("Título", "Autor", 2023, "Género");
        assertFalse(book.renew());
        book.lend();
        assertTrue(book.renew());
    }
}