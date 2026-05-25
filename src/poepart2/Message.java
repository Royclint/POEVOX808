/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Represents a message with sender, recipient, and content.
 */
package poepart2;

public class Message {
    private static int counter = 0;
    private String messageId;
    private String senderPhone;
    private String recipientPhone;
    private String content;

    public Message(String senderPhone, String recipientPhone, String content) {
        counter++;
        this.messageId = "MSG" + counter;
        this.senderPhone = senderPhone;
        this.recipientPhone = recipientPhone;
        this.content = content;
    }

    public String getMessageId() { return messageId; }
    public String getSenderPhone() { return senderPhone; }
    public String getRecipientPhone() { return recipientPhone; }
    public String getContent() { return content; }

    public String sendMessage() {
        return "Message successfully sent.";
    }
}
