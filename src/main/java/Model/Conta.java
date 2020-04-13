package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Conta {

    private int numero;
    private Cliente cliente;
    protected double saldo = 0;
    private LocalDate dataAbertura;
    DateTimeFormatter dataOrdem = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Conta(int numeroC, double saldo, LocalDate dataAbertura, Cliente cliente) { //construtor de connta
        this.saldo = saldo;
        this.numero = numeroC;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
    }

    public Conta() {
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String ordemData() {
        return dataAbertura.format(dataOrdem);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {

        this.cliente = cliente;

    }

    public void depositar(double quantia) {
        if (quantia > 0) {
            this.saldo += quantia;
            String aviso = "Depósito Realizado";
            JOptionPane.showMessageDialog(null, "Depósito Realizado");
        } else {
            JOptionPane.showMessageDialog(null, "Quantia menor que 0", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    public boolean debitar(double quantia) {
        if (quantia > 0) {
            if (this.saldo >= quantia) {
                this.saldo -= quantia;
                JOptionPane.showMessageDialog(null, "Débito realizado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantia menor que 0", "Atenção", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    public boolean transferir(Conta destino, double quantia) {
        if (this.saldo >= quantia) {
            this.saldo -= quantia;
            destino.saldo += quantia;
            JOptionPane.showMessageDialog(null, "Transferência concluída");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente", "Atenção", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    public void imprimir() {
        toString();
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + "\nConta: " + numero + "\nTipo de Conta: Comum" + "\nSaldo: R$ " + saldo + "\nData de abertura: " + ordemData() + "\n----------------------------------------------\n";
    }

}
