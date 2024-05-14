package projectfinalprog.entornos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * ActionListener implementation for handling the "Item" button click event.
 * Displays a table with data retrieved from the "Item" table in the database.
 */
public class BotonItem implements ActionListener {
    private DefaultTableModel tableModelItems = new DefaultTableModel();
    private String url = "jdbc:mysql://localhost:3306/isaacbd";

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Options items selected!");

        JCheckBox checkOrderBox = new JCheckBox("Order by quality");

        checkOrderBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (checkOrderBox.isSelected()) {
                        String query = "SELECT * FROM items ORDER BY Quality DESC";

                        Connection connection = DriverManager.getConnection(url, "root", "");
                        java.sql.Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(query);

                        tableModelItems.setRowCount(0);
                        while (result.next()) {
                            int id = result.getInt("id");
                            String name = result.getString("name");
                            String quality = result.getString("quality");
                            tableModelItems.addRow(new Object[] { id, name, quality });
                        }

                        result.close();
                        statement.close();
                        connection.close();
                    } else {
                        String query = "SELECT * FROM items";

                        Connection connection = DriverManager.getConnection(url, "root", "");
                        java.sql.Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(query);

                        tableModelItems.setRowCount(0);
                        while (result.next()) {
                            int id = result.getInt("id");
                            String name = result.getString("name");
                            String quality = result.getString("quality");
                            // Añade cada fila ordenada por calidad al modelo de tabla
                            tableModelItems.addRow(new Object[] { id, name, quality });
                        }
                        result.close();
                        statement.close();
                        connection.close();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        try {
            Connection connection = DriverManager.getConnection(url, "root", "");
            java.sql.Statement statement = connection.createStatement();
            String query = "SELECT * FROM items";

            ResultSet result = statement.executeQuery(query);
            tableModelItems.addColumn("id");
            tableModelItems.addColumn("Name");
            tableModelItems.addColumn("Quality");
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String quality = result.getString("quality");
                int chanceToDrop = result.getInt("chanceToDrop");
                int idFloor = result.getInt("idFloor");
                tableModelItems.addRow(new Object[] { id, name, quality, chanceToDrop, idFloor });
            }

            // Agrega el JCheckBox al contenedor adecuado (por ejemplo, un JPanel)
            JPanel panel = new JPanel();
            panel.add(checkOrderBox);

            // Crea la tabla y el scrollPane
            JTable table = new JTable(tableModelItems);
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane); // Agrega la tabla al panel junto con el JCheckBox

            // Muestra el panel en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, panel);

            // Close the database connection
            result.close();
            statement.close();
            connection.close();

        } catch (SQLException exs) {
            exs.printStackTrace();
        }
    }
}
