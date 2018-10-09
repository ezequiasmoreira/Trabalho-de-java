package Controller;

import Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoCliente extends Dao{
    public int addCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("INSERT INTO cliente(nome,cpf,bairro,endereco,dataNascimento,sexo,id_cidade,status) VALUES (?,?,?,?,?,?,?,?)", 
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getBairro(),
                cliente.getEndereco(),
                cliente.getDataNascimento(),                
                cliente.getSexo().name(),
                cliente.getCidade().getId(),
                cliente.getStatus()));
    }
    public int updateCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("UPDATE cliente SET nome = ?,SET cpf = ?,SET bairro = ?,SET endereco = ?,SET dataNascimento = ?,SET sexo = ?,SET id_cidade = ?,SET status = ? WHERE id=?", 
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getBairro(),
                cliente.getEndereco(),
                cliente.getDataNascimento(),                
                cliente.getSexo().name(),
                cliente.getCidade().getId(),
                cliente.getStatus(),
                cliente.getId()));
    }    
    public int deleteCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("DELETE FROM cliente WHERE id=?", 
                cliente.getId()));
    }
    public Cliente getCliente(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cliente WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Cliente> getClienteList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cliente ORDER BY nome");
        LinkedList<Cliente> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Cliente> getClienteList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cliente WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Cliente> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Cliente populateObject(ResultSet rs) throws SQLException{
        //return (new Cliente(rs.getInt("id"), rs.getString("nome")));
    }
    
    
    
}
