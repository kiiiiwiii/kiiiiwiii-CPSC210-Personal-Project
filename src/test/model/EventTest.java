package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    private Event e;
    private Date d;

    @BeforeEach
    public void runBefore() {
        e = new Event("Added Suicide? to evidence history");
        d = Calendar.getInstance().getTime();
    }

    @Test
    public void testEvent() {
        assertEquals("Added Suicide? to evidence history", e.getDescription());
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Added Suicide? to evidence history", e.toString());
    }


    @Test
    public void testGetDate() {
        assertEquals(d, e.getDate());
    }
}

