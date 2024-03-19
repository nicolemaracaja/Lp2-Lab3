package filmnow;

/**
 * Constrói o filme a partir de seu nome, ano de lançamento e local que foi lançado.
 * 
 * @author Nicole Brito Maracajá
 *
 */
public class Filme {

	private String nome;
	private String ano;
	private String local;
	
	/**
	 * Constrói o filme, com base em seu nome, ano de lançamento e local onde foi lançado.
	 * 
	 * @param nome Nome do filme.
	 * @param ano Ano de lancamento do filme.
	 * @param local Local que o filme foi lancado.
	 * @throws IllegalArgumentException
	 */
	public Filme(String nome, String ano, String local) throws IllegalArgumentException{
		this.nome = nome;
		this.ano = ano;
		this.local = local;

		if(nome.isBlank()) { //verifica se a entrada contem apenas espacos em branco
			throw new IllegalArgumentException("FILME INVÁLIDO");
		}
		if(local.isBlank()) { //verifica se a entrada contem apenas espacos em branco
			throw new IllegalArgumentException("FILME INVÁLIDO");
		}		
	}
	
	/**
	 * Retorna o nome do filme.
	 * @return nome do filme.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Retorna o ano de lançamento do filme.
	 * @return ano de lancamento do filme.
	 */
	public String getAno() {
		return this.ano;
	}
	
	/**
	 * Retorna o local onde o filme foi lançado.
	 * @return local de lancamento do filme.
	 */
	public String getLocal() {
		return this.local;
	}
	
	@Override
	/**
	 * Um equals que retorna true, se o nome do filme e o ano de lançamento forem iguais aos do informado.
	 */
	public boolean equals(Object obj) {
		
		if(obj != null && obj.getClass() == this.getClass()) {
			Filme filme = (Filme) obj;
			return this.nome.equals(filme.nome) && this.ano.equals(filme.ano);
		}
		return false;
	}
	
	/**
	 * Indica se o filme ja existe, baseado no equals.
	 * @param filme Array de Filmes.
	 * @return true ou false, true se já existir, false caso contrário.
	 */
	public boolean jaExiste(Filme[] filmes) {
		for(Filme f: filmes) {
			if(f != null && f.equals(this)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	/**
	 * Um toString que retorna o nome e o ano de lancamento do filme.
	 * @return toString.
	 */
	public String toString() {
		return this.nome; //para o mostra filmes
	}
	
	/**
	 * Um toString que retorna o nome, o ano de lancamento e o local onde o filme foi lançado.
	 * @return toString.
	 */
	public String toStringFilme() {
		return this.nome + ", " + this.ano + "\n" + this.local; //para o detalha filme
	}
}