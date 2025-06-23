package br.inatel.Model;

public class Cacador {
    private int idGuerreiro;
    private String nome;
    private String rank;
    private String materiaisColetados;
    private int guildaId;

    public Cacador(int idGuerreiro, String nome, String rank, String materiaisColetados, int guildaId) {
        this.idGuerreiro = idGuerreiro;
        this.nome = nome;
        this.rank = rank;
        this.materiaisColetados = materiaisColetados;
        this.guildaId = guildaId;
    }

    // Getters e Setters
    public int getIdGuerreiro() {
        return idGuerreiro;
    }

    public void setIdGuerreiro(int idGuerreiro) {
        this.idGuerreiro = idGuerreiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMateriaisColetados() {
        return materiaisColetados;
    }

    public void setMateriaisColetados(String materiaisColetados) {
        this.materiaisColetados = materiaisColetados;
    }

    public int getGuildaId() {
        return guildaId;
    }

    public void setGuildaId(int guildaId) {
        this.guildaId = guildaId;
    }
}