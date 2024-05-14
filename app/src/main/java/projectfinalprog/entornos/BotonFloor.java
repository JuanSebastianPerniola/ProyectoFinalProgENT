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
 * ActionListener implementation for handling the "Floor" button click event.
 * Displays a table with data retrieved from the "Floor" table in the database.
 */

public class BotonFloor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Floor!");
        String url = "jdbc:mysql://localhost:3306/isaacbd";

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
}
