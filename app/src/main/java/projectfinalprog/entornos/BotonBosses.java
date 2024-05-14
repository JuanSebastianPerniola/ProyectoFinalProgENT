package projectfinalprog.entornos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * ActionListener implementation for handling the "Bosses" button click event.
 * Displays a table with data retrieved from the "bosses" table in the database.
 */
public class BotonBosses implements ActionListener {

    String url = "jdbc:mysql://localhost:3306/isaacbd";
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
                tableModel.addRow(new Object[]{id, name, floorApareance});
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
}
