package br.inatel.DAO;

import br.inatel.Model.Arma;

import java.sql.*;
import java.util.ArrayList;

public class WeaponDAO {
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

    public boolean insertArma(Arma arma) {
        connectToDB();
        String sql = "INSERT INTO Armas (id_arma, nome, tipo, materiais, `rank`, `estado de afiação`) VALUES (?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, arma.getIdArma());
            pst.setString(2, arma.getNome());
            pst.setString(3, arma.getTipo());
            pst.setString(4, arma.getMateriais());
            pst.setString(5, arma.getRank());
            pst.setInt(6, arma.getEstadoAfiacao());
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

    public boolean updateArma(Arma arma) {
        connectToDB();
        String sql = "UPDATE Armas SET nome=?, tipo=?, materiais=?, rank=?, `estado de afiação`=? WHERE id_arma=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, arma.getNome());
            pst.setString(2, arma.getTipo());
            pst.setString(3, arma.getMateriais());
            pst.setString(4, arma.getRank());
            pst.setInt(5, arma.getEstadoAfiacao());
            pst.setInt(6, arma.getIdArma());
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

    public boolean deleteArma(int idArma) {
        connectToDB();
        String sql = "DELETE FROM Armas WHERE id_arma=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idArma);
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

    public ArrayList<Arma> selectArmas() {
        ArrayList<Arma> armas = new ArrayList<>();
        connectToDB();
        String sql = "SELECT * FROM Armas";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Arma arma = new Arma(
                        rs.getInt("id_arma"),
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getString("materiais"),
                        rs.getString("rank"),
                        rs.getInt("estado de afiação")
                );
                armas.add(arma);
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
        return armas;
    }
}