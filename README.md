# MiFID kérdőív felvevő rendszer

[![security status](https://qa.meterian.com/badge/gh/NiciFranchi/MiFID/security)](https://qa.meterian.com/report/gh/NiciFranchi/MiFID)
[![stability status](https://qa.meterian.com/badge/gh/NiciFranchi/MiFID/stability)](https://qa.meterian.com/report/gh/NiciFranchi/MiFID)

##1.	Bevezetés
<p>
Napjainkban elengedhetetlen, hogy az emberek számára bármilyen tevékenység esetén elegendő információ álljon rendelkezésre, ugyanis csak ilyenkor hozhatnak racionális döntéseket. Ennek ellenőrzésének remek eszköze a megfelelési tesztek használata, ami ennek a dokumentumnak is a témája. Munkám során egy ilyen rendszer alapjait kezdtem el megtervezni és megvalósítani. Az ilyen megfelelési teszteket legkönnyebben kérdőív formájában lehet elképzelni. Munkám során fontos célkitűzés volt, hogy a rendszer minél 
inkább testreszabható legyen.
</p>
##1.1.	A MiFID (Markets in Financial Instruments Directive) irányelv
<p>
A MiFID a pénzügyi eszközök piacaira vonatkozó irányelv. Ez egy olyan nagy horderejű jogszabály, amely az európai befektetési szolgáltatásokat és pénzügyi piacokat lefedő átfogó szabályozó rendszert dolgoz ki.
</p>
<p>
Olyan intézkedéseket tartalmaz, amelyek célja a befektetési vállalkozások szervezetének és működésének megváltoztatása és javítása. Célul tűzte ki, hogy a befektetési vállalkozások és ügyfeleik közötti kapcsolatot átfogó szabályozással erős befektetői védelmet biztosítson. Magyarországon 2007. december 1-én lépett hatályba.
Az ügyfélvédelem pedig azt jelenti, hogy a vállalkozásoknak az ügyfélmegbízások végrehajtása során minden tőlük telhetőt meg kell tenniük annak érdekében, hogy ügyfeleik számára a lehető legkedvezőbb eredményt érjék el, számos tényező, mint pl. a pénzügyi eszköz ára, a megbízás teljesítésének gyorsasága, valamint a járulékos költségek, figyelembevétele mellett. A MiFID irányelvekből kettőt különböztetünk meg, az elsőt, ami 2007-ben lépett hatályba és a másodikat, ami pedig 2017 januárjában fog.
</p>
<p>
A MiFID I is megköveteli, hogy befektetési tanácsadás vagy portfóliókezelési szolgáltatás nyújtásakor a befektetési vállalkozás mérje fel az ügyfél ismeretét, tapasztalatait, pénzügyi helyzetét és befektetési céljait annak érdekében, hogy az ügyfél számára alkalmas befektetési szolgáltatásokat, illetve pénzügyi eszközöket ajánlhasson.
</p>
<p>
A MiFID II számottevő változást nem vezet be, ugyanakkor a korábbi rendelkezéseket néhány ponton kibővíti. Egyfelől, a befektetési tanácsadás vagy portfóliókezelési szolgáltatás nyújtásakor a vállalkozásnak az ügyfél veszteségviselési és kockázattűrési képességéről is információkat kell szereznie, másrészt az ügylet megvalósítását megelőzően írásbeli megfelelőségi nyilatkozatot kell adnia a terméknek az ügyfél számára való megfelelőségéről.
</p>
<p>
Mint az látható, az egyes pénzintézeteknek folyamatosan kell igazodnia az ilyen irányelvekhez. Hosszú távon nem tartható, hogy ha az egyes rendszerekbe beleégetik az ilyen megfelelési teszteket és az ügyféladatokat külön tárolják. Ugyanis így nagyobb költségeik lehetnek az egyes modulok külön fejlesztése során, és az információ is lassabban fog áramolni a vállalaton belül. Így felmerül az igény egy olyan rendszerre, ahol bármilyen kérdőívet össze lehet állítani és azokat termékekhez rendelni. A kérdésekre adott válaszok alapján pedig a kitöltő ügyfél megfelelését lehet értékelni. Ezt valamilyen pontozó rendszerrel lehet elképzelni, ami az egyes válaszlehetőségekhez pontokat rendel, és az alapján történik a kiértékelés.
</p>
##1.2.	A megfelelési teszt alapja
<p>
A megfelelési tesztek alapjának egy kérdőív rendszert képzelek el, ahol az adott kérdőívek termékekhez vannak rendelve, amire vonatkoznak. A kitöltőnek pedig azt a kérdőívet kell kitöltenie, amilyen terméket vagy szolgáltatást szeretne igénybe venni. Majd miután kitöltötte a kérdőívet, mind az ügyfél, mind a szolgáltatás kibocsátója világos képet kap arról, hogy az ügyfél megfelelt-e a teszten. Az ilyen adatokat el lehet tárolni és később újra felhasználni.
Egy ilyen rendszer tehát annyival több egy általános kérdőív kitöltő rendszernél, hogy nem csupán statisztikai célja van a kérdőíveknek, hanem a megfeleltséget is lehet vizsgálni azáltal, hogy az egyes válaszokhoz pontokat rendelünk. A kérdőívekhez pedig egy minimális ponthatárt, amit a kitöltőnek el kell érnie, ha meg akar felelni a teszten.
</p>
<p>
Egy ilyen kérdőívvel az ügyfél több felületen/módon is találkozhat. Egyrészt saját maga is kitöltheti, ha ellátogat az adott bank vagy hitelintézet weboldalára. Másrészt pedig egy telefonos (call-centeres) munkatárs vagy egy bankfióki kezelő segítségével közvetetten is lehetősége lehet az adott kérdőívet kitölteni. Ezek mind különböző rendszert alkothatnak különböző felülettel, de a mögöttes rendszer, ahonnan a kérdőívek és termékek adatait veszik, lehet közös.
</p>
<p>
A kérdőív rendszer legfontosabb része a kérdőív felvevő, ahol lehetőség van a termékek felvételére is, majd ezek összerendelésére. Egy ilyen rendszerbe tetszőleges számú kérdőív vehető fel, tetszőleges számú kérdéssel, és azokra válaszokkal. Minden egyes válaszhoz megadható egy pontszám, ami az adott válasz értékét mutatja. A kérdőívhez szintén megadható egy minimális pontszám, ami azt jelzi, hogy az adott kérdőív esetén mennyi pontot kell ahhoz elérni, hogy megfeleljen a kitöltő.
</p>
<p>
Ez úgy képzelhető el, hogyha azt akarjuk elérni, hogy egy kérdésre csak az a) választ akarjuk elfogadni, akkor a b) és c) kérdésre valamilyen nagyon nagy mínusz értéket kell felvenni, így mindenképpen elutasítás lesz a kérdőív eredménye. Ugyanis a rendszer úgy működik, hogy az összes kérdésre adott válaszokhoz tartozó pontszámokat összegzi.
A kérdőívek felvétele során előnézeti kép segíti a felhasználót a megfelelő kérdőív összeállításában. Itt ki is próbálhatja, hogy az adott válaszkombinációkkal az ügyfél megfelelőnek bizonyult volna-e.
</p>
