package filmnowTeste;

//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import org.junit.Test;
import filmnow.FilmNow;
import filmnow.Filme;

class FilmNowTest {

	@Test
	void testFilmNow() {
		fail("Not yet implemented");
	}

	@Test
	void testCadastraFilme() {
		FilmNow fn = new FilmNow();
		
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		
		fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema");
		
		try {fn.cadastraFilme(3, "Avatar", "2009", "Disney+"); ;
    	fail();
    	}catch(Exception erro) {
    		assertEquals(erro.getMessage(),("FILME JÁ ADICIONADO"));
    	}
		
		try {fn.cadastraFilme(3, "Avatar", "2003", "Popcornflix"); ;
    	fail();
    	}catch(Exception erro) {
    		assertEquals(erro.getMessage(),("FILME JÁ ADICIONADO"));
    	}
		
		try {fn.cadastraFilme(101, "Avatar", "2009", "Disney+"); ;
    	fail();
    	}catch(Exception erro) {
    		assertEquals(erro.getMessage(),("POSIÇÃO INVÁLIDA"));
    	}
		
		try {fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "");
    	fail();
    	}catch(Exception erro) {
    		assertEquals(erro.getMessage(),("FILME INVÁLIDO"));
    	}
		
		fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");
		
		try {fn.cadastraFilme(1, "", "2023", "Cinema");
		fail();
		}catch(Exception erro) {
			assertEquals(erro.getMessage(), ("FILME INVÁLIDO"));
		}
	}

	@Test
	void testDetalhaFilme() { 
		FilmNow fn = new FilmNow();
		
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		assertEquals("Avatar, " + "2009" + "\n" + "Cinema", fn.detalhaFilme(1));
		
		fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");	
		assertEquals("20 dias em Maripuol" + "\n" + "Cinema", fn.detalhaFilme(1));
		
		fn.detalhaFilme(100);
		assertEquals(null, fn.detalhaFilme(100));
		
		try {fn.detalhaFilme(0);
		fail();
		}catch(Exception erro) {
			assertEquals(erro.getMessage(), ("POSIÇÃO INVÁLIDA"));
		}
		
		try {fn.detalhaFilme(101);
		fail();
		}catch(Exception erro) {
			assertEquals(erro.getMessage(), ("POSIÇÃO INVÁLIDA"));
		}
		
		fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
		fn.adicionaHot(1, 1);
		fn.detalhaFilme(1);
		assertEquals("🔥" + "Avatar, " + "2009" + "\n" + "Disney+", fn.detalhaFilme(1));
		
	}

	@Test
	void testAdicionaHot() {
		fail("Not yet implemented");
	}

	@Test
	void testExibirHotList() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveHot() {
		fail("Not yet implemented");
	}

}
