
package Model;

import Tipos.TipoSexo;
import java.sql.Date;

public class Produto extends Padrao{    
    private Date dataValidade;
    private double precoCusto;
    private double precoVenda;
    private String dataNascimento;
    private Fornecedor fornecedor;
    private char status;
    
    public Produto(){
        super();
    }
    public Produto(int id, String nome,Date dataValidade,double precoCusto,double precoVenda,Fornecedor id_fornecedor,char status){
        super(id, nome);
        this.setDataValidade(dataValidade);
        this.setPrecoCusto(precoCusto);
        this.setPrecoVenda(precoVenda);
        this.setDataNascimento(dataNascimento);
        this.setFornecedor(fornecedor);
        this.setStatus(status);
        
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }      
}
