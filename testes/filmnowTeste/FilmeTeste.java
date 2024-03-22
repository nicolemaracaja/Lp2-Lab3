package filmnowTeste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filmnow.Filme;

class FilmeTeste {

	private Filme filmeBase;
	
	@BeforeEach
	void preparaFilme() throws Exception {
		this.filmeBase = new Filme("Avatar", "2009", "Disney+");
	}
	
	@Test
	void testFilmeNomeBranco() {
		Filme filme2;
		try {
			filme2 = new Filme("", "2009", "Disney+");
			fail();
		}catch(IllegalArgumentException iae) {
    		assertEquals("FILME INVÁLIDO", iae.getMessage());
		}
	}
	
	@Test
	void testFilmeAnoBranco() {
		Filme filme3 = new Filme("Avatar", "", "Disney+");
		assertEquals("Avatar" + "\n" + "Disney+", filme3.toStringFilme());
	}
	
	@Test
	void testFilmeLocalBranco() {
		Filme filme4;
		try {
			filme4 = new Filme("Avatar", "2009", "");
			fail();
		}catch(IllegalArgumentException iae) {
    		assertEquals("FILME INVÁLIDO", iae.getMessage());
		}
	}

	@Test
	void testGetNome() {
		assertEquals("Avatar", filmeBase.getNome());
	}

	@Test
	void testGetAno() {
		assertEquals("2009", filmeBase.getAno());
	}

	@Test
	void testGetLocal() {
		assertEquals("Disney+", filmeBase.getLocal());
	}

	@Test
	void testEqualsObject() {
		Filme filme5 = new Filme("Donzela", "2024", "Netflix");
		
		assertEquals(true, filmeBase.equals(filmeBase));
		assertEquals(false, filmeBase.equals(filme5));
	}

	@Test
	void testToString() {
		assertEquals("Avatar", filmeBase.toString());
	}

	@Test
	void testToStringFilme() {
		assertEquals("Avatar" + ", " + "2009" + "\n" + "Disney+", filmeBase.toStringFilme());
	}

}
