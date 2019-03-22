/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacadastrov2.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import programacadastrov2.bean.conection.Conexao;

/**
 *
 * @author Pii
 */
public class PessoasMetodos {

    public void inserir(Pessoas pessoa) {

        try {
            Connection connection = Conexao.getInstance().getConnection();

            String sql = "INSERT INTO usuarios (nome, telefone, celular, estadoCivil) VALUES (?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getTelefone());
            statement.setString(3, pessoa.getCelular());
            statement.setString(4, pessoa.getEstadoCivil());

            statement.execute();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void remover(int id) {
        try {

            Connection connection = Conexao.getInstance().getConnection();

            String sql = "DELETE FROM usuarios WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pessoas> listarTodos() {

        List<Pessoas> listaPessoas = new ArrayList<Pessoas>();

        try {

            Connection connection = Conexao.getInstance().getConnection();

            String sql = "SELECT * FROM usuarios";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Pessoas dto = new Pessoas();
                dto.setId(resultset.getInt("id"));
                dto.setNome(resultset.getString("nome"));
                dto.setTelefone(resultset.getString("telefone"));
                dto.setCelular(resultset.getString("celular"));
                dto.setEstadoCivil(resultset.getString("estadoCivil"));

                listaPessoas.add(dto);

            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPessoas;
    }

    public void atualizar(Pessoas pessoa) {
        try {

            Connection connection = Conexao.getInstance().getConnection();

            String sql = "UPDATE usuarios SET nome = ?, telefone = ?, celular = ?, estadoCivil = ? WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getTelefone());
            statement.setString(3, pessoa.getCelular());
            statement.setString(4, pessoa.getEstadoCivil());
            statement.setInt(5, pessoa.getId());

            statement.execute();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pessoas> pesquisar(String nome) {

        List<Pessoas> listaPessoas = new ArrayList<Pessoas>();

        try {

            Connection connection = Conexao.getInstance().getConnection();

            String sql = "SELECT * FROM usuarios WHERE nome LIKE ?";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + nome + "%");

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Pessoas dto = new Pessoas();
                dto.setId(resultset.getInt("id"));
                dto.setNome(resultset.getString("nome"));
                dto.setTelefone(resultset.getString("telefone"));
                dto.setCelular(resultset.getString("celular"));
                dto.setEstadoCivil(resultset.getString("estadoCivil"));

                listaPessoas.add(dto);

            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPessoas;
    }
    
    public void removerTudo() {
        try {

            Connection connection = Conexao.getInstance().getConnection();

            String sql = "TRUNCATE TABLE usuarios";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
