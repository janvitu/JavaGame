package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Jan Vírů
 *@version    LS 2019
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;
    private Notes notes;
    private boolean vyhral = false;
    private boolean prohral = false;

    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();
        notes = new Notes();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory

        /*
        * ##########################
        * ____Přízemní místnosti____
        * ##########################
        * */
        Prostor nadvori             = new Prostor("nádvoří", "Hlavní nádvoří školy");
        Prostor chodbaPrizemi       = new Prostor("chodba_přízemí", "Hlavní chodba v přízemí");
        Prostor skolnikuvDum        = new Prostor("školníkův_dům", "Školníkův dům, plný podivných nástrojů a plný tajemna.");
        Prostor ubikace             = new Prostor("ubikace", "Je vidět, že studenti utíkali rychle nechali zde i jídlo.");
        Prostor zbrojnice           = new Prostor("zbrojnice", "Místnost se zbraněmi a výstrojí");
        Prostor schodistePrizemi    = new Prostor("schodiště_přízemí", "Schodiště, které vede do patra");
        Prostor sklad               = new Prostor("sklad", "Na první pohled si jde všimnout zkrvavené šachty, která s největší pravděpodobností vede do suterénu.");
        Prostor jidelna             = new Prostor("jídelna", "místo pro jezení");
        Prostor kuchyn              = new Prostor("kuchyň", "Je zde hodně zaschlé krve. Mrtvoly odsud musel někdo odtáhnout.");
        Prostor cvicisteUvnitr      = new Prostor("cvičiště_uvniť", "Vnitřní cvičiště");
        Prostor cvicisteVnejsi      = new Prostor("cvičiště_venku", "Venkovní cvičiště");

        // zamcene mistnosti

        /*
         * ###########################
         * ______Místnosti patro______
         * ###########################
         * */
        Prostor schodistePatro      = new Prostor("schodiště_patro", "schodiště, které vede do přízemí");
        Prostor chodbaPatro         = new Prostor("chodba_patro", "hlavní chodba v patře");
        Prostor reditelna           = new Prostor("ředitelna", "ředitelova pracovna a osobní laboratoř");
        Prostor ubikaceInstruktori  = new Prostor("ubikace_instruktorů", "Hlavní ubikace instruktorů");
        Prostor knihovna            = new Prostor("knihovna", "Knihovna magie a alchymie");
        Prostor cvicebnaMagie       = new Prostor("cvičebna_magie", "Cvičebna magie a alchymie");
        Prostor mistnostInstruktoru = new Prostor("místnost_instruktorů", "Konzultační a odpočinková místnost instruktorů");

        /*
         * ###########################
         * _____Místnosti suterén_____
         * ###########################
         * */
        Prostor suteren1            = new Prostor("suteren", "Chodba plná pavučin a slizu");
        Prostor suteren2            = new Prostor("suteren_dál", "Zapáchající chodba plná zkaženého masa. Po bližším prozkoumání je vidět, že jsou zde jakési skryté dveře a je možnost je otevřít pomocí páky.");
        Prostor tajnaMistnost       = new Prostor("tajná_místnost", "Tajná místnost v suterénu (velmi zapáchající). Místnost je plná mrtvol, které nejspíše přišli šachtou.");


        // zamcene minstnosti

            suteren1.zamknout(true);
            skolnikuvDum.zamknout(true);
            knihovna.zamknout(true);
            skolnikuvDum.zamknout(true);
            zbrojnice.zamknout(true);
            sklad.zamknout(true);
            kuchyn.zamknout(true);
            cvicisteUvnitr.zamknout(true);
            cvicisteVnejsi.zamknout(true);
            tajnaMistnost.zamknout(true);
            ubikaceInstruktori.zamknout(true);
            mistnostInstruktoru.zamknout(true);

        // přiřazují se průchody mezi prostory (sousedící prostory)

        /*
         * ####################################
         * ____Přízemní místnosti propojeni____
         * ####################################
         * */
        nadvori.setVychod(chodbaPrizemi);
        nadvori.setVychod(skolnikuvDum);
        skolnikuvDum.setVychod(suteren1);
        skolnikuvDum.setVychod(nadvori);
        chodbaPrizemi.setVychod(ubikace);
        chodbaPrizemi.setVychod(zbrojnice);
        chodbaPrizemi.setVychod(schodistePrizemi);
        chodbaPrizemi.setVychod(jidelna);
        chodbaPrizemi.setVychod(kuchyn);
        chodbaPrizemi.setVychod(nadvori);
        zbrojnice.setVychod(chodbaPrizemi);
        zbrojnice.setVychod(cvicisteUvnitr);
        cvicisteUvnitr.setVychod(zbrojnice);
        cvicisteUvnitr.setVychod(cvicisteVnejsi);
        cvicisteVnejsi.setVychod(cvicisteUvnitr);
        ubikace.setVychod(chodbaPrizemi);
        schodistePrizemi.setVychod(chodbaPrizemi);
        schodistePrizemi.setVychod(schodistePatro);
        sklad.setVychod(kuchyn);
        jidelna.setVychod(chodbaPrizemi);
        jidelna.setVychod(kuchyn);
        kuchyn.setVychod(chodbaPrizemi);
        kuchyn.setVychod(jidelna);
        kuchyn.setVychod(sklad);

        /*
         * ###################################
         * ____Suteren místnosti propojeni____
         * ###################################
         * */
        suteren1.setVychod(skolnikuvDum);
        suteren1.setVychod(tajnaMistnost);
        suteren1.setVychod(suteren2);
        suteren2.setVychod(suteren1);
        tajnaMistnost.setVychod(suteren1);

        /*
         * #################################
         * ____Patro místnosti propojeni____
         * #################################
         * */
        schodistePatro.setVychod(chodbaPatro);
        schodistePatro.setVychod(schodistePrizemi);
        chodbaPatro.setVychod(schodistePatro);
        chodbaPatro.setVychod(reditelna);
        chodbaPatro.setVychod(ubikaceInstruktori);
        chodbaPatro.setVychod(knihovna);
        chodbaPatro.setVychod(cvicebnaMagie);
        chodbaPatro.setVychod(mistnostInstruktoru);
        chodbaPatro.setVychod(schodistePatro);

        reditelna.setVychod(chodbaPatro);
        ubikaceInstruktori.setVychod(chodbaPatro);
        knihovna.setVychod(chodbaPatro);
        knihovna.setVychod(cvicebnaMagie);
        cvicebnaMagie.setVychod(chodbaPatro);
        cvicebnaMagie.setVychod(knihovna);
        mistnostInstruktoru.setVychod(chodbaPatro);

        aktualniProstor = nadvori;  // hra začíná v domečku

        
        
        /*
         * ######################
         * ____Vytvoreni veci____
         * ######################
         * */

        /*
         * #################
         * Veci prenositelne
         * #################
         * */

        /*
        Junk
         */
        Vec trofejZlata         = new Vec("Zlatá_trofej", true, false,false);
        Vec trofejSklenena      = new Vec("Skleněá_trofej", true, false, false);
        Vec poharZlaty          = new Vec("Zlatý_pohár", true,false,false);
        Vec poharStribrny       = new Vec("Stříbrný_pohár", true, false,false);
        Vec stribrnyNahrdelnik  = new Vec("Stříbrný_náhrdelník", true, false, false);
        Vec knihaStara          = new Vec("Prastará_kniha", true, false, false);
        Vec knihaPredku         = new Vec("Kniha_předků", true, false, false);
        Vec knihaAlchymie       = new Vec("Kniha_alchymie", true, false,false);
        Vec knihaStrategie      = new Vec("Kniha_strategie", true, false,false);
        Vec lahvicka            = new Vec("Lahvička", true, false, false);
        Vec neznamyLektvar      = new Vec("Neznámý_lektvar", true, true,false);
        Vec lecivyLektvar       = new Vec("Léčivý_lektvar", true, true,false);
        Vec kyselina            = new Vec("Kyselina", true,false,false);
        Vec kladivo             = new Vec("Kladivo", true, false, false);
        Vec pila                = new Vec("Pila", true, false, false);
        Vec ohnivyKalich        = new Vec("Ohnivý_kalich", true,false,false);
        Vec kalichZlaty         = new Vec("Zlatý_kalich", true,false,false);
        Vec kalichStribrny      = new Vec("Stříbrný_kalich", true, false, false);

        /*
        Jídlo
         */
        Vec jablko          = new Vec("Jablko", true, true, true);
        Vec jablecnyKolac   = new Vec("Jablečný_koláč", true, true, true);
        Vec hruska          = new Vec("Hruška", true, true, true);
        Vec kureciStehno    = new Vec("Kuřecí_stehno", true,true,false);
        Vec kure            = new Vec("Kuře", true, true, false);
        Vec krocan          = new Vec("Krocan", true, true, false);
        /*
        * důkazy
        * */
        Vec krvaveNuzky     = new Vec("Krvavé_nůžky", true, true, false);
        Vec krvavaLatka     = new Vec("Zkrvavená_látka", true, true, false);
        Vec dopisNecitelny  = new Vec("Nečitelný_dopis", true, false, false);
        Vec dopisUsvedcujici= new Vec("Usvědčující_dopis", true, false, false);
        Vec jablkoPodivne   = new Vec("Podivné_jablko", true, false, false);
        Vec krvaveHrabe     = new Vec("Krvavé_hrábě", true, false,false);
        Vec skalpel         = new Vec("Skalpel", true, false,false);
        Vec reznickyNuz     = new Vec("Řeznický_nůž_krvavý", true,false,false);
        Vec tesak           = new Vec("Zkrvavený_tesák", true,false,false);
        /*
         * statické věci
         * */
        Vec zidle           = new Vec("Židle", false, false, true);
        Vec stul            = new Vec("Stůl", false, false, true);
        Vec konferencniStul = new Vec("Konferenční_stůl", false, false, false);

        /*
         * zbraně
         * */
        Vec mec             = new Vec("Meč", true, true, true);
        Vec luk             = new Vec("Luk", true, true, true);
        Vec kopi            = new Vec("Kopí", true, true, true);
        Vec naginata        = new Vec("Naginata", true, true, true);
        Vec halapartna      = new Vec("Halapartna", true, true, true);
        Vec magickaHul      = new Vec("Magická_věc", true, true, true);
        Vec svitekOhnivy    = new Vec("Svitek_ohně", true, true, true);
        Vec svitekLedoveKopi= new Vec("Svitek_ledového_kopí", true,true,true);
        /*
         * klíče
         * */
        Vec klicDum         = new Vec("Klíč_školnikuv", true, false, false);
            skolnikuvDum.setKlic(klicDum);
        Vec svazekKlicu     = new Vec("Klíče", true, false, false);
        Vec klicKuchyn      = new Vec("Klíč_kuchyň", true, false, false);
            kuchyn.setKlic(klicKuchyn);
        Vec klicSklad       = new Vec("Klíč_sklad", true, false, false);
            sklad.setKlic(klicSklad);
        Vec klicPoklop      = new Vec("Klíč_poklop", true, false, false);
            suteren1.setKlic(klicPoklop);
        Vec klicZbrojnice   = new Vec("Klíč_zbrojnice", true, false, false);
            zbrojnice.setKlic(klicZbrojnice);
        Vec klicCviciste    = new Vec("Klíč_cvičiště", true, false, false);
            cvicisteUvnitr.setKlic(klicCviciste);
            cvicisteVnejsi.setKlic(klicCviciste);
        Vec klicPaka        = new Vec("Dřevěná_páka", true, false, false);
            tajnaMistnost.setKlic(klicPaka);
        Vec klicKnihovna    = new Vec("Klíč_knihovna", true, false, false);
            knihovna.setKlic(klicKnihovna);
        Vec paklic          = new Vec("Paklíč", true, true,true);

        /*
        * ##########
        * Veci velke
        * ##########
        * */
        VelkaVec lavice                     = new VelkaVec("Lavice",false);
        VelkaVec kamen                      = new VelkaVec("Velký_kámen", false);
        VelkaVec ker                        = new VelkaVec("Keř", false);
        VelkaVec trofejovaSkrinZamcena      = new VelkaVec("Výstavní_skříň", true); // Zamčené skříň chodba přízemí
        VelkaVec skrinZbrojnice             = new VelkaVec("Skříň", false); // Skříň
        VelkaVec truhlaSkolnik              = new VelkaVec("Truhla", false);
        VelkaVec truhlaZamcenaChodba        = new VelkaVec("Truhla",false);
        VelkaVec kasna                      = new VelkaVec("Kašna", false);
        VelkaVec pracovniStul               = new VelkaVec("Pracovní_stůl", false);
        VelkaVec stojanNaZbrane             = new VelkaVec("Stojan_na_zbraně", false);
        VelkaVec hromadaMrtvol              = new VelkaVec("Hromada_mrtvol", false );
        VelkaVec postel                     = new VelkaVec("Postel", false);
        VelkaVec kuchynskaLinka             = new VelkaVec("Kuchyňská_linka", false);
        VelkaVec sporak                     = new VelkaVec("Sporák", false);
        VelkaVec tabule                     = new VelkaVec("Tabule", false);
        VelkaVec alcbymistickyStul          = new VelkaVec("Alchymistický_stůl", false);
        VelkaVec knihovnaVec                = new VelkaVec("Knihovna", false);
        VelkaVec trenovaciPanak             = new VelkaVec("Trénovací_panák", false);
        VelkaVec zebriny                    = new VelkaVec("Žebřiny", false);
        VelkaVec lanovaDraha                = new VelkaVec("Lanová_dráha", false);
        VelkaVec lezeckaZed                 = new VelkaVec("Lezecká_zeď", false);
        VelkaVec bezeckaDraha               = new VelkaVec("Běžecká_dráha", false);
        VelkaVec jidelniStul                = new VelkaVec("Jídelní_stůl", false);
        VelkaVec pult                       = new VelkaVec("Pult", false);
        VelkaVec kad                        = new VelkaVec("Káď", false);
        VelkaVec truhlaSklad                = new VelkaVec("Truhla", false);
        VelkaVec police                     = new VelkaVec("Police", false);

        /*
         * ###########
         * __Postavy__
         * ###########
         * */
        Postava reditel                     = new Postava("Ředitel", klicZbrojnice,"Zdravím Vás detektive. Doufám, že vás cesta příliš nevyčerpala.\nMezitím co jste byl na cestě se stalo mnohem více vražd, které vypadají podobně jako vraždy před 200 lety.\nZ tohoto důvodu jsme evakuovali celou školu a zústali zde pouze instruktoři, snad vám to usnadní práci.\nPokud se vám nepodaří tento problém vyřešit, asi budeme muset školu zavřít. Poslední tělo které jsme našli bylo na nádvoří, prosím porozhlédněte se tam.");
        Postava skolnik                     = new Postava("Školník", reznickyNuz, "Je, vy nejspíš budete ten nový detektiv. Já jsem zdejší školník a mám na starosti veškerou údržbu,\n především údržbu suterénu, kde se poslední dobou začaly oběvovat podivná mostra.\nAsi to bude těmi vraždami. A ano málem bych zapomněl tohle jsem našel v kuchyni, po té poslední vraždě, myslím že by to mohlo pomoct.");
        Postava vrchniSermir                = new Postava("Vrchní_šermíř", null, "Zdravím vás detektive. Nejspíše budete chtít vědět něco o těch vraždách.\nDobrá pamatuji si tu nejbrutálnější vraždu zde, ta se stala v kuchyni.\nMálem jsme toho lotra chytili ale nedal se zastavit a usekl mi ruku, vůbec tomu nerozumím.\nPříliš jsem nevnímal, ale všiml jsem si jakési krvavé kaluže pod dveřmi do skladu.");
        Postava profesorAlchymie            = new Postava("Profesor_alchymie", klicKnihovna, "Dobrý den, pokud hledáte vědomosti mohu vám půjčit klíče od knihovny. Aha to jste vy!!! No dobrá nevím co vám mám říkat některé případy ano případy tak tomu dnes říkáme byly objeveni naprosto znetvořené a některé dokonce polyté kyselinou. Neumím si to vysvětlit. Tady máte klíč od knihovny.");
        Postava kondicniCvicitel            = new Postava("Kondiční_cvičitel", klicDum, "Detektive už dlouho na vás čekám. Mám tady pro vás klíč ke škloníkovu domu.\nMusím vás varovat školník v poslední době není příliš ve své kůži.\nAsi viděl něco co nikdo jiný z nás.");
        Postava zahradnik                   = new Postava("Zahradník", klicKuchyn, "Zdravím vás detektive.\nVidím, že máte asi ruce plné práce, zajímalo by mě jestli jste pojal u někoho podezření, ale samozřejmě mi to nemusíte říkat.\nTěším se až se případ vyřeší a studenti se vrátí zpátky.\nTady máte klíč od kuchyně, kuchyň je zavřená a člověk nikdy neví co může uzobnout");
        /*
         * #################################
         * ____Vlozeni veci do mistnosti____
         * #################################
         * */

        /*
        Nádvoří
         */
        nadvori.vlozVelkaVec(ker);
            ker.vlozVec(krvaveNuzky);
            ker.vlozVec(dopisNecitelny);
            ker.vlozVec(krvavaLatka);

        nadvori.vlozVelkaVec(lavice);
        nadvori.vlozVelkaVec(kamen);
        nadvori.vlozVelkaVec(kasna);
        nadvori.vlozPostava(zahradnik);

        /*
        Chodbba přízemí
         */
        chodbaPrizemi.vlozVelkaVec(lavice);
        chodbaPrizemi.vlozVelkaVec(trofejovaSkrinZamcena);
            trofejovaSkrinZamcena.vlozVec(poharZlaty);
            trofejovaSkrinZamcena.vlozVec(trofejZlata);
            trofejovaSkrinZamcena.vlozVec(trofejSklenena);
            trofejovaSkrinZamcena.vlozVec(poharStribrny);
        chodbaPatro.vlozVelkaVec(truhlaZamcenaChodba);
            truhlaZamcenaChodba.vlozVec(paklic);
            truhlaZamcenaChodba.vlozVec(stribrnyNahrdelnik);
            truhlaZamcenaChodba.vlozVec(knihaStara);
        /*
        Školníkův dům
         */
        skolnikuvDum.vlozVelkaVec(pracovniStul);
            pracovniStul.vlozVec(klicPaka);
            pracovniStul.vlozVec(klicPoklop);
            pracovniStul.vlozVec(svazekKlicu);
        skolnikuvDum.vlozVelkaVec(truhlaSkolnik);
            truhlaSkolnik.vlozVec(kladivo);
            truhlaSkolnik.vlozVec(pila);
            truhlaSkolnik.vlozVec(tesak);
        skolnikuvDum.vlozVelkaVec(postel);
        skolnikuvDum.vlozPostava(skolnik);

        /*
        Ubikace
         */
        ubikace.vlozVelkaVec(postel);
        ubikace.vlozVec(jablecnyKolac);
        ubikace.vlozVec(jablko);
        ubikace.vlozVec(kureciStehno);
        ubikace.vlozVec(stul);
        ubikace.vlozVec(paklic);

        /*
        zbrojnice
         */
        zbrojnice.vlozVelkaVec(stojanNaZbrane);
            stojanNaZbrane.vlozVec(mec);
            stojanNaZbrane.vlozVec(kopi);
            stojanNaZbrane.vlozVec(naginata);
            stojanNaZbrane.vlozVec(halapartna);
        zbrojnice.vlozVelkaVec(skrinZbrojnice);
            skrinZbrojnice.vlozVec(luk);
            skrinZbrojnice.vlozVec(svitekLedoveKopi);
            skrinZbrojnice.vlozVec(svitekOhnivy);
            skrinZbrojnice.vlozVec(klicCviciste);
         zbrojnice.vlozPostava(vrchniSermir);

        /*
        cviciste
         */
        cvicisteUvnitr.vlozVelkaVec(trenovaciPanak);
        cvicisteUvnitr.vlozVelkaVec(zebriny);
        cvicisteUvnitr.vlozVelkaVec(lezeckaZed);
        cvicisteUvnitr.vlozPostava(kondicniCvicitel);
        /*
        cviciste venku
         */
        cvicisteVnejsi.vlozVelkaVec(trenovaciPanak);
        cvicisteVnejsi.vlozVelkaVec(lanovaDraha);
        cvicisteVnejsi.vlozVelkaVec(bezeckaDraha);
        /*
        Jidelna
         */
        jidelna.vlozVelkaVec(jidelniStul);
        jidelna.vlozVelkaVec(lavice);
        jidelna.vlozVelkaVec(pult);
        jidelna.vlozVec(jablkoPodivne);
        jidelna.vlozVec(hruska);
        /*
        Kuchyn
         */
        kuchyn.vlozVec(klicSklad);
        kuchyn.vlozVelkaVec(sporak);
        kuchyn.vlozVelkaVec(kad);
        kuchyn.vlozVelkaVec(kuchynskaLinka);
        kuchyn.vlozVec(krocan);
        kuchyn.vlozVec(kure);
        /*
        Sklad
         */
        sklad.vlozVelkaVec(police);
        sklad.vlozVelkaVec(truhlaSklad);

        /*
        Chodba patro
         */
        chodbaPatro.vlozVelkaVec(lavice);

        /*
        reditelna
         */
        reditelna.vlozVec(konferencniStul);
        reditelna.vlozVec(kalichStribrny);
        reditelna.vlozVec(ohnivyKalich);
        reditelna.vlozPostava(reditel);

        /*
        Usebna alchymie
         */
        cvicebnaMagie.vlozVec(magickaHul);
        cvicebnaMagie.vlozVelkaVec(alcbymistickyStul);
        cvicebnaMagie.vlozVelkaVec(tabule);
        cvicebnaMagie.vlozVec(kalichZlaty);
        cvicebnaMagie.vlozVec(lahvicka);
        cvicebnaMagie.vlozVec(neznamyLektvar);
        cvicebnaMagie.vlozVec(lecivyLektvar);
        cvicebnaMagie.vlozVec(kyselina);
        cvicebnaMagie.vlozPostava(profesorAlchymie);

        /*
        knihovna
         */
        knihovna.vlozVelkaVec(knihovnaVec);
            knihovnaVec.vlozVec(knihaAlchymie);
            knihovnaVec.vlozVec(knihaPredku);
            knihovnaVec.vlozVec(knihaStara);
            knihovnaVec.vlozVec(knihaStrategie);
        knihovna.vlozVec(stul);
        knihovna.vlozVec(zidle);
        knihovna.vlozVelkaVec(lavice);
        knihovna.vlozVec(skalpel);

        /*
        Tajna mistnost
         */
        tajnaMistnost.vlozVelkaVec(hromadaMrtvol);
            hromadaMrtvol.vlozVec(dopisUsvedcujici);
            hromadaMrtvol.vlozVec(krvaveHrabe);


    }

    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    /**
     * Metoda vrací odkaz na batoh, který má hráč.
     *
     * @return batoh
     */
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     * Metoda vrací odkaz na hráčův notes
     *
     * @return notes
     */
    public Notes getNotes() {
        return notes;
    }

    /**
     * Metoda nastavuje konec hry - výhra
     */
    public void setVyhral() {
        vyhral = true;
    }

    /**
     * Metoda nastavuje konec hry - prohra
     */
    public void setProhral() {
        prohral = true;
    }

    /**
     * Metoda vrací výhru hráče
     *
     * @return true - vyhra
     */
    public boolean getVyhral() {
        return vyhral;
    }

    /**
     * Metoda vrací prohru hráče
     *
     * @return true - prohra
     */
    public boolean getProhral() {
        return prohral;
    }
}
