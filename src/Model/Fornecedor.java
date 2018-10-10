
package Model;

import Tipos.TipoPessoa;
import Tipos.TipoSexo;



public class Fornecedor extends Padrao{    
    private String cnpj;   
    private String bairro;   
    private String endereco;   
    private Cidade cidade;
    private char status;
    private TipoPessoa pessoa;
    
    public Fornecedor(){
        super();
    }
    public Fornecedor(int id, String nome,String cnpj,String bairro,String endereco,Cidade id_cidade,char status,TipoPessoa pessoa){
        super(id, nome);
        this.setCnpj(cnpj);        
        this.setBairro(bairro);        
        this.setEndereco(endereco);        
        this.setCidade(cidade);
        this.setStatus(status);        
        this.setPessoa(pessoa);        
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    } 
    public TipoPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(TipoPessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
