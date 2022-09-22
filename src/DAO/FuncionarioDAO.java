package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

    public void cadastrarFuncionario(FuncionarioDTO objfuncionariodto) { // CREATE
        String sql = "insert into funcionario (nome_funcionario, endereco_funcionario, salario_funcionario, funcao_funcionario) values (?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_funcionario());
            pstm.setString(2, objfuncionariodto.getEndereco_funcionario());
            pstm.setString(3, objfuncionariodto.getSalario_funcionario());
            pstm.setString(4, objfuncionariodto.getFuncao_funcionario());
            

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "FuncionarioDAO Cadastrar: " + erro);
        }

    }

    public ArrayList<FuncionarioDTO> PesquisarFuncionario() { // READ
        
        String sql = "select * from funcionario";
        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objfuncionarioDTO = new FuncionarioDTO();
                objfuncionarioDTO.setId_funcionario(rs.getInt("id_funcionario")); // Acessando o OBJETO e setando nesse obj um valor do bd
                objfuncionarioDTO.setNome_funcionario(rs.getString("nome_funcionario"));
                objfuncionarioDTO.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                objfuncionarioDTO.setSalario_funcionario(rs.getString("salario_funcionario"));
                objfuncionarioDTO.setFuncao_funcionario(rs.getString("funcao_funcionario"));

                lista.add(objfuncionarioDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Pesquisar: " + erro);
        }
        return lista;
    }
    
    public void AlterarFuncionario(FuncionarioDTO objfuncionariodto) {
        String sql = "update funcionario set nome_funcionario = ?, endereco_funcionario = ?, salario_funcionario = ?, funcao_funcionario = ? where id_funcionario = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
            try {
                
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, objfuncionariodto.getNome_funcionario());
                pstm.setString(2, objfuncionariodto.getEndereco_funcionario());
                pstm.setString(3, objfuncionariodto.getSalario_funcionario());
                pstm.setString(4, objfuncionariodto.getFuncao_funcionario());
                pstm.setInt(5, objfuncionariodto.getId_funcionario());
                
                pstm.execute();
                pstm.close();
                
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Alterar " + erro);
        }
        
        
    
    }
    
    public void ExcluirFuncionario(FuncionarioDTO objfuncionariodto) {
        String sql = "delete from funcionario where id_funcionario = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objfuncionariodto.getId_funcionario());
            
            pstm.execute();
            pstm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Excluir " + erro);
        }
    
    
    }
    
}
