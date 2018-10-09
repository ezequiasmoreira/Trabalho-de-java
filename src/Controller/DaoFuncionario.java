package Controller;

import Model.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoFuncionario extends Dao{
    public int addFuncionario(Funcionario funcionario) throws SQLException{
        return (super.executeUpdate("INSERT INTO funcionario(nome,cpf,bairro,endereco,dataNascimento,sexo,id_cidade,status) VALUES (?,?,?,?,?,?,?,?)", 
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getBairro(),
                funcionario.getEndereco(),
                funcionario.getDataNascimento(),                
                funcionario.getSexo().name(),
                funcionario.getCidade().getId(),
                funcionario.getStatus()));
    }
    public int updateFuncionario(Funcionario funcionario) throws SQLException{
        return (super.executeUpdate("UPDATE funcionario SET nome = ?,SET cpf = ?,SET bairro = ?,SET endereco = ?,SET dataNascimento = ?,SET sexo = ?,SET id_cidade = ?,SET status = ? WHERE id=?", 
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getBairro(),
                funcionario.getEndereco(),
                funcionario.getDataNascimento(),                
                funcionario.getSexo().name(),
                funcionario.getCidade().getId(),
                funcionario.getStatus(),
                funcionario.getId()));
    }    
    public int deleteFuncionario(Funcionario funcionario) throws SQLException{
        return (super.executeUpdate("DELETE FROM funcionario WHERE id=?", 
                funcionario.getId()));
    }
    public Funcionario getFuncionario(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM funcionario WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Funcionario> getFuncionarioList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM funcionario ORDER BY nome");
        LinkedList<Funcionario> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Funcionario> getFuncionarioList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM funcionario WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Funcionario> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Funcionario populateObject(ResultSet rs) throws SQLException{
        //return (new Funcionario(rs.getInt("id"), rs.getString("nome")));
    }
    
    
    
}
