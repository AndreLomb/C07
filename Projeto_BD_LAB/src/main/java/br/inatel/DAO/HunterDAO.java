package br.inatel.DAO;

import br.inatel.Model.Cacador;

import java.sql.*;
import java.util.ArrayList;

public class HunterDAO {
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;

    private static final String DRIVER = "projeto_guilda";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DRIVER + "?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void connectToDB() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem sucedida!");
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        }
    }

    public boolean insertCacador(Cacador cacador) {
        connectToDB();
        String sql = "INSERT INTO Caçador (id_guerreiro, nome, `rank`, `materiais_coletados`, `Guilda_id_guilda`) VALUES (?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, cacador.getIdGuerreiro());
            pst.setString(2, cacador.getNome());
            pst.setString(3, cacador.getRank());
            pst.setString(4, cacador.getMateriaisColetados());
            pst.setInt(5, cacador.getGuildaId());
            pst.execute();
            return true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            return false;
        } finally {
            try {
                if (con != null) con.close();
                if (pst != null) pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }

    public boolean updateCacador(Cacador cacador) {
        connectToDB();
        String sql = "UPDATE Caçador SET nome=?, rank=?, materiais_coletados=?, Guilda_id_guilda=? WHERE id_guerreiro=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cacador.getNome());
            pst.setString(2, cacador.getRank());
            pst.setString(3, cacador.getMateriaisColetados());
            pst.setInt(4, cacador.getGuildaId());
            pst.setInt(5, cacador.getIdGuerreiro());
            pst.execute();
            return true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            return false;
        } finally {
            try {
                if (con != null) con.close();
                if (pst != null) pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }

    public boolean deleteCacador(int idGuerreiro) {
        connectToDB();
        String sql = "DELETE FROM Caçador WHERE id_guerreiro=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idGuerreiro);
            pst.execute();
            return true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            return false;
        } finally {
            try {
                if (con != null) con.close();
                if (pst != null) pst.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }

    public ArrayList<Cacador> selectCacadores() {
        ArrayList<Cacador> cacadores = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Caçador";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cacador cacador = new Cacador(
                        rs.getInt("id_guerreiro"),
                        rs.getString("nome"),
                        rs.getString("rank"),
                        rs.getString("materiais_coletados"),
                        rs.getInt("Guilda_id_guilda")
                );
                cacadores.add(cacador);
            }
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                if (con != null) con.close();
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return cacadores;
    }
}