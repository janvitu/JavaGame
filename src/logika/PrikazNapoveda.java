package logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 *  
 */
class PrikazNapoveda implements IPrikaz {
    
    private static final String NAZEV = "nápověda";
    private SeznamPrikazu platnePrikazy;
    
    
     /**
    *  Konstruktor třídy
    *  
    *  @param platnePrikazy seznam příkazů,
    *                       které je možné ve hře použít,
    *                       aby je nápověda mohla zobrazit uživateli. 
    */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return "Tvým úkolem je vyřešit sérii vražd za pomoci pozbírání jednotlivých indicií.\n"
        + "Po interakci s jednotlivými osobami se můžeš dostat prakticky do jakékoli místnosti.\n"
        + "Doporučení pro začátek je dostat se do skladu, který je hned vedle kuchyně.\n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + "\033[1;36m" + platnePrikazy.vratNazvyPrikazu() + "\033[0m";
    }
    
     /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
      public String getNazev() {
        return NAZEV;
     }

}
