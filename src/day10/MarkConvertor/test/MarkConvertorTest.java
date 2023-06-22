package day10.MarkConvertor.test;

import day10.MarkConvertor.MarkConvertor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Viac informacii ohladom jUnit testov na https://www.vogella.com/tutorials/JUnit/article.html

@DisplayName("Testy pre metody obdlznika")
class MarkConvertorTest {

	@Test
	@DisplayName("Test metody hodnot")
	public void testHodnot() {
		// testovanie vrchne a spodnej hranice vstupnych znamok v percentach
		// test pre znamku A
		assertEquals('A', MarkConvertor.hodnot(100));
		assertEquals('A', MarkConvertor.hodnot(91));

		// test pre znamku B
		assertEquals('B', MarkConvertor.hodnot(90));
		assertEquals('B', MarkConvertor.hodnot(76));

		// test pre znamku C
		assertEquals('C', MarkConvertor.hodnot(75));
		assertEquals('C', MarkConvertor.hodnot(66));

		// test pre neuspel
		assertEquals(0, MarkConvertor.hodnot(65));
		assertEquals(0, MarkConvertor.hodnot(0));

	}
}