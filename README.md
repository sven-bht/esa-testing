# ESA Testing
## Aufgabe 1 + 2
Code: [Aufgabe1_2](./src/main/java/Aufgabe1_2)

Tests: [Aufgabe1_2](./src/test/java/Aufgabe1_2/LinkedListTest.java)

Die Idee um in JUnit etwas reinzukommen ist eine sehr einfache einfach verkettete LinkedList mit den Methoden add(), remove(), getElement()
zu schreiben und zu überlegen, was getestet werden sollte und dies in Tests zu implementieren.

Zuerst muss natürlich überlegt werden, wie das Framework überhaupt in das Projekt integriert werden kann.
Dieser Schritt lief sehr unkompliziert ab, da ich das Build Tool Gradle verwendet habe.
Hier wird mit dem Befehl *gradle intit* die gesamte Prjektstruktur erstellt und praktischerweise JUnit automatisch
unter den Dependencies integriert. Das heißt nach Ausführung des initialen Build Scripts war das JUnit Framework
bereits nutzbar.

Als erstes soll die add() Methode getestet werden. Diese ist der Einfachheit halber als addBack() implementiert.
Es kann in dieser Implementierung also nur hinten an die Liste angehängt werden.
Mit einer Methode kann erstmal nur relativ wenig getestet werden:
- kann ein Element an den Kopf gehängt werden
- können mehrere Elemente hinzigefügt werden
- können auch negative Zahlen angehängt werden

Hier fand ich tatsächlich schon den ersten Fehler in meiner Implementation, und zwar wurden blöderweise alle neuen 
Elemente an den head gehängt und haben ihn überschrieben. Die Liste konnte also nie mehr als ein Element beinhalten.
Nachdem das Problem gefixt war konnte es mit den interessanteren Tests weitergehn.

Als nächstes soll die remove() Methode getestet werden, die als removeFirst() Methode implementiert wurde
(das erste gefundene Element soll also entfernt werden). Zuerst können natürlich die offensichtlichen Tests
implementiert werden:
- kann ein Element entfernt werden und wieder entfernt werden (die Länge sollte anschließend wieder 0 sein und der head null)
- können mehrere Elemente entfernt werden (vorne, hinten, mittlere)

Zudem sind mir noch drei Tests eingefallen, auf die man vielleicht nicht sofort kommt:
- was passiert wenn die remove Methode aufgerufen wird und die Liste leer ist
- was passiert wenn ein Element gelöscht werden soll, welches nicht in der Liste vorhanden ist
- wird auch wirklich nur das erste Element entfernt wenn mehrere gleiche Elemente vorhanden sind

Auch hier sind ein paar Fehler in der Implementation aufgefallen. Beispielsweise gab es ein wenig Probleme mit die
next-Referenz des vorherigen Elementes auf das nächste Element des zu löschenden Elements zu setzen.
Hier habe ich schon ziemlich schnell die Vorteile von Tests erkannt, da ich die add() Methode ändern konnte und mit
sehr großer Sicherheit sagen konnte, dass sie immer noch das macht was sie sollte, da ich einfach die vorher
definierten Tests nutzen konnte.

Zu guter Letzt wird nun die getElement() Methode getestet. Diese gibt das Element an dem spezifizierten Index zurück.

Hier wird natürlich auch getestet ob tatsächlich die richtigen Elemente zurückgegeben werden (vorne, mitte, hinten)
Diese Methode kann nun aber auch eine Exception werfen in folgenden Fällen:
- Der angegebene Index ist negativ
- Der angegebene Index ist größer als der Index des letzten Elements
- Die Liste ist leer

Auch für all diese Szenarien wurden Tests implementiert.

Nachdem vor den Tests dieser Methode nur die Asserts assertEquals() und assertNull() verwendet wurden, die ja recht
simpel zu nutzen sind, verlief es mit assertThrows() doch ein wenig holpriger. Mir war vor allem mit dem Blick auf die
Dokumentation unklar, wann die zu testende Methode aufgerufen werden soll und wie die genaue Exception angegeben werden
soll. Mit einem Beipsiel wurde aber schnell klar, dass die Exception natürlich mit dem .class Attribut angegeben werden
kann und man die zu testende Methode logischerweise als Lamda Ausdruck übergeben kann.