package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;
	TwitterPoruka tp;
	LinkedList<TwitterPoruka> lista;
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		tp = new TwitterPoruka();
		lista = new LinkedList<TwitterPoruka>();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
		tp = null;
	}

	@Test
	public void testVratiSvePoruke() {
		t.unesi("ja", "poruka");
		t.unesi("Ja2", "poruka 2");
		t.unesi("ja3", "poruka 3");
		t.unesi("ja4", "poruka 4");
		lista = t.vratiSvePoruke();
		assertEquals(4,lista.size());
	}

	@Test
	public void testUnesi() {
		t.unesi("ja", "poruka");
		tp.setKorisnik("ja");
		tp.setPoruka("poruka");
		lista = t.vratiSvePoruke();
		assertEquals(tp.toString(), lista.get(0).toString());
	}
	@Test
	public void testVratiPoruke() {
		t.vratiPoruke(0, "poruka");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEx() {
		t.vratiPoruke(2, "");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEx1() {
		t.vratiPoruke(1,null);
	}
}
