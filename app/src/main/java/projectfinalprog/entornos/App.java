package projectfinalprog.entornos;

//prog final project
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class represents a simple Java application that displays a menu with
 */
public class App extends JFrame {
    /**
     * This class represents a simple Java application that displays a menu with
     * several options
     * to interact with a database.
     */

    /**
     * The panel that contains the menu buttons.
     */
    private JPanel menuPanel;

    JCheckBox qualityCheckBox = new JCheckBox("Sort by Quality");

    public App() {
        /**
         * Constructor for the App class.
         * Initializes the application and sets up the menu panel.
         */
        String url = "jdbc:mysql://localhost:3306/isaacbd";
        setTitle("Java Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1));

        JButton button1 = new JButton("Kharacters");
        button1.addActionListener(new ActionListener() {
            /**
             * ActionListener implementation for handling the "Kharacters" button click
             * event.
             * Displays a table with data retrieved from the "kharacter" table in the
             * database.
             * 
             * @param e The ActionEvent object representing the event that occurred.
             */
            @Override

            public void actionPerformed(ActionEvent e) {
                // Code to execute when Option 1 is clicked
                JOptionPane.showMessageDialog(null, "Kharacters!");

                // Connect to the database
                try {
                    Connection connection = DriverManager.getConnection(url, "root", "");
                    java.sql.Statement statement = connection.createStatement();
                    String query = "SELECT * FROM kharacter";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Create a table model to hold the data
                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("ID");
                    tableModel.addColumn("Name");
                    tableModel.addColumn("ItemStarted");

                    // Populate the table model with the data from the result set
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String itemStarted = resultSet.getString("itemStarted");
                        tableModel.addRow(new Object[] { id, name, itemStarted });
                    }

                    // Create a table to display the data
                    JTable table = new JTable(tableModel);

                    // Create a scroll pane to hold the table
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Show the table in a dialog
                    JOptionPane.showMessageDialog(null, scrollPane);

                    // Close the database connection
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton button2 = new JButton("Floor");
        button2.addActionListener(new ActionListener() {
            /**
             * ActionListener implementation for handling the "Floor" button click event.
             * Displays a table with data retrieved from the "floor" table in the database.
             * 
             * @param e The ActionEvent object representing the event that occurred.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Option 2 clicked!");

                try {
                    Connection connection = DriverManager.getConnection(url, "root", "");
                    java.sql.Statement statement = connection.createStatement();
                    String query = "SELECT * FROM floor";
                    ResultSet result = statement.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel();
                    // add floor columns
                    tableModel.addColumn("ID");
                    tableModel.addColumn("TipoFloor");
                    while (result.next()) {
                        int id = result.getInt("id");
                        String tipoFloor = result.getString("tipoFloor");
                        tableModel.addRow(new Object[] { id, tipoFloor });
                    }

                    JTable table = new JTable(tableModel);

                    JScrollPane scrollPane = new JScrollPane(table);

                    JOptionPane.showMessageDialog(null, scrollPane);

                    // Close the database connection
                    result.close();
                    statement.close();
                    connection.close();
                } catch (SQLException exs) {
                    exs.printStackTrace();
                }
            }
        });

        JButton button3 = new JButton("Items");
        button3.addActionListener(new ActionListener() {
            /**
             * ActionListener implementation for handling the "Items" button click event.
             * Displays a table with data retrieved from the "items" table in the database.
             * 
             * @param e The ActionEvent object representing the event that occurred.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Options items selected!");

                try {
                    Connection connection = DriverManager.getConnection(url, "root", "");
                    java.sql.Statement statement = connection.createStatement();
                    String query = "SELECT * FROM items";
                    ResultSet result = statement.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel();
                    // add floor columns
                    tableModel.addColumn("id");
                    tableModel.addColumn("Name");
                    tableModel.addColumn("Quality");
                    tableModel.addColumn("ChanceToDrop");
                    tableModel.addColumn("idFloor");
                    while (result.next()) {
                        int id = result.getInt("id");
                        String name = result.getString("name");
                        String quality = result.getString("quality");
                        int chanceToDrop = result.getInt("chanceToDrop");
                        int idFloor = result.getInt("idFloor");
                        tableModel.addRow(new Object[] { id, name, quality, chanceToDrop, idFloor });
                    }

                    JTable table = new JTable(tableModel);

                    JScrollPane scrollPane = new JScrollPane(table);

                    JOptionPane.showMessageDialog(null, scrollPane);

                    // Close the database connection
                    result.close();
                    statement.close();
                    connection.close();
                } catch (SQLException exs) {
                    exs.printStackTrace();
                }
            }
        });

        JButton button4 = new JButton("Bosses");
        button4.addActionListener(new ActionListener() {
            /**
             * ActionListener implementation for handling the "Bosses" button click event.
             * Displays a table with data retrieved from the "bosses" table in the database.
             * 
             * @param e The ActionEvent object representing the event that occurred.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Options Bosses selected!");

                try {
                    Connection connection = DriverManager.getConnection(url, "root", "");
                    java.sql.Statement statement = connection.createStatement();
                    String query = "SELECT * FROM bosses";
                    ResultSet result = statement.executeQuery(query);
                    DefaultTableModel tableModel = new DefaultTableModel();
                    // add floor columns
                    tableModel.addColumn("id");
                    tableModel.addColumn("Name");
                    tableModel.addColumn("FlooApparence");
                    while (result.next()) {
                        int id = result.getInt("id");
                        String name = result.getString("name");
                        String floorApareance = result.getString("FlooApparence");
                        tableModel.addRow(new Object[] { id, name, floorApareance });
                    }

                    JTable table = new JTable(tableModel);

                    JScrollPane scrollPane = new JScrollPane(table);

                    JOptionPane.showMessageDialog(null, scrollPane);

                    menuPanel.add(qualityCheckBox);

                    // Close the database connection
                    result.close();
                    statement.close();
                    connection.close();
                } catch (SQLException exs) {
                    exs.printStackTrace();
                }
            }
        });

        JButton button5 = new JButton("add item");
        button5.addActionListener(new ActionListener() {
            /**
             * ActionListener implementation for handling the "add item" button click event.
             * Allows the user to input data for a new item and inserts it into the "items"
             * table in the database.
             * 
             * @param e The ActionEvent object representing the event that occurred.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Opción seleccionada!");

                try {
                    String name = JOptionPane.showInputDialog("Nombre del ítem:");
                    String quality = JOptionPane.showInputDialog("Calidad:");
                    double chanceToDrop = Double.parseDouble(JOptionPane.showInputDialog("Probabilidad de caída:"));
                    int idFloor = Integer.parseInt(JOptionPane.showInputDialog("ID del piso:"));

                    Connection connection = DriverManager.getConnection(url, "root", "");
                    PreparedStatement statement = connection.prepareStatement(
                            "INSERT INTO items (name, quality, chanceToDrop, idFloor) VALUES (?, ?, ?, ?)");
                    statement.setString(1, name);
                    statement.setString(2, quality);
                    statement.setDouble(3, chanceToDrop);
                    statement.setInt(4, idFloor);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Se ha insertado el ítem correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo insertar el ítem.");
                    }

                    // Cerrar la conexión a la base de datos
                    statement.close();
                    connection.close();
                } catch (SQLException | NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }

        });

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
        new App();
    }
}