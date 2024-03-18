package filmnow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author Nicole Brito Maracajá
 *
 */
public class MainFilmNow {

	public static void main(String[] args) {
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaFilmes("filmes_inicial.csv", fn);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}
	}
	
	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(A)Adicionar filme\n" + 
						"(M)Mostrar todos\n" + 
						"(D)Detalhar filme\n" + 
						"(E)Exibir HotList\n" +
						"(H)Atribuir Hot\n" +
						"(R)Remover Hot\n" +
						"(S)Sair\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionaFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			adicionarHot(fn, scanner);
			break;
		case "R":
			removerHot(fn, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Remove um filme da hotlist.
	 * @param fn O sistema Filmnow.
	 * @param scanner Scanner para pedir a posicao.
	 */
	private static void removerHot(FilmNow fn, Scanner scanner) {
		System.out.println("Posicao> ");
		int posicao = scanner.nextInt();
		
		fn.removeHot(posicao);
		return;
	}
	
	/**
	 * Adiciona um filme à hotlist.
	 * @param fn O sistema Filmnow.
	 * @param scanner Scanner para pedir a posicao.
	 */
	private static void adicionarHot(FilmNow fn, Scanner scanner) {
		
		while (true) {
			System.out.print("Filme> ");
			int posicaoFilme = scanner.nextInt();
			
			if(posicaoFilme < 1 || posicaoFilme > 100) {
				System.out.println("POSIÇÃO INVÁLIDA");
				return;
			}
			
			System.out.print("Posicao> ");
			int posicaoHot = scanner.nextInt();
			
			if(posicaoHot < 1 || posicaoHot > 10) {
				System.out.println("POSIÇÃO INVÁLIDA");
				return;
			}
			
			fn.adicionaHot(posicaoFilme, posicaoHot);
			break;
		}
	}
	/**
	 * Imprime a HotList.
	 * @param fn O sistema FilmNow
	 */
	private static void exibirHotList(FilmNow fn) {
		fn.exibirHotList();
	}		

	/**
	 * Imprime lista de filmes.

	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {

		Filme[] filmes = fn.getFilmes();
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i] != null) {
				System.out.println(formataFilme(i, filmes[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos filmes. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual filme.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nQual filme> ");
		int posicao = scanner.nextInt();
		
		if(fn.getFilmes()[posicao] == null){
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}
		System.out.println("Dados do filme:\n" + fn.detalhaFilme(posicao));
	}

	/**
	 * Formata um filme para impressão. 
	 * 
	 * @param posicao A posição do filme (que é exibida)/
	 * @param filme O filme a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataFilme(int posicao, Filme filme) {
		return posicao + " - " + filme;
	}

	/**
	 * Cadastra um filme no sistema. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFilme(FilmNow fn, Scanner scanner) {
		
		while (true) {
			
			System.out.print("\nPosição no sistema> ");
			scanner.nextLine();
			int posicao = scanner.nextInt();
			
			if (posicao < 1 || posicao > 100) {
				System.out.println("POSIÇÃO INVÁLIDA");
				return;
			}
			
			scanner.nextLine();
			System.out.print("\nNome> ");
			String nome = scanner.nextLine();
			
			if (nome.isEmpty() || nome.isBlank()) { //caso a entrada seja vazia, caso de erro
				System.out.println("FILME INVÁLIDO");
				return;
			}
			
			System.out.print("\nAno> ");
			String ano = scanner.nextLine();
			
					
			System.out.print("\nLocal> ");
			String local = scanner.nextLine();
			
			if (local.isEmpty() || local.equals("")) {
				System.out.println("FILME INVÁLIDO");
				return;
			}
			
			Filme filme = new Filme(nome, ano, local);
			
			if (filme.jaExiste(fn.getFilmes())){
				System.out.println("FILME JÁ ADICIONADO");
				return;
			}
			
			fn.cadastraFilme(posicao, nome, ano, local);
			System.out.println("FILME ADICIONADO");
			
			break;
				
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê carga de filmes de um arquivo csv. 
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();
		
		int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}