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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import model.SubDominio;
import persistence.ConnectionFactory;

public class FonteDAO {

    private Connection connection;

    public FonteDAO() throws DAOException {
        this.connection = ConnectionFactory.getConnection();
    }

    public List<Fonte> consultaFonte(int offset) throws SQLException, DAOException {
        List<Fonte> resultados = new ArrayList<Fonte>();
        PreparedStatement statement;
        ResultSet set;

        String SQL = "SELECT f.descricao as DescricaoFonte, tipoLici.descricao as DescricaoTipoLicitacao, SUM(desp.valor) as soma FROM despesa desp, fonte f, orgao org, tipolicitacao tipoLici WHERE desp.codigofonte = f.codigo AND desp.codigoorgao = org.codigo AND desp.codigotipolicitacao = tipoLici.codigo GROUP BY f.descricao, tipoLici.descricao ORDER BY soma DESC LIMIT 10 OFFSET " + offset + ";";
        
        System.out.println(SQL);
        
        statement = connection.prepareStatement(SQL);
        set = statement.executeQuery();

        while (set.next()) {
            Fonte fonte = new Fonte();
            fonte.setFonte(set.getString("descricaofonte"));
            fonte.setValor(set.getDouble("soma"));
            fonte.setTipoLicitacao(set.getString("descricaotipolicitacao"));
            resultados.add(fonte);
        }

        return resultados;
    }
    
    public int pagFonte() throws SQLException, DAOException {
        PreparedStatement statement;
        ResultSet set;
        
        String SQL = "SELECT COUNT(*) FROM (SELECT f.descricao as DescricaoFonte, tipoLici.descricao as DescricaoTipoLicitacao, SUM(desp.valor) as soma FROM despesa desp, fonte f, orgao org, tipolicitacao tipoLici WHERE desp.codigofonte = f.codigo AND desp.codigoorgao = org.codigo AND desp.codigotipolicitacao = tipoLici.codigo GROUP BY f.descricao, tipoLici.descricao) as contador;";
        statement = connection.prepareStatement(SQL);
        set = statement.executeQuery();
        
        set.next();
        int paginas = set.getInt("count");
        return (paginas / 10) + 1;
    }
}
