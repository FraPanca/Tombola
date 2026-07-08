# Tombola

## Italiano

Il gioco della Tombola (l'estrazione di numeri stile "bingo" italiano) con interfaccia grafica JavaFX, sviluppato con pattern architetturale Model-View-Controller.

**Stack:** Java · JavaFX

### Descrizione

Applicazione desktop che replica l'estrazione dei numeri della Tombola italiana: a ogni estrazione viene generato un numero casuale univoco tra 1 e 90 (senza ripetizioni), mostrato a schermo insieme al "cartellone" con tutti i numeri e quelli già estratti evidenziati, e al conteggio dei numeri rimanenti. È possibile riavviare la partita in qualsiasi momento tramite un dialog di conferma.

### Come si esegue

Richiede il JDK e l'SDK di JavaFX (non incluso nel JDK a partire dalla versione 11).

Compilazione dalla cartella principale del repository:
```
javac --module-path <percorso-javafx-sdk>/lib --add-modules javafx.controls model/Tombola.java controller/Controller.java ui/TombolaApp.java ui/MainPane.java
```

Esecuzione (sempre dalla cartella principale del repository, in modo che `icon.png` venga trovata):
```
java --module-path <percorso-javafx-sdk>/lib --add-modules javafx.controls -cp . ui.TombolaApp
```

### Funzionalità principali

- Estrazione di numeri casuali univoci da 1 a 90, senza ripetizioni fino a esaurimento
- Visualizzazione del cartellone con tutti i 90 numeri, evidenziando con "O" quelli già estratti
- Contatore dei numeri rimanenti, aggiornato a ogni estrazione
- Riavvio della partita con dialog di conferma, per evitare reset accidentali
- Alert dedicato quando tutti i 90 numeri sono stati estratti
- Architettura MVC: logica di estrazione separata dalla view (JavaFX) e dal controller che coordina le due parti e gestisce i dialoghi

### Struttura del progetto

```
Tombola/
├── model/
│   └── Tombola.java         # Logica di estrazione dei numeri (Model)
├── controller/
│   └── Controller.java      # Coordinamento tra model e UI, gestione dei dialoghi (Controller)
├── ui/
│   ├── TombolaApp.java      # Entry point dell'applicazione JavaFX
│   └── MainPane.java        # Interfaccia grafica principale (View)
└── icon.png                  # Icona della finestra dell'applicazione
```

### Licenza

MIT

---

## English

The Italian "Tombola" number-drawing game (similar to bingo), with a JavaFX graphical interface, developed using the Model-View-Controller architectural pattern.

**Stack:** Java · JavaFX

### Description

Desktop application that replicates the Italian Tombola number draw: each draw generates a unique random number between 1 and 90 (no repeats), shown on screen together with the scoreboard listing all numbers and highlighting the ones already drawn, plus a counter of remaining numbers. The game can be restarted at any time via a confirmation dialog.

### How to run

Requires the JDK and the JavaFX SDK (not bundled with the JDK from version 11 onward).

Compile from the repository root:
```
javac --module-path <javafx-sdk-path>/lib --add-modules javafx.controls model/Tombola.java controller/Controller.java ui/TombolaApp.java ui/MainPane.java
```

Run (also from the repository root, so that `icon.png` can be found):
```
java --module-path <javafx-sdk-path>/lib --add-modules javafx.controls -cp . ui.TombolaApp
```

### Key features

- Drawing of unique random numbers from 1 to 90, with no repeats until exhausted
- Scoreboard display of all 90 numbers, highlighting drawn numbers with "O"
- Counter of remaining numbers, updated after each draw
- Game restart with a confirmation dialog, to prevent accidental resets
- Dedicated alert when all 90 numbers have been drawn
- MVC architecture: number-drawing logic separated from the JavaFX view and from the controller that coordinates the two and handles dialogs

### Project structure

```
Tombola/
├── model/
│   └── Tombola.java         # Number-drawing logic (Model)
├── controller/
│   └── Controller.java      # Coordinates model and UI, handles dialogs (Controller)
├── ui/
│   ├── TombolaApp.java      # JavaFX application entry point
│   └── MainPane.java        # Main graphical interface (View)
└── icon.png                  # Application window icon
```

### License

MIT
