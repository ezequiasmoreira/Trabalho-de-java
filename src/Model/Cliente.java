
package Model;

import Tipos.TipoSexo;

public class Cliente extends Padrao{    
    private String cpf;
    private String bairro;
    private String endereco;
    private String dataNascimento;
    private TipoSexo sexo;
    private Cidade cidade;
    private char status;
    
    public Cliente(){
        super();
        this.setSexo(TipoSexo.M);
    }
    public Cliente(int id, String nome,String cpf,String bairro,String endereco, TipoSexo sexo,Cidade id_cidade,char status){
        super(id, nome);
        this.setCpf(cpf);
        this.setBairro(bairro);
        this.setEndereco(endereco);
        this.setDataNascimento(dataNascimento);
        this.setSexo(sexo);
        this.setCidade(cidade);
        this.setStatus(status);
        
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }
    
}
