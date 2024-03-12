package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author Nicole Brito Maracajá
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	
	private Filme[] filmes; //uma representacao simploria da lista de filmes

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();		
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 * @throws IndexOutOfBoundsException caso se, na posição cadastrada, não haja nenhum filme cadastrado.
	 */
	public Filme getFilme(int posicao) throws IndexOutOfBoundsException{
		if(this.filmes[posicao] == null ) {
			throw new IndexOutOfBoundsException("POSICAO INVALIDA");
		}	
		return this.filmes[posicao];
	}

	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 * @throws IllegalArgumentException Caso nome ou local estejam vazios.
	 * @throws IndexOutOfBoundsException Caso a posicao selecionada seja menor que 1 ou maior que 100.
	 */
	public void cadastraFilme(int posicao, String nome, String ano, String local) {
		Filme filme = new Filme(nome, ano, local);
		
		if (posicao < 1 || posicao > 100) {
			throw new IndexOutOfBoundsException("POSICAO INVALIDA");
		}
		if(nome.isEmpty()) {
			throw new IllegalArgumentException("FILME INVALIDO");
		}	
		if(local.isEmpty()) {
			throw new IllegalArgumentException("FILME INVALIDO");
		}	
		if(filme.jaExiste(this.getFilmes())) {
			throw new IllegalArgumentException("CONTATO JA CADASTRADO");
		}
		
		this.filmes[posicao] = filme;
	}


	/**
	 * Retorna o contato localizado na posicao selecionada.
	 * Caso o contato esteja na lista de favoritos, ele terá um "❤️" no início. 
	 * @param posicao Posicao do contato.
	 * @return o contato formatado.
	 */
	public String detalhaFilme(int posicao) {
		
		return filmes[posicao].imprimeFilme();
	}
	
}

