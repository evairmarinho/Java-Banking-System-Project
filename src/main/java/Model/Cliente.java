package Model;

import javax.swing.JOptionPane;

public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;

    public void imprimir() {
        String mostra = "\nNome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone;
        JOptionPane.showMessageDialog(null, mostra);
    }

    public Cliente() {

    }

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;

    }

    @Override
    public String toString() {
        return "\nCPF: " + cpf + "\nTelefone: " + telefone;

    }

}
