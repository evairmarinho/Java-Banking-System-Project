/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Evair Marinho
 */
public class ContaEspecial extends Conta {

    DateTimeFormatter dataOrdem1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private double limite = 1000;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaEspecial(int numeroC, double saldo, LocalDate dataAbertura, Cliente cliente) {
        super(numeroC, saldo, dataAbertura, cliente);
    }

    public double getSaldoContaEsp() {
        return saldo;
    }

    public void setSaldoContaEsp(double saldo) {
        //this.saldo = saldo;
        super.saldo = saldo;
    }

    @Override
    public boolean debitar(double quantia) {

        if (quantia > 0) {

            double a = this.saldo + limite;
            if (a > 0) {
                double b = a -= quantia;
                if (b >=0) {
                    this.saldo -= quantia;
                    return true;

                } else {
                    JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE", "Atenção", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(null, "LIMITE ESTOURADO", "Atenção", JOptionPane.WARNING_MESSAGE);
                return false;

            }
        } else {
            JOptionPane.showMessageDialog(null, "NãO É POSSIVEL SACAR UMA QUANTIA NEGATIVA");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + super.getCliente().getNome() + "\nConta: " + super.getNumero() + "\nTipo: Especial" + "\nSaldo: R$ " + super.saldo + "\nData de abertura: " + ordemData() + "\nLimite: R$ 1000" + "\n----------------------------------------------\n";
    }

}
