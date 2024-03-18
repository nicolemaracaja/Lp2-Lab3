package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author Nicole Brito Maracajá
 *
 */
public class FilmNow {
	
	private static final int TAMANHO = 101;
	private static final int TAMANHOHOTLIST = 11;
	
	private Filme[] filmes; //uma representacao simploria da lista de filmes
	private Filme[] hotList; //uma representacao simploria da hotlist

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
		this.hotList = new Filme[TAMANHOHOTLIST];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();		
	}
	
	/**
	 * Acessa a hotlist
	 * @return O array de filmes favoritos
	 */
	public Filme[] getHot() {
		return this.hotList.clone();		
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
			throw new IndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		if(nome.isEmpty() || nome.isBlank()) {
			throw new IllegalArgumentException("FILME INVÁLIDO");
		}	
		if(local.isEmpty() || local.isBlank()) {
			throw new IllegalArgumentException("FILME INVÁLIDO");
		}	
		if(filme.jaExiste(this.getFilmes())) {
			throw new IllegalArgumentException("FILME JÁ ADICIONADO");
		}
		
		this.filmes[posicao] = filme;
	}
	
	/**
	 * Retorna o filme localizado na posicao selecionada.
	 * Caso o filme esteja na hotlist, ele retornará com um 🔥 no início.
	 * @param posicao Posicao do filme.
	 * @return o nome do filme ano de lançamento e local.
	 */
	public String detalhaFilme(int posicao) {
		
		for (int i = 0; i < hotList.length; i ++) {
			if(this.filmes[posicao] == this.hotList[i]) {
				return "🔥" + " " + filmes[posicao].toStringFilme();
		}
		//if(this.filmes[posicao] == this.hotList[posicao]) {
			//return "🔥" + " " + filmes[posicao].toStringFilme();
		}
		return filmes[posicao].toStringFilme();
	}
	
	/**
	 * Adiciona um filme na hotlist.
	 * @param posicao Posicao do filme na lista de filmes.
	 * @param posicao Posicao na hotlist onde o filme será alocado.
	 */
	public void adicionaHot(int posicao, int posicaoHot) {	
		
		for(int i = 1; i < hotList.length; i++) {
			if(filmes[posicaoHot].equals(hotList[i]) && filmes[posicaoHot] != null && hotList[i] != null) {
				System.out.println("FILME JÁ ESTÁ NA HOTLIST");
				return;
			}
		}		
		this.hotList[posicaoHot] = this.filmes[posicao];
		System.out.println("ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot + "!");
		
	}
	
	/**
	 * Retorna a hotList.
	 */
	public void exibirHotList() {
		
		for(int i = 1; i < hotList.length; i++) {
			if(hotList[i] != null) {
				System.out.println(i + " - " + hotList[i].getNome() + " " + hotList[i].getAno());
			}
		}	
	}
	
	/**
	 * Remove um filme da hotlist, na posicao informada.
	 * @param posicao Posicao do filme na hotlist..
	 */
	public void removeHot(int posicao) {
		
		hotList[posicao] = null;
	}
	
}
