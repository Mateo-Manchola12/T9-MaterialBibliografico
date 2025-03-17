package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app.models.material.Journal;

public class JournalTest {
    @Test
    public void testJournalConstructor() {
        Journal journal = new Journal("Título", "Autor", 2023, 1);
        assertEquals("Título", journal.getTitle());
        assertEquals("Autor", journal.getAuthor());
        assertEquals(2023, journal.getPublished());
        assertEquals(1, journal.getIssue());
    }

    @Test
    public void testSetIssue() {
        Journal journal = new Journal("Título", "Autor", 2023, 1);
        journal.setIssue(2);
        assertEquals(2, journal.getIssue());
    }

    @Test
    public void testLend() {
        Journal journal = new Journal("Título", "Autor", 2023, 1);
        assertFalse(journal.lend());
        assertTrue(journal.lend());
    }
}