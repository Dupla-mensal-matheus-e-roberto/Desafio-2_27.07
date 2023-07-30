package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private int ID;
    private String nome;
    private int idade;
    private String celular;
    private List<Endereco> endereco;

    public Cliente(){}
    public Cliente(String nome, int idade, String celular, List<Endereco> endereco){
        this.nome = nome;
        this.idade = idade;
        this.celular = celular;
        this.endereco = endereco;
    }

    public static Cliente cadastrarCliente(){
        Scanner scanner = new Scanner(System.in);
        int ID;

        String nome;
        int idade;
        String celular;
        String rua;
        int numero_rua;
        int qtde_enderecos;

        List<Endereco> enderecos = new ArrayList<>();

        System.out.println("-> Cadastro de cliente: \n \n" +
                "- Insira o nome do cliente: \n");
        nome = scanner.next();

        System.out.println(" - Insira a idade do cliente: \n");
        idade = scanner.nextInt();

        System.out.println(" - Insira o número do celular do cliente: \n");
        celular = scanner.next();

        System.out.println(" - Insira quantos endereços você deseja cadastrar para este cliente: \n");
        qtde_enderecos = scanner.nextInt();

        for(int i = 0; i < qtde_enderecos; i++){
            System.out.println(" - Insira a Rua do cliente \n");
            rua = scanner.next();

            System.out.println("- Insira o número da casa do cliente \n");
            numero_rua = scanner.nextInt();

            enderecos.add(new Endereco(rua, numero_rua));
        }

        return new Cliente(nome, idade, celular,enderecos);
    }

    public static void encontrarCliente(String nome, List<Cliente> clientes){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getNome().matches(nome)){
                System.out.println("Cliente encontrado! \n" +
                        "Nome: " + clientes.get(i).getNome() + "\n" +
                        "Idade: " + clientes.get(i).getIdade() + "\n" +
                        "Celular: " + clientes.get(i).getCelular() + "\n" +
                        "Rua principal: " + clientes.get(i).getEndereco().get(0).getRua() + "\n" +
                        "Número: " + clientes.get(i).getEndereco().get(0).getNumero() + "\n" );

            }
        }
    }

    public static void alterarCliente(int index,List<Cliente> clientes){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
