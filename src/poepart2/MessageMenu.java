package poepart2;
import java.util.*;

public class MessageMenu {
    private static List<Message> storedMessages = new ArrayList<>();

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Send Message");
        System.out.println("2. Store Message");
        System.out.println("3. Delete Message");

        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter sender phone: ");
                String sender = sc.nextLine();
                System.out.print("Enter recipient phone: ");
                String recipient = sc.nextLine();
                System.out.print("Enter message content: ");
                String content = sc.nextLine();
                Message sent = new Message(sender, recipient, content);
                System.out.println("Message sent! ID: " + sent.getMessageId());
                break;

            case 2:
                System.out.print("Enter sender phone: ");
                sender = sc.nextLine();
                System.out.print("Enter recipient phone: ");
                recipient = sc.nextLine();
                System.out.print("Enter message content: ");
                content = sc.nextLine();
                Message stored = new Message(sender, recipient, content);
                storedMessages.add(stored);
                System.out.println("Message stored! ID: " + stored.getMessageId());
                break;

            case 3:
                if (storedMessages.isEmpty()) {
                    System.out.println("No stored messages to delete.");
                } else {
                    Message deleted = storedMessages.remove(storedMessages.size() - 1);
                    System.out.println("Deleted message ID: " + deleted.getMessageId());
                }
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        showMenu();
    }
}
