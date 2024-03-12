package filmnow;

public class Filme {

	private String nome;
	private String ano;
	private String local;
	
	public Filme(String nome, String ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
	}
	
	public String imprimeFilme() {
		StringBuffer sb = new StringBuffer();
		sb.append(nome).append(", ").append(ano).append("\n").append(local);
		
		return sb.toString();		
	}
}
