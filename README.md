# ESA Testing
### Aufgabe 1 + 2
Code: [Aufgabe1_2](./src/main/java/Aufgabe1_2)

Tests: [Aufgabe1_2](./src/test/java/Aufgabe1_2/LinkedListTest.java)

Die Idee um in JUnit etwas reinzukommen ist eine sehr einfache einfach verkettete LinkedList mit den Methoden add(), remove(), getElement()
zu schreiben und zu überlegen, was getestet werden sollte und dies in Tests zu implementieren.

Zuerst muss natürlich überlegt werden, wie das Framework überhaupt in das Projekt integriert werden kann.
Dieser Schritt lief sehr unkompliziert ab, da ich das Build Tool Gradle verwendet habe.
Hier wird mit dem Befehl *gradle intit* die gesamte Projektstruktur erstellt und praktischerweise JUnit automatisch
unter den Dependencies integriert. Das heißt nach Ausführung des initialen Build Scripts war das JUnit Framework
bereits nutzbar.

Als erstes soll die *add()* Methode getestet werden. Diese ist der Einfachheit halber als *addBack()* implementiert.
Es kann in dieser Implementierung also nur hinten an die Liste angehängt werden.
Mit einer Methode kann erstmal nur relativ wenig getestet werden:
- kann ein Element an den Kopf gehängt werden
- können mehrere Elemente hinzugefügt werden
- können auch negative Zahlen angehängt werden

Hier fand ich tatsächlich schon den ersten Fehler in meiner Implementation, und zwar wurden blöderweise alle neuen 
Elemente an den head gehängt und haben ihn überschrieben. Die Liste konnte also nie mehr als ein Element beinhalten.
Nachdem das Problem gefixt war, konnte es mit den interessanteren Tests weitergehen.

Als nächstes soll die remove() Methode getestet werden, die als removeFirst() Methode implementiert wurde
(das erste gefundene Element soll also entfernt werden). Zuerst können natürlich die offensichtlichen Tests
implementiert werden:
- kann ein Element hinzugefügt werden und wieder entfernt werden (die Länge sollte anschließend wieder 0 sein und der head null)
- können mehrere Elemente entfernt werden (vorne, hinten, mittlere)

Zudem sind mir noch drei Tests eingefallen, auf die man vielleicht nicht sofort kommt:
- was passiert wenn die remove Methode aufgerufen wird und die Liste leer ist
- was passiert wenn ein Element gelöscht werden soll, welches nicht in der Liste vorhanden ist
- wird auch wirklich nur das erste Element entfernt, wenn mehrere gleiche Elemente vorhanden sind

Auch hier sind ein paar Fehler in der Implementation aufgefallen. Beispielsweise gab es Probleme, wenn die
next-Referenz des vorherigen Elementes auf das nächste Element des zu löschenden Elements gestzt werden sollte.
Hier habe ich ziemlich schnell die Vorteile von Tests erkannt, da ich die *add()* Methode ändern konnte und mit
sehr großer Sicherheit sagen konnte, dass sie immer noch das macht was sie sollte, da ich einfach die vorher
definierten Tests laufen lassen konnte.

Zu guter Letzt wird nun die *getElement()* Methode getestet. Diese gibt das Element an dem spezifizierten Index zurück.

Hier wird natürlich auch getestet ob tatsächlich die richtigen Elemente zurückgegeben werden (vorne, mitte, hinten)
Diese Methode kann nun aber auch in folgenden Fällen eine Exception werfen:
- Der angegebene Index ist negativ
- Der angegebene Index ist größer als der Index des letzten Elements
- Die Liste ist leer

Auch für all diese Szenarien wurden Tests implementiert.

Nachdem vor den Tests dieser Methode nur die Asserts assertEquals() und assertNull() verwendet wurden, die ja recht
simpel zu nutzen sind, verlief es mit assertThrows() doch ein wenig holpriger. Mir war vor allem mit dem Blick auf die
Dokumentation unklar, wann die zu testende Methode aufgerufen werden soll und wie die genaue Exception angegeben werden
soll. Mit einem Beipsiel wurde aber schnell klar, dass die Exception natürlich mit dem .class Attribut angegeben werden
kann und man die zu testende Methode logischerweise als Lamda Ausdruck übergeben wird.

### Aufgabe 3

Code: [Aufgabe3](./src/main/java/Aufgabe3/Verlag.java)

Tests: [Aufgabe3](./src/test/java/Aufgabe3/VerlagTest.java)

