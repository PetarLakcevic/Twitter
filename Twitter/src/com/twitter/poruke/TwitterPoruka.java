package com.twitter.poruke;
/**
 * Klasa koja predstavlja jednu twitter poruku sa njenim atributima (korisnik i tekst same poruke)
 * @version 1.0
 * @author Petar
 *
 */
public class TwitterPoruka {
	/**
	 * String koji predstavlja korisnika twittera
	 */
	private String korisnik;
	/**
	 * String koji predstavlja poruku koji ce korisnik poslati
	 */
	private String poruka;

	/**
	 * Get metoda koja vraca korisnika
	 * 
	 * @return String (korisnik)
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 *  Metoda koja postavlja korisnika
	 * @param korisnik - String koji predstavlja username korisnika koji pise poruku
	 * @throws RuntimeException ako je uneti korisnik null ili prazan string
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Get metoda koja vraca poruku
	 * 
	 * @return String (poruka)
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 *  Postavlja poruku
	 * @param poruka - String koji predstavlja tekst poruke
	 * @throws RuntimeException ako je uneto null ili prazan string ili poruka duza od 140 karaktera kao poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.equals("") || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Redefinisana toString metoda 
	 * @return string u obliku "KORISNIK:" + korisnik + " PORUKA:" + poruka
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}