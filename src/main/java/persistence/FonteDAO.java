/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author charles
 */

import model.Fonte;
import java.sql.*;

public class FonteDAO {
  private Connection connection;

  public FonteDAO() throws DAOException {
    this.connection = ConnectionFactory.getConnection();
  }

//  public Fonte PrimeiraConsulta(int offset, int limite, String nome) throws SQLException {
//    Fonte fonte = new Fonte();
//
//    PreparedStatement statement;
//    ResultSet set;
//  }
}
