package filmnowTeste;

//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import filmnow.FilmNow;
import filmnow.Filme;

class FilmeTest {

	private Filme filmeBase;
	private Filme[] filmes;
	
	@Before
    void preparaFilmes() {
		FilmNow fn = new FilmNow();
        this.filmeBase = new Filme("Avatar", "2009", "Disney+");
        this.filmes = new Filme[100];
        fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
        
        fail("FILME INVÁLIDO");
    }
	
	@Test
	void testFilme() {
		String msg = "Esperando obter o nome e o ano";
	    assertEquals( "Avatar, 2009", this.filmeBase.toString(), msg);
	    
	    fail("FILME INVÁLIDO");
	}

	@Test
	void testEqualsObject() {
		String filme1 = "Avatar 2009";
		String filme2 = "Star Wars 1977";
		
		assertEquals(true, filmeBase.toString().equals(filme1));
		assertEquals(false, filmeBase.toString().equals(filme2));
	}

	@Test
	void testJaExiste() {
		assertEquals(false, filmeBase.jaExiste(filmes));

	}

}