Beim Test-Driven-Development war der Anfang etwas langsam, da es eine etwas andere Herangehensweise an die Entwicklung erfordert.
Mir wurde dann aber relativ schnell klar, dass man hierbei nicht wie man es gewohnt ist lösungsdenkend, sondern eher
problemdenkend arbeiten muss. Das heißt man überlegt sich erst, was alles schief gehen könnte und überlegt sich
anschließend erst wie man das Ganze implementieren kann.
Nachdem die Idee verstanden war, waren die Tests eigentlich sehr schnell implementiert. Auch die LLMs
können hier sehr gute Inspirationen liefern. Allerdings würde ich besonders bei komplexeren Problemen diese
nicht mehr verwenden, da es sehr schwer ist ohne eine tatsächliche Implementierung zu erklären, was der zu Testende
Teil machen soll (die menschliche Sprache ist sehr ungenau verglichen zu Programmiersprachen).Nachdem die Tests geschrieben waren, war die Methode auch sehr schnell implementiert.

Im Großen und Ganzen finde ich diesen Ansatz sehr interessant und werde sicherlich versuchen ihn in Zukunft auch in der
Praxis anzuwenden (vielleicht aber eher bei etwas komplexeren Methoden). Die Probleme, die ich sehe, sind, dass
auch Tests falsch implementiert sein können, was unter Umständen nicht sofort bemerkt wird und dadurch
einiges an Zeit kosten könnte und dass sich die Anforderungen an die Methoden während der Entwicklung auch verändern 
können und dadurch viele der Tests neu geschrieben werden müssen.

### Aufgabe 4

Code: [Aufgabe4](./src/main/java/Aufgabe4)

Tests: [Aufgabe4](./src/test/java/Aufgabe4/LinkedListTest.java)

Bei dieser Aufgabe hatte ich anfänglich etwas Schwierigkeiten. Für mich war die Idee des Erstellens von Mock Objekten 
zwar klar, allerdings hatte ich keine klare Vorstellung davon, in welchen Fällen es Anwendung finden könnte. Es 
fiel mir also etwas schwer ein passendes Beispiel zu finden.
Nach etwas Überlegungszeit ist mir aber klar geworden, dass der Ansatz immer dann verwendet werden kann, wenn ein 
Methodenaufruf stattfindet, bei dem im Hintergrund vieles passiert (wie Datenbankaufrufe, API-Calls, etc.) und dadurch die Simulation im Test sehr aufwändig wäre. 
Außerdem sollen die Hintergrundaktivitäten auch gar nicht getestet werden, 
sondern die Logik, die in der zu testenden Methode implementiert wurde.

Als kleines Übungsbeispiel habe ich dann die von mir erstellte LinkedList verwendet und zwei Methoden (sum(), average()) 
hinzugefügt.
Die *sum()* Methode ist nicht implementiert (gibt immer 0 zurück). Diese soll rausgemockt werden. Die *average()* Methode nutzt
die *sum()* Methode um die Summe aller Zahlen in der Liste asuzurechnen und teilt sie dann durch die Länge der Liste, um den 
Durchschnittswert zu erhalten.

Um nun Mockito in meinen Test einzubauen, muss das Package erst zu den Gradle dependencies hinzugefügt und importiert werden.
Hier gab es Anfangs echte Probleme, da wahrscheinlich die Mockito Version nicht mit der JUnit Version kompatibel war.
Hier habe ich einige Zeit herumprobiert und letzendlich die Dependencies aus einem anderen Gradle Projekt auf GitHub kopiert
und alles neu installiert. Damit hat es dann endlich geklappt.
Anschließend habe ich den Mockito Teil aus dem Beispiel in der Aufgabenstellung übernommen. Das hat vorerst nicht funktioniert,
da das Mock Objekt welches von der *mock* Methode zurückgegeben wird nicht die Methoden der bereitgestellten Klasse übernimmt,
sondern alle Methoden
alle gemockt werden müssen. Nach einiger Zeit auf Fehlersuche habe ich dann endlich rausgefunden, dass die Methode *spy*
alle Methoden übernimmt und damit genau das macht, was ich brauche.

### Aufgabe 5

Für IntelliJ gibt es ein sehr schönes Plugin, das einen HTML Code-Coverage Bericht erstellt.
Der Bericht für die LinkedList aus Aufgabe 1 und 2 ist hier zu sehen: [Report](./htmlReport/ns-1/sources/source-2.html)

Hier wird angezeigt welche Zeilen des Codes während der Tests ausgeführt wurden. Die einzige Zeile, die in diesem Beispiel rot hinterlegt ist und damit 
nie ausgeführt wurde, ist die Letzte in der *getElement()* Methode. Diese soll aber auch nie ausgeführt werden und existiert 
nur um den Compiler zufriedenzustellen. Die for-Schleife vorher ist gelb hintgerlegt, was bedeutet, das sie nur teilweise ausgeführt
wurde. Das ist auch darauf zurückzuführen, dass sie gar nicht komplett ausgeführt werden kann, sondern immer frühzeitg ein 
Element zurückgibt. Sie macht also auch genau das was sie soll.