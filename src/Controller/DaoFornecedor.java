package Controller;

import Model.Fornecedor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoFornecedor extends Dao{
    public int addFornecedor(Fornecedor fornecedor) throws SQLException{
        return (super.executeUpdate("INSERT INTO fornecedor(nome,cnpj,bairro,endereco,id_cidade,status) VALUES (?,?,?,?,?,?)", 
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getBairro(),
                fornecedor.getEndereco(),                
                fornecedor.getCidade().getId(),
                fornecedor.getStatus()));
    }
    public int updateFornecedor(Fornecedor fornecedor) throws SQLException{
        return (super.executeUpdate("UPDATE fornecedor SET nome = ?,SET cnpj = ?,SET bairro = ?,SET endereco = ?,SET id_cidade = ?,SET status = ? WHERE id=?", 
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getBairro(),
                fornecedor.getEndereco(),                
                fornecedor.getCidade().getId(),
                fornecedor.getStatus(),
                fornecedor.getId()));
    }    
    public int deleteFornecedor(Fornecedor fornecedor) throws SQLException{
        return (super.executeUpdate("DELETE FROM fornecedor WHERE id=?", 
                fornecedor.getId()));
    }
    public Fornecedor getFornecedor(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM fornecedor WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Fornecedor> getFornecedorList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM fornecedor ORDER BY nome");
        LinkedList<Fornecedor> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Fornecedor> getFornecedorList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM fornecedor WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Fornecedor> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Fornecedor populateObject(ResultSet rs) throws SQLException{
        //return (new Fornecedor(rs.getInt("id"), rs.getString("nome")));
    }
    
    
    
}
