package br.edu.ifpb.cartaxo.todo_list.model;

public class Usuario {

    private Long id;
    private String nome;
    private String password;

    public Usuario() {
    }

    public Usuario(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}