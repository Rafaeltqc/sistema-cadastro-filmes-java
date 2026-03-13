import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe que representa um filme
class Filme {
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;
    private double duracao;

    public Filme(String titulo, String diretor, int anoLancamento, String genero, double duracao) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.duracao = duracao;
    }

    // Métodos getters e setters para acessar e modificar os atributos do filme

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
}

// Classe responsável por gerenciar o cadastro de filmes
class SistemaCadastroFilmes {
    private List<Filme> filmes;
    private Scanner scanner;

    public SistemaCadastroFilmes() {
        filmes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Método para adicionar um novo filme à lista
    public void adicionarFilme() {
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o diretor do filme: ");
        String diretor = scanner.nextLine();

        System.out.print("Digite o ano de lançamento do filme: ");
        int anoLancamento = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite o gênero do filme: ");
        String genero = scanner.nextLine();

        System.out.print("Digite a duração do filme (em horas): ");
        double duracao = Double.parseDouble(scanner.nextLine());

        Filme filme = new Filme(titulo, diretor, anoLancamento, genero, duracao);
        filmes.add(filme);

        System.out.println("Filme adicionado com sucesso!");
    }

    // Método para exibir os filmes cadastrados
    public void exibirFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Não há filmes cadastrados.");
        } else {
            System.out.println("Filmes cadastrados:");
            for (Filme filme : filmes) {
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Diretor: " + filme.getDiretor());
                System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
                System.out.println("-----------------------");
            }
        }
    }

    // Método para pesquisar um filme por título
    public void pesquisarFilmePorTitulo() {
        System.out.print("Digite o título do filme: ");
        String titulo = scanner.nextLine();

        boolean encontrado = false;

        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Filme encontrado:");
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Diretor: " + filme.getDiretor());
                System.out.println("Ano de Lançamento: " + filme.getAnoLancamento());
                System.out.println("Gênero: " + filme.getGenero());
                System.out.println("Duração: " + filme.getDuracao() + " horas");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Filme não encontrado.");
        }
    }

    // Método para editar os dados de um filme
    public void editarFilme() {
        System.out.print("Digite o título do filme que deseja editar: ");
        String titulo = scanner.nextLine();

        Filme filmeEncontrado = null;

        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                filmeEncontrado = filme;
                break;
            }
        }

        if (filmeEncontrado == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.print("Digite o novo título do filme: ");
            String novoTitulo = scanner.nextLine();
            filmeEncontrado.setTitulo(novoTitulo);

            System.out.print("Digite o novo diretor do filme: ");
            String novoDiretor = scanner.nextLine();
            filmeEncontrado.setDiretor(novoDiretor);

            System.out.print("Digite o novo ano de lançamento do filme: ");
            int novoAnoLancamento = Integer.parseInt(scanner.nextLine());
            filmeEncontrado.setAnoLancamento(novoAnoLancamento);

            System.out.print("Digite o novo gênero do filme: ");
            String novoGenero = scanner.nextLine();
            filmeEncontrado.setGenero(novoGenero);

            System.out.print("Digite a nova duração do filme (em horas): ");
            double novaDuracao = Double.parseDouble(scanner.nextLine());
            filmeEncontrado.setDuracao(novaDuracao);

            System.out.println("Filme editado com sucesso!");
        }
    }

    // Método para excluir um filme
    public void excluirFilme() {
        System.out.print("Digite o título do filme que deseja excluir: ");
        String titulo = scanner.nextLine();

        Filme filmeEncontrado = null;

        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                filmeEncontrado = filme;
                break;
            }
        }

        if (filmeEncontrado == null) {
            System.out.println("Filme não encontrado.");
        } else {
            System.out.println("Deseja realmente excluir o filme \"" + filmeEncontrado.getTitulo() + "\"? (S/N)");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("S")) {
                filmes.remove(filmeEncontrado);
                System.out.println("Filme excluído com sucesso!");
            } else {
                System.out.println("Operação de exclusão cancelada.");
            }
        }
    }
}

public class ProgramaJava {
    public static void main(String[] args) {
        SistemaCadastroFilmes sistema = new SistemaCadastroFilmes();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Exibir Filmes");
            System.out.println("3. Pesquisar Filme por Título");
            System.out.println("4. Editar Filme");
            System.out.println("5. Excluir Filme");
            System.out.println("6. Sair");
            System.out.print("Digite a opção desejada: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    sistema.adicionarFilme();
                    break;
                case 2:
                    sistema.exibirFilmes();
                    break;
                case 3:
                    sistema.pesquisarFilmePorTitulo();
                    break;
                case 4:
                    sistema.editarFilme();
                    break;
                case 5:
                    sistema.excluirFilme();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        } while (opcao != 6);
    }
}
