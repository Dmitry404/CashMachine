package ua.in.dmitry404.money;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * This class contains unit-tests for NotesHolder
 * 
 * @author Dmitriy Butakov
 */
public class NotesHolderTest {
    NotesHolder notesHolder;

    @Before
    public void setUp() {
        notesHolder = new NotesHolder();
    }

    @Test
    public void testNotesHolderIsEmpty() {
        assertTrue(notesHolder.isEmpty());
    }

    @Test
    public void testGetNotesQuantity() {
        int banknoteValue1 = 50;
        int banknoteValue2 = 100;
        int banknoteQuantity1 = 1;
        int banknoteQuantity2 = 5;

        notesHolder.put(banknoteValue1, banknoteQuantity1);
        notesHolder.put(banknoteValue2, banknoteQuantity2);
        
        assertEquals(banknoteQuantity1, notesHolder.getQuantity(banknoteValue1));
        assertEquals(banknoteQuantity2, notesHolder.getQuantity(banknoteValue2));
    }

    @Test
    public void testContainsNotes() {
        int banknoteValue = 50;
        int notExistingBanknoteValue = 100;

        notesHolder.put(banknoteValue, 1);

        assertTrue(notesHolder.contains(banknoteValue));
        assertFalse(notesHolder.contains(notExistingBanknoteValue));
    }

    @Test
    public void testGetNotesValues() {
        int banknoteValue1 = 500;
        int banknoteValue2 = 100;
        int banknoteValue3 = 10;

        int expectedSize = 3;

        notesHolder.put(banknoteValue1, 1);
        notesHolder.put(banknoteValue2, 1);
        notesHolder.put(banknoteValue3, 1);

        Set<Integer> values = notesHolder.getValues();

        assertEquals(expectedSize, values.size());
        assertTrue(values.contains(banknoteValue1));
        assertTrue(values.contains(banknoteValue2));
        assertTrue(values.contains(banknoteValue3));
    }

    @Test
    public void testAddNotes() {
        int banknoteValue = 10;
        int banknoteQuantity = 1;
        int expectedQuantity = banknoteQuantity * 2;

        notesHolder.add(banknoteValue, banknoteQuantity);
        notesHolder.add(banknoteValue, banknoteQuantity);

        assertTrue(notesHolder.contains(banknoteValue));
        assertEquals(expectedQuantity, notesHolder.getQuantity(banknoteValue));
    }

    @Test
    public void testPutNotes() {
        int banknoteValue = 10;
        int banknoteQuantity = 1;
        int expectedQuantity = banknoteQuantity;

        notesHolder.put(banknoteValue, banknoteQuantity);
        notesHolder.put(banknoteValue, banknoteQuantity);

        assertTrue(notesHolder.contains(banknoteValue));
        assertEquals(expectedQuantity, notesHolder.getQuantity(banknoteValue));
    }

    @Test
    public void testPopNotes() {
        int banknoteValue = 10;
        int banknoteQuantity = 1;

        notesHolder.put(banknoteValue, banknoteQuantity);
        notesHolder.pop(banknoteValue, banknoteQuantity);

        assertFalse(notesHolder.contains(banknoteValue));
    }
}