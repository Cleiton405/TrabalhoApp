package com.cleiton.apptrab;

public class Pets {

    public int id;

    public String nome;

    public String nomepet;

    public String idadepet;

    public String spAnimal;

    public Pets() {

    }

    public Pets(String nome, String nomepet, String idadepet, String spAnimal) {
        this.nome = nome;
        this.nomepet = nomepet;
        this.idadepet = idadepet;
        this.spAnimal = spAnimal;
    }

    @Override
    public String toString() {
        return nome + " - " + nomepet+ " - "+ idadepet + " - " + spAnimal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomepet() {
        return nomepet;
    }

    public void setNomepet(String nomepet) {
        this.nomepet = nomepet;
    }

    public String getIdadepet() {
        return idadepet;
    }

    public void setIdadepet(String idadepet) {
        this.idadepet = idadepet;
    }

    public String getSpAnimal() {
        return spAnimal;
    }

    public void setSpAnimal(String spAnimal) {
        this.spAnimal = spAnimal;
    }
}

