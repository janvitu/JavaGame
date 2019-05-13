package uiText;             //tady hlásí PMD chybu
import java.util.Scanner;
import logika.IHra;
import java.io.*;
/**
 *  Class TextoveRozhrani
 *
 *  Toto je uživatelského rozhraní aplikace Adventura
 *  Tato třída vytváří instanci třídy Hra, která představuje logiku aplikace.
 *  Čte vstup zadaný uživatelem a předává tento řetězec logice a vypisuje odpověď logiky na konzoli.
 *
 *
 *
 *@author     Jan Vítů
 *@version    LS rok 2019
 */

public class TextoveRozhrani {
    private IHra hra;

    /**
     *  Vytváří hru.
     */
    public TextoveRozhrani(IHra hra) {
        this.hra = hra;
    }

    /**
     *  Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování
     *  příkazu od hráče do konce hry (dokud metoda konecHry() z logiky nevrátí
     *  hodnotu true). Nakonec vypíše text epilogu.
     */
    public void hraj() {
        System.out.println(hra.vratUvitani());          //nesmím napsat do logiky

        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.

        while (!hra.konecHry()) {
            String radek = prectiString();
            System.out.println(hra.zpracujPrikaz(radek));
        }

        System.out.println(hra.vratEpilog());
    }

    public void hraj(File nazevSouboru) {
        System.out.println(hra.vratUvitani());

        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.
        try (BufferedReader ctecka = new BufferedReader (new FileReader(nazevSouboru))){
            String radek = ctecka.readLine();
            while (!hra.konecHry() && radek != null) {
                System.out.println("***"+radek+"***");
                System.out.println(hra.zpracujPrikaz(radek));
                radek = ctecka.readLine();
            }

        }
        catch(FileNotFoundException e){
            System.out.println("Soubor s příkazy nenalezen!");
        }

        catch(IOException e){
            System.out.println("Chyba vstupu!");
        }

        System.out.println(hra.vratEpilog());
    }

    /**
     *  Metoda přečte příkaz z příkazového řádku
     *
     *@return    Vrací přečtený příkaz jako instanci třídy String
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }

}
