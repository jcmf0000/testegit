/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author clebe
 */
public class UsuarioDAO {

    Connection conexao = null;
    PreparedStatement ps;
    ResultSet rs;
    
    String consultarUsuario = "select * from tbusuarios where iduser=?";
    
    public Usuario consultarUsuario(int id) {
        try {
            conexao = ModuloConexao.conectar();
            ps = conexao.prepareStatement(consultarUsuario);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            Usuario usuario = new Usuario();
            if (rs.next()) {
                usuario.setId(rs.getInt("iduser"));
                usuario.setNome(rs.getString("usuario"));
                usuario.setFone(rs.getString(3));
                usuario.setLogin(rs.getString(4));
                usuario.setSenha(rs.getString(5));
                usuario.setPerfil(rs.getString(6));
            }
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Usuário não encontrado");
            return null;
        }
        return null;
    }
}
