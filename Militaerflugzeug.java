/* Diese Klasse erbt von Flugzeug und fügt ein zusätzliches 
Attribut munition hinzu, um die mitgeführte Munition zu speichern. 
Die landen()-Methode wird hier überschrieben, um eine spezielle Meldung 
für Militärflugzeuge mit der Anzahl der mitgeführten Munition auszugeben.
*/

class MilitaerFlugzeug extends Flugzeug {


    private int munition;


    public MilitaerFlugzeug(String typ, int munition) {
        super(typ);
        this.munition = munition;
    }


/*  Die landen() Methode wird hier überschrieben, um eine spezielle 
    Meldung für Militärflugzeuge auszugeben.
*/
    @Override
    public String landen() {
        return "Das Militärflugzeug des Typs " + typ + " mit " + munition + " Munition landet.";
    }
}