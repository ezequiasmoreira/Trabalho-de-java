package Controller;

import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoProduto extends Dao{
    public int addProduto(Produto produto) throws SQLException{
        return (super.executeUpdate("INSERT INTO produto(nome,peso,dataValidade,precoCusto,precoVenda,id_fornecedor,status) VALUES (?,?,?,?,?,?,?,?)", 
                produto.getNome(),
                produto.getDataValidade(),
                produto.getPrecoCusto(),
                produto.getPrecoVenda(), 
                produto.getFornecedor().getId(),
                produto.getStatus()));
    }
    public int updateProduto(Produto produto) throws SQLException{
        return (super.executeUpdate("UPDATE produto SET nome = ?,SET peso = ?,SET dataValidade = ?,SET precoCusto = ?,SET precoVenda = ?,SET id_fornecedor = ?,SET status = ? WHERE id=?", 
                produto.getNome(),
                produto.getDataValidade(),
                produto.getPrecoCusto(),
                produto.getPrecoVenda(), 
                produto.getFornecedor().getId(),
                produto.getStatus(),
                produto.getId()));
    }    
    public int deleteProduto(Produto produto) throws SQLException{
        return (super.executeUpdate("DELETE FROM produto WHERE id=?", 
                produto.getId()));
    }
    public Produto getProduto(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM produto WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Produto> getProdutoList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM produto ORDER BY nome");
        LinkedList<Produto> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Produto> getProdutoList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM produto WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Produto> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Produto populateObject(ResultSet rs) throws SQLException{
        //return (new Produto(rs.getInt("id"), rs.getString("nome")));
    }
    
    
    
}
