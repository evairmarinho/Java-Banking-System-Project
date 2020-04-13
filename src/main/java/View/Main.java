/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Evair Marinho
 */
import Model.*;
import Model.Conta;
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class Main {

    public static GerenciaCliente ger = new GerenciaCliente();
    public static Banco banco = new Banco();
    public static int numero = 0;

    public static void menu(int opcao) {

        switch (opcao) {
            case 1:

                String nome = JOptionPane.showInputDialog(null, "Digite seu nome\n");
                if (nome.isEmpty() == false) {
                    String cpf = JOptionPane.showInputDialog(null, "Digite seu cpf\n");
                    if (cpf.isEmpty() == false) {
                        if (!ger.existeCpf(cpf)) {
                            String telefone = JOptionPane.showInputDialog(null, "Digite seu telefone\n");

                            if (telefone.isEmpty() == false) {
                                Cliente cliente = new Cliente(nome, cpf, telefone);
                                ger.adicionar(cliente);
                                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
                                cliente.imprimir();
                            } else {
                                JOptionPane.showMessageDialog(null, "Digite um número de telefone", "Atenção Meu Patrão", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "CPF já consta no registro", "Atenção", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Digite um cpf", "Atenção Meu Patrão", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Digite um nome", "Atenção Meu Patrão", JOptionPane.WARNING_MESSAGE);
                }
                break;

            case 2:
                String cpf;
                if (ger.getListaCliente().isEmpty() == false) {
                    cpf = JOptionPane.showInputDialog("Digite o seu CPF: ");
                    if (cpf.isEmpty() == false) {
                        if (ger.existeCpf(cpf) == true) {
                            if (banco.existeContaCpf(cpf) == false) {
                                ger.achaCpf(cpf);//retornando um cliente do cpf diitado
                                int escolha = JOptionPane.showConfirmDialog(null, "Deseja uma conta Comum?");
                                if (escolha == JOptionPane.YES_OPTION) {

                                    double saldo = 0;
                                    LocalDate data = LocalDate.now();
                                    Conta conta = new Conta(numero, saldo, data, ger.achaCpf(cpf));
                                    banco.adicionar(conta);
                                    numero++;
                                    JOptionPane.showMessageDialog(null, "" + conta.toString());

                                } else if (escolha == JOptionPane.NO_OPTION) {
                                    int escolha2 = JOptionPane.showConfirmDialog(null, "Deseja uma conta Especial?");
                                    if (escolha2 == JOptionPane.YES_OPTION) {

                                        double saldoE = 0;
                                        LocalDate dataE = LocalDate.now();
                                        ContaEspecial contaE = new ContaEspecial(numero, saldoE, dataE, ger.achaCpf(cpf));
                                        banco.adicionarEsp(contaE);
                                        numero++;
                                        JOptionPane.showMessageDialog(null, contaE.toString());
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "JÁ EXISTE UMA CONTA COM ESSE CPF CADASTRADO", "Atenção", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "CPF não foi encontrado no registro", "Atenção", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "DIGITE UM CPF", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CADASTRE UM CLIENTE PRIMEIRO", "Atenção", JOptionPane.WARNING_MESSAGE);
                }

                break;

            case 3:
                if (!banco.getListaContaEsp().isEmpty() || !banco.getListaConta().isEmpty()) {
                    JOptionPane.showMessageDialog(null, banco.listar());
                } else {
                    JOptionPane.showMessageDialog(null, "CADASTRE UMA CONTA PRIMEIRO", "Atenção", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case 4:
                if (!banco.getListaConta().isEmpty() || !banco.getListaContaEsp().isEmpty()) {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da Conta:"));
                    banco.getConta(numero);
                    if (banco.pesquisar(numero) != null) {
                        JOptionPane.showMessageDialog(null, banco.pesquisar(numero));
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CADASTRE UMA CONTA PRIMEIRO", "Atenção", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case 5:
                if (!banco.getListaConta().isEmpty() || !banco.getListaContaEsp().isEmpty()) {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da Conta:"));
                    Conta Nconta;
                    Double quantia;
                    Nconta = banco.existeConta(numero);
                    if (Nconta != null) {
                        quantia = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor de depósito"));

                        Nconta.depositar(quantia);
                        JOptionPane.showMessageDialog(null, "Saldo Atual da Conta " + Nconta.getNumero() + ": \n" + "R$" + Nconta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada", "Atenção", JOptionPane.WARNING_MESSAGE);

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "CADASTRE UMA CONTA PRIMEIRO", "Atenção", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case 6:
                if (!banco.getListaConta().isEmpty() || !banco.getListaContaEsp().isEmpty()) {
                    Conta Nconta;
                    Double quantia;
                    int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da Conta:"));
                    Nconta = banco.existeConta(numero);
                    if (Nconta != null) {
                        quantia = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do débito"));
                        Nconta.debitar(quantia);
                        JOptionPane.showMessageDialog(null, "Saldo Atual da Conta: " + "R$" + Nconta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada", "Atenção", JOptionPane.WARNING_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CADASTRE UMA CONTA PRIMEIRO", "Atenção", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case 7:
                if (!banco.getListaConta().isEmpty() || !banco.getListaContaEsp().isEmpty()) {
                    Conta destino;
                    int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da Conta a ser Debitada:"));
                    Conta Nconta = banco.existeConta(numero);
                    if (Nconta != null) {
                        numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da Conta a ser Creditada:"));
                        destino = banco.existeConta(numero);
                        if (destino != null) {
                            double quantia = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da Transferência"));
                            Nconta.transferir(destino, quantia);
                        } else {
                            JOptionPane.showMessageDialog(null, "Conta não encontrada", "Atenção", JOptionPane.WARNING_MESSAGE);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada", "Atenção", JOptionPane.WARNING_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CADASTRE UMA CONTA PRIMEIRO", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 8:
                if (!banco.getListaConta().isEmpty() || !banco.getListaContaEsp().isEmpty()) {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da Conta:"));
                    Conta Nconta = banco.existeConta(numero);
                    if (Nconta != null) {
                        banco.remover(numero);
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada", "Atenção", JOptionPane.WARNING_MESSAGE);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CADASTRE UMA CONTA PRIMEIRO", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 9:
                JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida - Números de 1 a 9", "Atenção", JOptionPane.WARNING_MESSAGE);

        }

    }

    public static void main(String[] args) {
        int opcao = 0;

        do {
            try {

                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "----------Menu do Banco----------\n"
                        + "1 - Cadastrar Cliente\n" + "2 - Cadastrar Conta\n" + "3 - Listar Conta\n"
                        + "4 - Pesquisar Conta\n" + "5 - Depositar\n" + "6 - Debitar (Sacar)\n" + "7 - Transferir\n" + "8 - Remover Conta\n" + "9 - Sair\n"
                        + "Escolha uma opção:\n"));

                menu(opcao);
            } catch (NumberFormatException exception) {

                JOptionPane.showMessageDialog(null, "APENAS NÚMEROS", "Atenção Usuário Ousado", JOptionPane.WARNING_MESSAGE);

            }

        } while (opcao != 9);
    }

}
