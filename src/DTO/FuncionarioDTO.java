
package DTO;


public class FuncionarioDTO {
    
    private String nome_funcionario, endereco_funcionario, salario_funcionario, funcao_funcionario;
    private int id_funcionario;
   

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getEndereco_funcionario() {
        return endereco_funcionario;
    }

    public void setEndereco_funcionario(String endereco_funcionario) {
        this.endereco_funcionario = endereco_funcionario;
    }

    public String getSalario_funcionario() {
        return salario_funcionario;
    }

    public void setSalario_funcionario(String salario_funcionario) {
        this.salario_funcionario = salario_funcionario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getFuncao_funcionario() {
        return funcao_funcionario;
    }

    public void setFuncao_funcionario(String funcao_funcionario) {
        this.funcao_funcionario = funcao_funcionario;
    }
    
}
