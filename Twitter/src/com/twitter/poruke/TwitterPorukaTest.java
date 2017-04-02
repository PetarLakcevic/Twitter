package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	TwitterPoruka tp;
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testGetKorisnik() {
		tp.setKorisnik("ja");
		assertEquals("ja", tp.getKorisnik());
	}

	@Test ()
	public void testSetKorisnik() {
		tp.setKorisnik("ja");
		assertEquals("ja", tp.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEx() {
		tp.setKorisnik("");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEx1() {
		tp.setKorisnik(null);
	}
	@Test
	public void testGetPoruka() {
		tp.setPoruka("poruka");
		assertEquals("poruka", tp.getPoruka());
	}

	@Test
	public void testSetPoruka() {
		tp.setPoruka("poruka");
		assertEquals("poruka", tp.getPoruka());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaEx() {
		tp.setPoruka(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaEx1() {
		tp.setPoruka("");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaEx2() {
		tp.setPoruka("asdasdfhbsdhjfdsfhfhffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
	}
	
	@Test
	public void testToString() {
		tp.setKorisnik("Ja");
		tp.setPoruka("poruka");
		assertEquals("KORISNIK:Ja PORUKA:poruka", tp.toString());
	}

}
