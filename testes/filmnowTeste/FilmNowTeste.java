package filmnowTeste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.FilmNow;
import filmnow.Filme;
import filmnow.MainFilmNow;

class FilmNowTeste {
	
	@BeforeEach
	void preparaFilmNow() {
		
	}

	@Test
	void testCadastraFilmePosicaoVazia() { //teste1
		FilmNow fn = new FilmNow();
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
	}
	
	@Test 
	void testCadastrarFilmeEmPosicaoExistente() { //teste2
		FilmNow fn = new FilmNow();
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.cadastraFilme(1, "Star Wars IV", "1977", "Cinema");
	}
	
	@Test
	void testCadastraFilmeJaCadastrado() { //teste3
		FilmNow fn = new FilmNow();
		
		try {
			fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
			fn.cadastraFilme(3, "Avatar", "2009", "Disney+");
			fail();
		} catch(IllegalArgumentException iae) {
    		assertEquals("FILME JÁ ADICIONADO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmeMesmoNomeAnoDiferenteLocal() { //teste4
		FilmNow fn = new FilmNow();
		
		try {
			fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
			fn.cadastraFilme(2, "Avatar", "2009", "Popcornflix");
			fail();
		} catch(IndexOutOfBoundsException iae) {
    		assertEquals("FILME JÁ ADICIONADO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmePosicaoLimite() { //teste5
		FilmNow fn = new FilmNow();
		
		fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
	}
	
	@Test
	void testCadastraFilmePosicaoAcimaLimite() { //teste6
		FilmNow fn = new FilmNow();
		
		try {
			fn.cadastraFilme(101, "Avatar", "2009", "Disney+");
			fail();
		} catch(IndexOutOfBoundsException iae) {
    		assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmePosicaoAbaixoLimite() { //teste7
		FilmNow fn = new FilmNow();
		
		try {
			fn.cadastraFilme(0, "Avatar", "2009", "Disney+");
			fail();
		} catch(IllegalArgumentException iae) {
    		assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}

	@Test
	void testCadastraFilmeLocalVazio() { //teste8
		FilmNow fn = new FilmNow();
		
		try {
			fn.cadastraFilme(1, "Avatar", "2009", "");
			fail();
		} catch(IllegalArgumentException iae) {
    		assertEquals("FILME INVÁLIDO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmeAnoVazio() { //teste9
		FilmNow fn = new FilmNow();
		
		fn.cadastraFilme(1, "Avatar", "", "Disney+");
	}
	
	@Test
	void testCadastraFilmeNomeVazio() { //teste10
		FilmNow fn = new FilmNow();
		
		try {
			fn.cadastraFilme(1, "", "2009", "Disney+");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals("FILME INVÁLIDO", iae.getMessage());
		}
	}

	@Test
	void testDetalhaFilmeNormal() {
		FilmNow fn = new FilmNow();
		
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("Avatar" + ", " + "2009" + "\n" + "Disney+", fn.detalhaFilme(1));
	}
	
	void testDetalhaFilmeHot() {
		FilmNow fn = new FilmNow();
		
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		
		assertEquals("🔥" + "Avatar" + ", " + "2009" + "\n" + "Disney+", fn.detalhaFilme(1));
	}

	@Test
	void testAdicionaHot() {
		FilmNow fn = new FilmNow();
		
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		
	}
	
	@Test
	void testAdicionaHotRepetido() {
		
	}

	@Test
	void testExibirHotList() {
	}

	@Test
	void testRemoveHot() {
		
	}

}
