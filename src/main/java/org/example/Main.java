package org.example;

import org.example.entity.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int escolha = 0;

        do{
            System.out.println("[+] Menu Principal [+] \n" +
                    "\nEscolha uma das opções abaixo:\n" +
                    "1 - Cadastrar novo cliente \n" +
                    "2 - Encontrar ou Alterar clientes registrados \n" +
                    "3 - Novo pedido \n" +
                    "4 - Atualizar pedido \n" +
                    "5 - Resumo de pedidos \n \n");

            escolha = entrada.nextInt();

            switch(escolha){
                case 1:
                    clientes.add(Cliente.cadastrarCliente());
                    break;
                case 2:
                    System.out.println("Insira o nome do cliente que deseja encontrar \n");
                    Cliente.encontrarCliente(entrada.next(),clientes);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }


        }while(1==1);



    }
}