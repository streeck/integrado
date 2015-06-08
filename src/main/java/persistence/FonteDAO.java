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

    public List<Fonte> PrimeiraConsulta(int limit) throws SQLException, DAOException {
        List<Fonte>fonte = new ArrayList<Fonte>();
        PreparedStatement statement;
        ResultSet set;
        

        String SQL = "CREATE OR REPLACE FUNCTION retorna_maior_valor() RETURNS TABLE(descricaoFonte VARCHAR, maiorValor numeric) AS $$\n"
                + "BEGIN\n"
                + "	RETURN QUERY\n"
                + "		SELECT descricao, SUM(valor) as soma\n"
                + "			FROM despesa desp, subdominio subd\n"
                + "				WHERE desp.codigosubdominio = subd.codigo\n"
                + "					GROUP BY subd.descricao ORDER BY soma DESC LIMIT"+ limit + ";\n"
                + "END;\n"
                + "$$ LANGUAGE plpgsql;\n"
                + "\n"
                + "SELECT * FROM retorna_maior_valor();";

        statement = connection.prepareStatement(SQL);
        set = statement.executeQuery();
        
        while (set.next()) {
            Fonte font = new Fonte();
            fonte.add(font);
        }

        System.out.println(fonte);
        return fonte;
    }

    public List<Fonte> SegundaConsulta(int offset) throws SQLException, DAOException {
        List<Fonte> fonte = new ArrayList<Fonte>();
        PreparedStatement statement;
        ResultSet set;
        

        String SQL = "REATE OR REPLACE FUNCTION retorna_lista(ref refcursor) RETURNS refcursor AS $$\n"
                + "BEGIN\n"
                + "  IF NOT EXISTS (SELECT 1 FROM pg_class WHERE relname = 'lista') THEN\n"
                + "    -- criando a VIEW para a consulta\n"
                + "    CREATE VIEW lista(DescricaoFonte, DescricaoTipoLicitacao, valor) AS\n"
                + "      SELECT f.descricao as DescricaoFonte, tipoLici.descricao as DescricaoTipoLicitacao, SUM(desp.valor) as soma\n"
                + "        FROM despesa desp, fonte f, orgao org, tipolicitacao tipoLici\n"
                + "          WHERE desp.codigofonte = f.codigo AND desp.codigoorgao = org.codigo AND desp.codigotipolicitacao = tipoLici.codigo\n"
                + "            GROUP BY f.descricao, tipoLici.descricao ORDER BY soma DESC;\n"
                + "  END IF;\n"
                + "  -- abrindo o cursor para ler os dados da view\n"
                + "  OPEN ref FOR SELECT * FROM lista LIMIT 10 OFFSET" +  offset + ";\n"
                + "  RETURN ref;\n"
                + "END;\n"
                + "$$ LANGUAGE plpgsql;\n"
                + "\n"
                + "-- selecionando a SP para gerar o cursor\n"
                + "SELECT retorna_lista('cursor_lista');\n"
                + "-- exibindo os dados do cursor\n"
                + "FETCH ALL IN \"cursor_lista\";";

        statement = connection.prepareStatement(SQL);
        set = statement.executeQuery();

        while (set.next()) {
            Fonte font = new Fonte();
            fonte.add(font);
        }

        System.out.println(fonte);
        return fonte;
    }
}
