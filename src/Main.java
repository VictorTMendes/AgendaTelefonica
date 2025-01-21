import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int escolha;

        do {
            System.out.println("Agenda Telefônica:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Listar Contatos");
            System.out.println("3. Atualizar Contato");
            System.out.println("4. Remover Contato");
            System.out.println("5. Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o telefone do contato: ");
                    int telefone = scanner.nextInt();
                    scanner.nextLine();
                    agenda.adicionarContato(nome, telefone);
                    break;

                case 2:
                    agenda.listarContatos();
                    break;

                case 3:
                    System.out.print("Digite o número do contato que quer atualizar: ");
                    int indiceInput = scanner.nextInt() - 1;
                    scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    int novoTelefone = scanner.nextInt();
                    scanner.nextLine();
                    agenda.atualizarContato(indiceInput, novoNome, novoTelefone);
                    break;

                case 4:
                    System.out.print("Digite o número do contato que deseja remover: ");
                    int indiceRemover = scanner.nextInt() - 1;
                    agenda.removerContato(indiceRemover);
                    break;

                case 5:
                    System.out.println("Saindo da agenda. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 5);
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

    @Override
    public String toString(){
        return " nome: " + nome + ", Telefone: " + telefone;
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