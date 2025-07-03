In dieser Woche fügen Sie letzte Änderungen ein, um eine komplette MIDI-Software zu erstellen: Sie implementieren das Einlesen einer Melodie aus einer Textdatei sowie das Schreiben einer fertigen MIDI-Datei.

# Aufgabe 1

In der Datei stehen die Metadaten und die Noten separat (siehe Beispieldaten "melody.txt"). Diese Daten auseinanderzudröseln sollte nicht die Aufgabe des `MIDITrack` sein, sondern vom `MIDIFile` erledigt werden.

Passen Sie entsprechend zunächst den Constructor von `MIDITrack` so an, dass er anstatt eines einzelnen Strings mit allen Informationen drei separate Argumente kriegt. Die Argumente des Constructors sollen `String melody, byte fullNoteDuration, byte defaultVelocity, String instrument` sein. 

# Aufgabe 2

Es kann sein, dass jemand einen Fehler bei der Definition des Instrumentes macht und einen Instrumentennamen angibt, der nicht im MIDI-Standard definiert ist. In einem solchen Fall kann der `MIDITrack` nicht sinnvoll erstellt werden und der Constructor sollte eine `Exception` werfen, mit dem folgenden Text als message: "Unbekanntes Instrument '<als String instrument übergebener Instrumentenname>'". Passen Sie den Constructor von `MIDITrack` entsprechend an.

# Aufgabe 3

Passen Sie nun den Constructor der Klasse `MIDIFile` so an, dass er nur noch den Namen einer Textdatei als `String` bekommt. Ein Beispiel für eine korrekte Datei ist die Datei "melody.txt" im repository: Die Datei beginnt mit mehreren Zeilen, die einen Doppelpunkt enthalten und die entsprechenden Metadaten (Geschwindigkeit, Dauer einer ganzen Note, Standard-velocity, Name des Instruments) definieren. Danach kommen beliebig viele Zeilen mit Noten, die jeweils mit Leerzeichen voneinander getrennt sind. Der Constructor von `MIDIFile` soll aus der Datei diese Informationen auslesen und den dazu passenden `MIDITrack` erstellen.

# Aufgabe 4

Falls die Datei fehlerhafte Metadaten enthält, soll der Constructor von `MIDIFile` entsprechende `Exception`s werfen. Für die einzelnen möglichen Fehler sollten dies die messages sein:
* Angabe "Speed: " fehlt: "Fehler in Datei <Dateiname>: 'Speed: x' muss angegeben sein, mit x != 0."
* Angabe "Full note duration: " fehlt: "Fehler in Datei <Dateiname>: 'Full note duration: x' muss angegeben sein, mit x != 0."
* Angabe "Velocity: " fehlt: "Fehler in Datei <Dateiname>: 'Velocity: x' muss angegeben sein, mit x != 0."
* Angabe "Instrument: " fehlt: "Fehler in Datei <Dateiname>: 'Instrument: x' muss angegeben sein."
* Fehlerhaftes Instrument angegeben: "Fehler in Datei <Dateiname>: <Fehlermeldung aus der Exception, die MIDITrack wirft>"
* Dateiname einer Datei angegeben, die nicht existiert: "Fehler beim Einlesen der Datei <Dateiname>."

Für die einzelnen Fehler finden Sie im repository entsprechende .txt-Dateien.

# Aufgabe 5

Implementieren Sie abschließend in `MIDIFile` eine Methode `public void writeMIDIFile(String filename) throws Exception`, welche die Daten aus dem `MIDIFile` (die Bytes, die `getBytes()` zurückgibt) in die Datei mit dem übergebenen Dateinamen schreibt. Falls dabei irgendeine `IOException` auftritt, soll eine eigene `Exception` mit der message "Fehler beim Schreiben in Datei <Dateiname>." geworfen werden.

Falls Sie nicht weiterwissen, können Sie in `Main` in den Aufgabenstellungen der letzten Wochen nachschauen, eine vergleichbare Methode habe ich dort jeweils bereitgestellt.

Herzlichen Glückwunsch, Sie haben jetzt (mit der Minimal-`Main`-Klasse, die ich wieder als Beispiel mit bereitstelle) ein Programm entwickelt, welches eine beliebige Melodie aus einer Datei einlesen und in eine abspielbare MIDI-Datei umwandeln kann!