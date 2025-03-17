package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app.controllers.Library;
import app.models.material.Material;
import app.models.material.Book;

public class LibraryTest {

    @Test
    public void testAddMaterial() {
        Library library = new Library();
        Material book = new Book("Title1", "Author1", 2020, "Genre1");
        assertTrue(library.addMaterial(book));
        assertFalse(library.addMaterial(null));
    }

    @Test
    public void testShowMaterial() {
        Library library = new Library();
        assertFalse(library.showMaterial());
        Material book = new Book("Title1", "Author1", 2020, "Genre1");
        library.addMaterial(book);
        assertTrue(library.showMaterial());
    }

    @Test
    public void testLendMaterial() {
        Library library = new Library();
        Material book = new Book("Title1", "Author1", 2020, "Genre1");
        library.addMaterial(book);
        assertFalse(library.lendMaterial(book));
        assertTrue(library.lendMaterial(book));
    }

    @Test
    public void testFindMaterial() {
        Library library = new Library();
        Material book = new Book("Title1", "Author1", 2020, "Genre1");
        library.addMaterial(book);
        assertNotNull(library.findMaterial("Title1"));
        assertNull(library.findMaterial("Title2"));
    }

    @Test
    public void testOrderMaterial() {
        Library library = new Library();
        Material book1 = new Book("Title1", "Author1", 2020, "Genre1");
        Material book2 = new Book("Title2", "Author2", 2019, "Genre2");
        library.addMaterial(book1);
        library.addMaterial(book2);
        assertTrue(library.orderMaterial());
    }
}
