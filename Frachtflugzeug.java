/* Diese Klasse erbt ebenfalls von Flugzeug und fügt ein
zusätzliches Attribut ladungGewicht hinzu, um das Gewicht 
der Frachtladung zu speichern. Die landen()-Methode wird 
hier überschrieben, um eine spezielle Meldung für Frachtflugzeuge 
mit dem Gewicht der Ladung auszugeben.
*/

class FrachtFlugzeug extends Flugzeug {


    private double ladungGewicht;


    public FrachtFlugzeug(String typ, double ladungGewicht) {
        super(typ);
        this.ladungGewicht = ladungGewicht;
    }


/*  Die landen() Methode wird hier überschrieben, um eine spezielle 
    Meldung für Frachtflugzeuge auszugeben.
*/
    @Override
    public String landen() {
        return "Das Frachtflugzeug des Typs " + typ + " mit einer Ladung von " + ladungGewicht + " Tonnen landet.";
    }
}