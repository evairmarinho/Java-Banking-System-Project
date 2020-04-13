/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Evair Marinho
 */
public class GerenciaCliente {

    int i = 0;
    private ArrayList<Cliente> listaCliente = new ArrayList<>();

    public GerenciaCliente() {

    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public void adicionar(Cliente cliente) {
        listaCliente.add(cliente);
    }

    public String listar() {
        String lista = "";
        for (Cliente c : listaCliente) {
            
            lista += c.toString();
        }
        return lista;

    }

    public Cliente achaCpf(String a) {
        for (Cliente c1 : listaCliente) {

            if (c1.getCpf().contains(a)) {

                return c1;
            }

        }
        return null;
    }

    public boolean existeCpf(String cpf) {
        for (Cliente umcliente : listaCliente) {
            if (umcliente.getCpf().contains(cpf)) {
                return true;
            }
        }
        return false;
    }

}
