import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        scanner.close();
    }
}

class Contato {
    private String nome;
    private int telefone;

    public Contato(String nome, int telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone(){
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String exibir(){
        return "nome: " + nome + ", Telefone: " + telefone;
    }
}

class Agenda {

    private ArrayList<Contato> contatos;

    public Agenda(){
        contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, int telefone){
        contatos.add(new Contato(nome, telefone));
        System.out.println("Contato adicionado com sucesso!");
    }

    public void listarContatos() {
        if(contatos.isEmpty()) {
            System.out.println("A agenda está vazia");
        } else {
            System.out.println();
            System.out.println("Lista de contatos: ");
            for(int i = 0; i < contatos.size(); i++){
                System.out.println((i + 1) + "." + contatos.get(i));
            }
        }
    }

    public void removerContato(int indice) {
        if(indice >= 0 && indice < contatos.size()){
            contatos.remove(indice);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Indice incorreto");
        }
    }

    public void atualizarContato(int indice, String novoNome, int novoTelefone){
        if(indice >= 0 && indice < contatos.size()) {
            Contato contato = contatos.get(indice);
            contato.setNome(novoNome);
            contato.setTelefone(novoTelefone);
            System.out.println("Contato atualizado com sucesso!");
        } else {
            System.out.println("Índice incorreto");
        }
    }

}