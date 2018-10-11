package Controller;

import Model.Cidade;
import Tipos.TipoSigla;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoCidade extends Dao{
    public int addCidade(Cidade cidade) throws SQLException{
        return (super.executeUpdate("INSERT INTO CIDADE(nome, sigla) VALUES (?,?)", 
                cidade.getNome(),
                cidade.getSigla().name()));
    }
    public int updateCidade(Cidade cidade) throws SQLException{
        return (super.executeUpdate("UPDATE cidade SET nome=? WHERE id=?", 
                cidade.getNome(),
                cidade.getId()));
    }    
    public int deleteCidade(Cidade cidade) throws SQLException{
        return (super.executeUpdate("DELETE FROM cidade WHERE id=?", 
                cidade.getId()));
    }
    public Cidade getCidade(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidade WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Cidade> getCidadeList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidade ORDER BY nome");
        LinkedList<Cidade> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Cidade> getCidadeList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidade WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Cidade> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Cidade populateObject(ResultSet rs) throws SQLException{
        return (new Cidade(rs.getInt("id"), rs.getString("nome"),TipoSigla.valueOf("sigla")));
    }
    
    
    
}
