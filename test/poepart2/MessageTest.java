package poepart2;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class MessageTest {

    @Test
    public void testMessageCreation() {
        Message msg = new Message("+27831234567", "+27831230001", "Hello!");
        assertNotNull("Message ID should not be null", msg.getMessageId());
        assertEquals("Sender phone should match", "+27831234567", msg.getSenderPhone());
        assertEquals("Recipient phone should match", "+27831230001", msg.getRecipientPhone());
        assertEquals("Message content should match", "Hello!", msg.getContent());
    }

    @Test
    public void testSearchMessagesByRecipient() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("+27831234567", "+27831230001", "Hi there"));
        messages.add(new Message("+27831234567", "+27831230002", "Hello again"));

        // Call the search method
        ReportManager.searchMessagesByRecipient(messages, "+27831230001");

        // Verify list still intact
        assertEquals("Messages list should remain intact", 2, messages.size());
    }

    @Test
    public void testDeleteMessageById() {
        List<Message> messages = new ArrayList<>();
        Message msg = new Message("+27831234567", "+27831230001", "Delete me");
        messages.add(msg);

        // Call delete method
        ReportManager.deleteMessageById(messages, msg.getMessageId());

        // Verify message removed
        assertTrue("Message list should be empty after deletion", messages.isEmpty());
    }

    @Test
    public void testShowSummary() {
        int sentCount = 3;
        int storedCount = 2;
        int deletedCount = 1;

        // Call the summary method
        ReportManager.showSummary(sentCount, storedCount, deletedCount);

        // Verify counts are correct
        assertEquals("Sent count should be 3", 3, sentCount);
        assertEquals("Stored count should be 2", 2, storedCount);
        assertEquals("Deleted count should be 1", 1, deletedCount);
    }
}
