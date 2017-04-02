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
		tp.setKorisnik("ja");
		tp.setPoruka("poruka");
		t.unesi("ja", "poruka");
		lista = t.vratiSvePoruke();
		assertEquals(lista.get(0).toString(), tp.toString());
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
