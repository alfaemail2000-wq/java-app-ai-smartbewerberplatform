1. Bewertung & Speicherung neuer Bewerber (BewerberBewertenSpeichernJSON)

    Starte mehrfach die Klasse BewerberBewertenSpeichernJSON im main() unter /tests.

    Jeder Bewerber, der als „**********-Successfulbewerber-*********“ erkannt wird,
    wird automatisch in bewerber.json gespeichert.

    Dabei wird eine eindeutige ID vergeben.

    Die Datei bewerber.json enthält somit alle erfolgreichen Bewerberdaten zur Weiterverarbeitung.

2. Bewerber-Verwaltung & Visualisierung (Frontend GUI – FrontEndGui)

    Wenn bewerber.json bereits Daten enthält:

        Starte FrontEndGui (src/de/frontend/appGui/FrontEndGui.java).

    Mit der grafischen Oberfläche kannst du:

        Alle gespeicherten Bewerber anzeigen,

        Bewerber nach passenden Jobs filtern,

        Bewerber nach Erfolgschancen (Machine Learning Prognose) bewerten,

        Bewerber direkt löschen oder analysieren.

3. JSON API Server & Client

    Der Server stellt eine REST-API bereit, um Bewerberdaten im JSON-Format bereitzustellen.

    Clients oder Browser können per GET-Request auf die JSON-Daten zugreifen.

    Nützlich für externe Anwendungen oder Schnittstellen zur Bewerbervisualisierung.

    http://localhost:6767/api/bewerber/?id=2