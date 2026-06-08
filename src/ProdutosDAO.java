/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, 'A Venda')";
                    try {
                        PreparedStatement stmt = this.conn.prepareStatement(sql);
                        stmt.setString(1, produto.getNome());
                        stmt.setInt(2, produto.getValor());
                        stmt.execute();
            
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao inserir empresa: " + e.getMessage());
                    }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
    
    ArrayList<ProdutosDTO> vendidos = new ArrayList<>();

    for (ProdutosDTO produto : listagem) {
        if ("Vendido".equals(produto.getStatus())) {
            vendidos.add(produto);
        }
    }

    return vendidos;
}
    public void venderProduto(int id){
        conn = new conectaDAO().connectDB();
        
        String sql = "INSERT INTO produtos (status) VALUES ('Vendido') where id = ?";
                    try {
                        PreparedStatement stmt = this.conn.prepareStatement(sql);
                        stmt.setInt(1, id);
                        stmt.execute();
            
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao inserir empresa: " + e.getMessage());
                    }
    }
    
        
            
}

