package org.example.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Pedido {
    private LocalDateTime horario;
    private Cliente cliente;
    private int quantidade_pizzas;
    List<String> sabores;
    private LocalDateTime previsao_entrega;
    private String status;

    public Pedido(LocalDateTime horario, Cliente cliente, int quantidade_pizzas, List<String> sabores, LocalDateTime previsao_entrega, String status) {
        this.horario = horario;
        this.cliente = cliente;
        this.quantidade_pizzas = quantidade_pizzas;
        this.sabores = sabores;
        this.previsao_entrega = previsao_entrega;
        this.status = status;
    }

    public static void realizarPedido(List<Cliente> clientes, List<Pedido> pedidos) {
        Scanner entrada_dados = new Scanner(System.in);


        System.out.println(" -> Novo pedido : \n" +
                "Insira o nome do cliente: \n");

        String nome = entrada_dados.next();
        String status = "Em andamento";
        String sabor_aux = "";

        LocalDateTime horario = LocalDateTime.now();
        LocalDateTime previsao = LocalDateTime.now().plusMinutes(45);

        Cliente cliente_pedido = new Cliente();

        Endereco endereco;

        int quantidade;
        int numero_interacoes;

        List<String> sabores = new ArrayList<>();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().matches(nome)) {
                cliente_pedido = new Cliente(clientes.get(i).getNome(), clientes.get(i).getIdade(), clientes.get(i).getCelular(),clientes.get(i).getEndereco());
            }
        }

        System.out.println("Insira a quantidade de pizzas que o cliente deseja: \n");
        quantidade = entrada_dados.nextInt();

        System.out.println("Quantos sabores no total ? Máximo 03 por pizza");
        numero_interacoes = entrada_dados.nextInt();

        for(int i = 1; i <= numero_interacoes; i++){
            System.out.println(i + " - Insira o nome do sabor: \n");
            sabores.add(entrada_dados.next());
    }

        pedidos.add(new Pedido(horario, cliente_pedido, quantidade, sabores, previsao, status));
        System.out.println("Pedido efetuado com sucesso!");
    }



    public static void imprimirPedidos(List<Pedido> pedidos, String status){
        String sabores = "";
        System.out.println("Pedidos " + status + "\n");
        for(int i = 0; i < pedidos.size(); i++){
            for(int j = 0; j < pedidos.get(i).sabores.size();j++){
                sabores += pedidos.get(i).getSabores().get(j) + " - ";
            }

            System.out.println("Pedido ID: " + i + "\n" +
                    "Feito em: " + pedidos.get(i).horario + "\n" +
                    "Previsão: " + pedidos.get(i).previsao_entrega + "\n" +
                    "Cliente: " + pedidos.get(i).cliente.getNome() + "\n" +
                    "Quantidade: " + pedidos.get(i).quantidade_pizzas + "\n" +
                    "Sabores: " + sabores +
                    "Status: " + status + "" +
                    "\n -- -- -- \n");

            sabores = "";
        }

    }
    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuantidade_pizzas() {
        return quantidade_pizzas;
    }

    public void setQuantidade_pizzas(int quantidade_pizzas) {
        this.quantidade_pizzas = quantidade_pizzas;
    }

    public List<String> getSabores() {
        return sabores;
    }

    public void setSabores(List<String> sabores) {
        this.sabores = sabores;
    }

    public LocalDateTime getPrevisao_entrega() {
        return previsao_entrega;
    }

    public void setPrevisao_entrega(LocalDateTime previsao_entrega) {
        this.previsao_entrega = previsao_entrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
