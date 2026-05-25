/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Unit tests for the Message class (multiple message sending logic).
 */
package poepart2;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageIT {

    @Test
    public void testMessageIdGenerationUnique() {
        Message msg1 = new Message("+27614767216", "+27610000001", "Hello!");
        Message msg2 = new Message("+27614767216", "+27610000002", "How are you?");
        assertNotEquals("Message IDs should be unique", msg1.getMessageId(), msg2.getMessageId());
    }

    @Test
    public void testSendMessageConfirmation() {
        Message msg = new Message("+27614767216", "+27610000001", "Test message");
        assertEquals("Message successfully sent.", msg.sendMessage());
    }

    @Test
    public void testMessageContentStored() {
        Message msg = new Message("+27614767216", "+27610000001", "Stored content");
        assertEquals("Stored content", msg.getContent());
    }

    @Test
    public void testMessageSenderStored() {
        Message msg = new Message("+27614767216", "+27610000001", "Sender test");
        assertEquals("+27614767216", msg.getSenderPhone());
    }

    @Test
    public void testMessageRecipientStored() {
        Message msg = new Message("+27614767216", "+27610000001", "Recipient test");
        assertEquals("+27610000001", msg.getRecipientPhone());
    }

    @Test
    public void testMultipleMessagesLoopSimulation() {
        int messageCount = 3;
        for (int i = 1; i <= messageCount; i++) {
            Message msg = new Message("+27614767216", "+2761000000" + i, "Message " + i);
            assertEquals("Message successfully sent.", msg.sendMessage());
        }
    }
}
