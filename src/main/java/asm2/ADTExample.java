package asm2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ADTExample {

    public static void main(String[] args) {
        Queue<String> messageQueue = new LinkedList<>();
        Stack<String> messageStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter messages (type 'exit' to finish):");

        String inputMessage;
        do {
            System.out.print("Enter a message (max 250 characters): ");
            inputMessage = scanner.nextLine();
            if (!inputMessage.equalsIgnoreCase("exit")) {
                try {
                    if (!inputMessage.trim().isEmpty()) { 
                        if (inputMessage.length() <= 250) {
                            messageQueue.offer(inputMessage);
                            System.out.println("Message added to the queue.");
                        } else {
                            System.out.println("Error: Message exceeds 250 characters.");
                        }
                    } else {
                        System.out.println("Error: Message cannot be empty.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
        } while (!inputMessage.equalsIgnoreCase("exit"));

        System.out.println("Messages in the queue: " + messageQueue);

        
        Stack<String> tempStack = new Stack<>();
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            messageStack.push(message);
            tempStack.push(message);
        }

        System.out.print("Messages in the stack: [");
        while (!tempStack.isEmpty()) {
            String message = tempStack.pop();
            System.out.print(message);
            if (!tempStack.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.println("Popping messages from the stack:");
        while (!messageStack.isEmpty()) {
            String message = messageStack.pop();
            System.out.println("Popped: " + message);
        }

        scanner.close();
    }
}
