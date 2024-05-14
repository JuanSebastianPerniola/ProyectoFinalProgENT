package projectfinalprog.entornos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * ActionListener implementation for handling the "InsertItem" button click event.
 * Displays a table with data retrieved from the "InserDataItem" table in the database.
 */
public class InserCharacter implements ActionListener {
    String url = "jdbc:mysql://localhost:3306/isaacbd";

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

            // Shut the connection wiht the bf
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
