## O hře

Tento malý projekt byl inspirován mojí vlastní advtenturou ve hře **Dungeons and Dragons** 
Také se jedná o semestrální projek na předmět Java (4IT101). 

Úkol hry je nalézt vraha.


## Jak začít?

1. Ujistěte se, že máte nainstalovanou aktuální verzi Javy
    1. to lze zjistit tímto příkazem, který lze použiz v příkazové řádce ``java -version``
        1. Pokud se nic nevypíše je potřeba Javu nainstalovat [zde](https://java.com/en/download/)
1. Otevřete příkazový řádek a navigujte se do adresáře kde se nachází _StarWars.jar_  (/JavaGame/out/artifacts/JavaGame_Jar/).
1. Napište příkaz ``java -jar StarWars.jar`` a užijte si hru

## Jak hrát

Hra začíná uvítací hláškou a základními informacemi

Toto se vám vyobrazí v UI, které můžete vidět níže.
![UI_Start](/UI.png)

Každá příkaz je prováděn po stisknutí klávesy **ENTER** pokud příkaz vyžaduje více parametrů aplikace vypíše do konzole chybovou hlášku "Bylo zadáno příliš mnoho parametrů"

### Mapa a prostředí

Prostředí obsahuje tři patra přízemí, patro a suterén.

Patra, jednotlivé místnosti a propojení mezi místnostmi je vyobrazeno na následujícím diagramu.
![Map](/Map.png)

### Napoveda a konec

Pro zobrazení nápovědy stačí snadno napsat příkaz ``nápověda``
Pokud chcete ukončit hru stačí napsat příkaz ``konec``

#### Ostatní příkazy
1. příkaz Mluv
    1. příkaz vyžaduje jeden parametr a tím je název osoby se kterou chce postava mluvit.
    1. ``mluv jmeno_postavy``
1. příkaz Batoh
    1. pžíkaz nevyžaduje parametry a vypisuje obsah batohu
    1. ``batoh``
1. příkaz Jdi
    1. příkaz požaduje jeden parametr. Směr, kterým chce hráč jít.
    1. ``jdi smer``
1. příkaz Konec (Příkaz je již zmíněný v kapitole **Napoveda a konec**)
    1. ``konec``
1. příkaz Napoveda (Příkaz je již zmíněný v kapitole **Napoveda a konec**)
    1. ``napoveda``
1. příkaz Notes
    1. příkaz nevyžaduje parametry a vypíše obsah notesu (vypíše všechny dialogy)
    1. ``notes``
1. příkaz Odemkni (odemiká místnost)
    1. příkaz odemkne místnost, pokud háč má v batohu klíč potřebný k odemčení místnosti v opačném případě je vypsáná chybová hláška.
    1. ``odemkni nazev_prostoru``
1. příkaz Odhod 
    1. příkaz vyžaduje název **Věci**, kterou chce hráč vyhodit z batohu
    1. ``odhod jmeno_veci``
1. příkaz Prohledej
    1. příkaz vyžaduje název **Velké věci** kterou chce hráč prohledat
    1. ``prohledej jmeno_velke_veci``
1. příkaz Rozhledni
    1. příkaz vypíše informace o místnosti a nevyžaduje parametry.
    1. ``rozhledni``
1. příkaz Seber
    1. dávejte si pozor na to, že **Batoh má pouze 6 slotů**
    1. příkaz vyžaduje název **Věci** v současném prostoru, kterou chce hráč sebrat
    1. ``seber jmeno_veci``
1. příkaz Zatkni
    1. příkaz vyžaduje jméno **Postavy**, kterou chce hráč zatknout
    1. pokud je tento příkaz použit na špatnou postavu způsobí to konec hry a prohru
    1. ``zatkni jmeno_postavy``
