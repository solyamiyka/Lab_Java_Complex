import menu.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static message.SendEmail.sendMessage;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

        try {
            // Create a file handler object
            FileHandler handler
                    = new FileHandler("logs.txt");
            handler.setFormatter(new SimpleFormatter());

            // Add file handler as
            // handler of logs
            logger.addHandler(handler);
            logger.info("Declaration of variables: Scanner, Console menu");

            Scanner sc = new Scanner(System.in);
            MainMenu menu = new MainMenu();

            logger.info("Call the function in which we use menu and select the command");
            while (true) {
                System.out.println("\n Available commands: ");
                menu.printAllCommands();
                System.out.println("\n Input your command(if you want to exit - print 'exit'): ");
                String command = sc.next();
                if (Objects.equals(command.toLowerCase(), "exit")) {
                    break;
                }
                menu.execute(command, logger);
            }
        } catch (Exception error) {
            logger.log(Level.WARNING, "Finding critical error: ", error);
            System.out.println("The error occurred.\n");
            sendMessage("Founded critical error: " + error);
            error.printStackTrace();

        }
    }
}