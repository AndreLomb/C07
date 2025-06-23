package br.inatel.Model;

public class Arma {
    private int idArma;
    private String nome;
    private String tipo;
    private String materiais;
    private String rank;
    private int estadoAfiacao;

    public Arma(int idArma, String nome, String tipo, String materiais, String rank, int estadoAfiacao) {
        this.idArma = idArma;
        this.nome = nome;
        this.tipo = tipo;
        this.materiais = materiais;
        this.rank = rank;
        this.estadoAfiacao = estadoAfiacao;
    }

    // Getters e Setters
    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMateriais() {
        return materiais;
    }

    public void setMateriais(String materiais) {
        this.materiais = materiais;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getEstadoAfiacao() {
        return estadoAfiacao;
    }

    public void setEstadoAfiacao(int estadoAfiacao) {
        this.estadoAfiacao = estadoAfiacao;
    }
}