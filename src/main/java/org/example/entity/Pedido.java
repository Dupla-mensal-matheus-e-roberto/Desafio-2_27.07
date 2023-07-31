package org.example.entity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public static void escreverListaEmArquivo(List<Pedido> pedidos, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Pedido pedido : pedidos) {
                writer.write("Horário: " + pedido.getHorario());
                writer.newLine();
                writer.write("Cliente: " + pedido.getCliente());
                writer.newLine();
                writer.write("Quantidade de Pizzas: " + pedido.getQuantidade_pizzas());
                writer.newLine();
                writer.write("Sabores: " + pedido.getSabores());
                writer.newLine();
                writer.write("Previsão de Entrega: " + pedido.getPrevisao_entrega());
                writer.newLine();
                writer.write("Status: " + pedido.getStatus());
                writer.newLine();
                writer.newLine();
                System.out.println("Conteúdo da lista gravado com sucesso no arquivo.");
            }
        }catch(IOException e){
                System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            }
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

    public static void atualizarPedidos(int index, List<Pedido> ativo, List<Pedido> concluido){
        concluido.add(new Pedido(ativo.get(index).horario,
                                 ativo.get(index).cliente,
                                 ativo.get(index).quantidade_pizzas,
                                 ativo.get(index).sabores,
                                 ativo.get(index).previsao_entrega,
                                 ativo.get(index).status));

        ativo.remove(index);
        System.out.println("Pedido " + index + " concluido! :)");
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
