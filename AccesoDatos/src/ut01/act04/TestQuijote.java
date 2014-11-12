package ut01.act04;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuijote {

	@Test
	public void testEsVocal() {
		assertTrue(1==Quijote.esVocal('a'));
		assertTrue(1==Quijote.esVocal('�'));
		assertTrue(1==Quijote.esVocal('A'));
		assertTrue(1==Quijote.esVocal('�'));
		assertTrue(2==Quijote.esVocal('e'));
		assertTrue(2==Quijote.esVocal('�'));
		assertTrue(2==Quijote.esVocal('E'));
		assertTrue(2==Quijote.esVocal('�'));
		assertTrue(3==Quijote.esVocal('i'));
		assertTrue(3==Quijote.esVocal('�'));
		assertTrue(3==Quijote.esVocal('I'));
		assertTrue(3==Quijote.esVocal('�'));
		assertTrue(4==Quijote.esVocal('o'));
		assertTrue(4==Quijote.esVocal('�'));
		assertTrue(4==Quijote.esVocal('O'));
		assertTrue(4==Quijote.esVocal('�'));
		assertTrue(5==Quijote.esVocal('u'));
		assertTrue(5==Quijote.esVocal('�'));
		assertTrue(5==Quijote.esVocal('�'));
		assertTrue(5==Quijote.esVocal('U'));
		assertTrue(5==Quijote.esVocal('�'));
		assertTrue(5==Quijote.esVocal('�'));

	}

}
