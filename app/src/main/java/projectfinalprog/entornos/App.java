package projectfinalprog.entornos;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a simple Java application that displays a menu with
 * several options
 * to interact with a database.
 * 
 * <p>
 * The main purpose of this application is to provide a user-friendly interface
 * for managing
 * various aspects of a database, such as characters, floors, items, and bosses.
 * </p>
 * 
 * <p>
 * The application utilizes Swing for creating the graphical user interface
 * (GUI) and connects
 * to a MySQL database using JDBC.
 * </p>
 * 
 * <p>
 * The developer environments used for this project include Java, MySQL, and an
 * integrated
 * development environment (IDE) such as IntelliJ IDEA or Eclipse.
 * </p>
 */
public class App extends JFrame {

    private JPanel menuPanel;

    public App() {
        setTitle("Java Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1));
        /* First button for k */
        JButton button1 = new JButton("Kharacters");
        button1.addActionListener(new BotonKharacters());
        /* Second buttton */
        JButton button2 = new JButton("Floor");
        button2.addActionListener(new BotonFloor());
        /* Third button for k */
        JButton button3 = new JButton("Items");
        button3.addActionListener(new BotonItem());
        /* Fourth button for k */
        JButton button4 = new JButton("Bosses");
        button4.addActionListener(new BotonBosses());
        /* Fifth button for k */
        JButton button5 = new JButton("add item");
        button5.addActionListener(new InserCharacter());

        // add existing buttons to the panel
        menuPanel.add(button1);
        menuPanel.add(button2);
        menuPanel.add(button3);
        menuPanel.add(button4);
        menuPanel.add(button5);

        add(menuPanel);
        setVisible(true);
    }

    /**
     * Main method to run the application.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        /**
         * Create a new instance of the App class to start the application.
         */
        new App();
    }
}