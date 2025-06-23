package br.inatel.DAO;

import br.inatel.Model.Guilda;

import java.sql.*;
import java.util.ArrayList;

public class GuildaDAO {
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

    public boolean insertGuilda(Guilda guilda) {
        connectToDB();
        String sql = "INSERT INTO Guilda (id_guilda, nome, poções, vestimentas, armas) VALUES (?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, guilda.getIdGuilda());
            pst.setString(2, guilda.getNome());
            pst.setString(3, guilda.getPocoes());
            pst.setString(4, guilda.getVestimentas());
            pst.setString(5, guilda.getArmas());
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

    public boolean updateGuilda(Guilda guilda) {
        connectToDB();
        String sql = "UPDATE Guilda SET nome=?, poções=?, vestimentas=?, armas=? WHERE id_guilda=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, guilda.getNome());
            pst.setString(2, guilda.getPocoes());
            pst.setString(3, guilda.getVestimentas());
            pst.setString(4, guilda.getArmas());
            pst.setInt(5, guilda.getIdGuilda());
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

    public boolean deleteGuilda(int idGuilda) {
        connectToDB();
        String sql = "DELETE FROM Guilda WHERE id_guilda=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idGuilda);
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

    public ArrayList<Guilda> selectGuildas() {
        ArrayList<Guilda> guildas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Guilda";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Guilda guilda = new Guilda(
                        rs.getInt("id_guilda"),
                        rs.getString("nome"),
                        rs.getString("poções"),
                        rs.getString("vestimentas"),
                        rs.getString("armas")
                );
                guildas.add(guilda);
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
        return guildas;
    }
}