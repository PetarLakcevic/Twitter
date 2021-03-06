package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa Twitter koja predstavlja Twitter.
 * @version 1.0
 * @author Petar
 *
 */
public class Twitter {
	/**
	 * Lista koja sadrzi poruke.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja vraca listu svih poruka
	 * 
	 * @return LinkedList <TwitterPoruka>
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	/**
	 * Unosenje nove poruke
	 * 
	 * 
	 * @param korisnik - (topa String) koji je napisao poruku
	 * @param poruka - (topa int) tekst poruke
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.add(tp);
	}
	/**
	 * Metoda koja vraca niz twitterporuka koje sadrzi odredjeni tag.
	 * 
	 * @param maxBroj - predtsavlja max broj (tipa int) poruka koje se ubacuju u niz
	 * @param tag - predstavlja tag (tipa String) koji zahtevamo da postoji u datoj poruci
	 * @return	Niz sa porukama
	 * @throws RuntimeException ako su prekreseni uslovi da je tag == null ili empty
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}








