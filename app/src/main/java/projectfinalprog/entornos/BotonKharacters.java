package projectfinalprog.entornos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener implementation for handling the "Kharacaters" button click event.
 * Displays a table with data retrieved from the "Kharacaters" table in the database.
 */
public class BotonKharacters implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Code to execute when Option 1 is clicked
        JOptionPane.showMessageDialog(null, "Kharacters!");
        String url = "jdbc:mysql://localhost:3306/isaacbd";

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

}
