
package DAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

// DAO - ACESSO A OBJETOS

public class ConexaoDAO { 

   public Connection conectaBD() { // Metodo do tipo Connection
      Connection conn = null;      // Variavel do tipo Connection "conn"

      try {
        String url = "jdbc:mysql://localhost:3308/bancoteste?user=root&password=root";
        conn = DriverManager.getConnection(url);
        
      } catch (SQLException erro) {
         JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
      }
      return conn;
   }
}