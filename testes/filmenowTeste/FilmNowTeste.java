package filmenowTeste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.FilmNow;

/**
 * Testes do FilmNow.
 * 
 * @author Nicole Brito Maracajá
 *
 */
class FilmNowTeste {
	
	/*
	 * Cria um filmNow base para testar os métodos implementados na classe FilmNow.
	 */
	private FilmNow fnBase;
	
	@BeforeEach
	void preparaFilmNow() throws Exception {
		this.fnBase = new FilmNow();
	}
	
	@Test
	void testCadastraFilmePosicaoVazia() { //teste1
		
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
	}
	
	@Test 
	void testCadastrarFilmeEmPosicaoExistente() { //teste2
	
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fnBase.cadastraFilme(1, "Star Wars IV", "1977", "Cinema");
	}
	
	@Test
	void testCadastraFilmeJaCadastrado() { //teste3
		
		try {
			fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
			fnBase.cadastraFilme(3, "Avatar", "2009", "Disney+");
			fail();
		} catch(IllegalArgumentException iae) {
    		assertEquals("FILME JÁ ADICIONADO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmeMesmoNomeAnoDiferenteLocal() { //teste4
		
		try {
			fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
			fnBase.cadastraFilme(2, "Avatar", "2009", "Popcornflix");
			fail();
		} catch(IllegalArgumentException iae) {
    		assertEquals("FILME JÁ ADICIONADO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmePosicaoLimite() { //teste5
		
		fnBase.cadastraFilme(100, "Avatar", "2009", "Disney+");
	}
	
	@Test
	void testCadastraFilmePosicaoAcimaLimite() { //teste6
		
		try {
			fnBase.cadastraFilme(101, "Avatar", "2009", "Disney+");
			fail();
		} catch(IndexOutOfBoundsException iae) {
    		assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmePosicaoAbaixoLimite() { //teste7
		
		try {
			fnBase.cadastraFilme(0, "Avatar", "2009", "Disney+");
			fail();
		} catch(IndexOutOfBoundsException iae) {
    		assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}

	@Test
	void testCadastraFilmeLocalVazio() { //teste8
		
		try {
			fnBase.cadastraFilme(1, "Avatar", "2009", "");
			fail();
		} catch(IllegalArgumentException iae) {
    		assertEquals("FILME INVÁLIDO", iae.getMessage());
		}
	}
	
	@Test
	void testCadastraFilmeAnoVazio() { //teste9
		
		fnBase.cadastraFilme(1, "Avatar", "", "Disney+");
	}
	
	@Test
	void testCadastraFilmeNomeVazio() { //teste10
		
		try {
			fnBase.cadastraFilme(1, "", "2009", "Disney+");
			fail();
		}catch(IllegalArgumentException iae) {
			assertEquals("FILME INVÁLIDO", iae.getMessage());
		}
	}

	@Test
	void testDetalhaFilmeNormalTodosDados() { //teste1
		
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("Avatar" + ", " + "2009" + "\n" + "Disney+", fnBase.detalhaFilme(1));
	}
	
	@Test
	void testDetalhaFilmeAnoVazio() { //teste2
		fnBase.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");
		assertEquals("20 dias em Mariupol" + "\n" + "Cinema", fnBase.detalhaFilme(1));
	}
	
	@Test
	void testDetalhaFilmePosicaoVazia() { //teste3
		
		try {
			fnBase.detalhaFilme(85);
		}catch(NullPointerException iae) {
			assertEquals("", iae.getMessage());
		}
	}
	
	@Test
	void testDetalhaFilmePosicaoAbaixoLimiteInferior() { //teste4
		
		try {
			fnBase.detalhaFilme(-1);
			fail();
		}catch (IndexOutOfBoundsException iae) {
			assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testDetalhaFilmePosicaoAcimaLimiteSuperior() { //teste5
		
		try {
			fnBase.detalhaFilme(101);
			fail();
		}catch (IndexOutOfBoundsException iae) {
			assertEquals("POSIÇÃO INVÁLIDA", iae.getMessage());
		}
	}
	
	@Test
	void testDetalhaFilmeHot() { //teste6
		
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fnBase.adicionaHot(1, 1);
		
		assertEquals("🔥 " + "Avatar" + ", " + "2009" + "\n" + "Disney+", fnBase.detalhaFilme(1));
	}

	@Test
	void testAdicionaHot() {
		
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fnBase.adicionaHot(1, 1);
		
	}
	
	@Test
	void testAdicionaHotRepetido() {
		
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
		
		assertEquals(true, fnBase.adicionaHot(1, 2));
		assertEquals(false, fnBase.adicionaHot(1, 2));
	}

	@Test
	void testExibirHotList() {
		
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
		
		assertEquals(true, fnBase.adicionaHot(1, 2));
	}

	@Test
	void testRemoveHot() {
		
		fnBase.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fnBase.adicionaHot(1, 1);
		fnBase.removeHot(1);
		assertEquals("Avatar" + ", " + "2009" + "\n" + "Disney+", fnBase.detalhaFilme(1));
	}

}