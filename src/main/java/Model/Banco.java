package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Banco {

    private ArrayList<Conta> listaConta = new ArrayList<>();
    private ArrayList<ContaEspecial> listaContaEsp = new ArrayList<>();

    public Banco() {

    }

    public ArrayList<Conta> getListaConta() {
        return listaConta;
    }

    public ArrayList<ContaEspecial> getListaContaEsp() {
        return listaContaEsp;
    }

    public void adicionar(Conta conta) {
        listaConta.add(conta);
        JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso");
    }

    public void adicionarEsp(ContaEspecial contaEsp) {
        listaContaEsp.add(contaEsp);
        JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso");
    }

    public String listar() {
        String lista1 = "";
        String lista2 = "";

        if (!listaContaEsp.isEmpty()) {
            lista1 += "CONTAS ESPECIAIS\n";
            for (ContaEspecial c : listaContaEsp) {
                if (c != null) {
                    lista1 += c.toString();
                }
            }
        } else {
            lista1 += "SEM CONTAS ESPECIAIS CADASTRADAS\n";

        }
        if (!listaConta.isEmpty()) {
            lista2 += "\nCONTAS COMUNS\n";

            for (Conta c1 : listaConta) {
                //System.out.println(c);
                if (c1 != null) {
                    lista2 += c1.toString();

                }

            }
        } else {
            lista2 += "SEM CONTAS COMUNS CADASTRADAS\n";
        }
        return "LISTA DE CONTAS\n" + lista1 + lista2;

    }

    public String pesquisar(int numero) {

        for (Conta c : listaConta) {
            if (c.getNumero() == numero) {

                return "\nCPF: " + c.getCliente().getCpf() + "\nTelefone: " + c.getCliente().getTelefone() + "\n" + c.toString();
            }
        }

        for (ContaEspecial c1 : listaContaEsp) {
            if (c1.getNumero() == numero) {

                return "\nCPF: " + c1.getCliente().getCpf() + "\nTelefone: " + c1.getCliente().getTelefone() + "\n" + c1.toString();
            }
        }
        return null;
    }

    public Conta getConta(int numero) {
        for (Conta c : listaConta) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        for (Conta c1 : listaContaEsp) {
            if (c1.getNumero() == numero) {
                return c1;
            }
        }
        return null;
    }

    public Conta existeConta(int num) {

        for (Conta c : listaConta) {

            if (c.getNumero() == num) {
                return c;

            }
        }
        for (Conta c1 : listaContaEsp) {

            if (c1.getNumero() == num) {
                return c1;

            }
        }

        return null;
    }


    public boolean remover(int numero) {
        for (Conta c : listaConta) {
            if (c.getNumero() == numero) {
                if (c.saldo == 0) {
                    listaConta.remove(c);
                    JOptionPane.showMessageDialog(null, "CONTA " + c.getNumero() + " REMOVIDA");
                    return true;
                } else {

                    JOptionPane.showMessageDialog(null, "PARA A CONTA SER REMOVIDA, O SALDO PRECISA SER IGUAL R$ 0\n");
                    return false;
                }
            }

        }
        for (ContaEspecial c1 : listaContaEsp) {
            if (c1.getNumero() == numero) {
                if (c1.saldo == 0) {
                    listaContaEsp.remove(c1);
                    JOptionPane.showMessageDialog(null, "CONTA " + c1.getNumero() + " REMOVIDA");
                    return true;
                } else {

                    JOptionPane.showMessageDialog(null, "PARA A CONTA SER REMOVIDA, O SALDO PRECISA SER IGUAL R$ 0\n");
                    return false;
                }

            }
        }

        return false;
    }

    public boolean existeContaCpf(String cpf) {

        for (Conta c : listaConta) {
            if (c.getCliente().getCpf().contains(cpf)) {

                return true;
            }

        }
        for (ContaEspecial c1 : listaContaEsp) {
            if (c1.getCliente().getCpf().contains(cpf)) {

                return true;
            }

        }

        return false;

    }
}
