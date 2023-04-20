import implementations.Queue;
import implementations.Stack;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Queue<String> messageQueue = new Queue<>();
        Stack<String> messageStack = new Stack<>();

        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        String input;

        // Nhập tin nhắn
        while (true) {
            System.out.print("Enter message (type 'exit' to quit): ");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                if (input.length() > 250) {
                    throw new IllegalArgumentException("Message length must not exceed 250 characters");
                }
                messageQueue.enQueue(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Chuyển tin nhắn từ hàng đợi sang ngăn xếp
        while (!messageQueue.isEmpty()) {
            messageStack.push(messageQueue.deQueue());
        }

        // In ra tin nhắn theo thứ tự ngược lại từ ngăn xếp
        while (!messageStack.isEmpty()) {
            System.out.println("Processing message: " + messageStack.pop());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime) + " ms");

    }
}