/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import model.SubDominio;
import persistence.ConnectionFactory;

/**
 *
 * @author charles
 */
public class SubDominioDAO {
    private Connection connection;
    private int numResultados;

    public SubDominioDAO() throws DAOException {
        this.connection = ConnectionFactory.getConnection();
    }

    public List<SubDominio> consultaRelativa(String entrada, String mes) throws SQLException{
        List<SubDominio> resultados = new ArrayList<SubDominio>();
        PreparedStatement statement;
        ResultSet set;

        String SQL = "SELECT descricao, SUM(valor) AS soma FROM despesa desp, subdominio subd WHERE desp.datames = "
                + mes + " AND desp.codigosubdominio = subd.codigo AND descricaosubdominio ILIKE '%" + entrada +
                "%' GROUP BY subd.descricao ORDER BY soma DESC;";

        statement = connection.prepareStatement(SQL);
        set = statement.executeQuery();

        while(set.next()) {
            SubDominio sub = new SubDominio();
            sub.setDescricao(set.getString("descricao"));
            sub.setValor(set.getDouble("soma"));
            resultados.add(sub);
        }

        // System.out.println(resultados);
        return resultados;
    }
}
