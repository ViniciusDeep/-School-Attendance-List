package br.com.viniciusdeep.agenda.modelo;



public class Aluno {


    private String nome;
    private String endereco;
    private String telefone;
    private String site;
    private Double nota;
    private Long id;


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getNota() {
        return nota;
    }

    public Long getId() {
        return id;
    }


    public String getEndereco() {
        return endereco;
    }


    public String getNome() {
        return nome;
    }


    public String getSite() {
        return site;
    }


    public String getTelefone() {
        return telefone;
    }




}
