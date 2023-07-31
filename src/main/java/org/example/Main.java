package org.example;

import org.example.entity.Cliente;
import org.example.entity.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        List<Pedido> pedidos_ativos = new ArrayList<>();
        List<Pedido> pedidos_concluido = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int escolha = 0;

        do{
            System.out.println("[+] Menu Principal [+] \n" +
                    "\nEscolha uma das opções abaixo:\n" +
                    "1 - Cadastrar novo cliente \n" +
                    "2 - Encontrar ou Alterar clientes registrados \n" +
                    "3 - Novo pedido \n" +
                    "4 - Atualizar pedido \n" +
                    "5 - Resumo de pedidos \n" +
                    "6 - Emitir TXT de entrega \n\n");

            escolha = entrada.nextInt();

            switch(escolha){
                case 1:
                    clientes.add(Cliente.cadastrarCliente());
                    break;
                case 2:
                    System.out.println("Insira o nome do cliente que deseja encontrar \n");
                    Cliente.encontrarCliente(entrada.next(),clientes);
                    break;
                case 3:
                    Pedido.realizarPedido(clientes,pedidos_ativos);
                    break;
                case 4:
                    System.out.println("Insira o numero do pedido\n");
                    Pedido.atualizarPedidos(entrada.nextInt(), pedidos_ativos, pedidos_concluido);
                    break;
                case 5:
                    Pedido.imprimirPedidos(pedidos_ativos, "Em andamento");
                    System.out.println(" [+] --- --- --- [+]");
                    Pedido.imprimirPedidos(pedidos_concluido, "Concluidos");
                    break;
                case 6:
                    Pedido.escreverListaEmArquivo(pedidos_ativos,"pedido_ativo.txt");
                    Pedido.escreverListaEmArquivo(pedidos_concluido,"pedido_concluido.txt");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }


        }while(1==1);



    }
}