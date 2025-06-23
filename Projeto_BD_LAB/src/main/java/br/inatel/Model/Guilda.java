package br.inatel.Model;

public class Guilda {
    private int idGuilda;
    private String nome;
    private String pocoes;
    private String vestimentas;
    private String armas;

    public Guilda(int idGuilda, String nome, String pocoes, String vestimentas, String armas) {
        this.idGuilda = idGuilda;
        this.nome = nome;
        this.pocoes = pocoes;
        this.vestimentas = vestimentas;
        this.armas = armas;
    }

    // Getters e Setters
    public int getIdGuilda() {
        return idGuilda;
    }

    public void setIdGuilda(int idGuilda) {
        this.idGuilda = idGuilda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPocoes() {
        return pocoes;
    }

    public void setPocoes(String pocoes) {
        this.pocoes = pocoes;
    }

    public String getVestimentas() {
        return vestimentas;
    }

    public void setVestimentas(String vestimentas) {
        this.vestimentas = vestimentas;
    }

    public String getArmas() {
        return armas;
    }

    public void setArmas(String armas) {
        this.armas = armas;
    }
}