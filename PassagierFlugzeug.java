/* Diese Klasse erbt von Flugzeug und fügt ein zusätzliches
    Attribut passagierAnzahl hinzu, um die Anzahl der Passagiere zu speichern. 
    Die landen()-Methode wird hier überschrieben, um eine spezielle
    Meldung für Passagierflugzeuge mit der Anzahl der Passagiere auszugeben.
*/

class PassagierFlugzeug extends Flugzeug {


    private int passagierAnzahl;


    public PassagierFlugzeug(String typ, int passagierAnzahl) {
        super(typ);
        this.passagierAnzahl = passagierAnzahl;
    }


/*  Die landen() Methode wird hier überschrieben, um eine spezielle 
    Meldung für Passagierflugzeuge auszugeben.
*/
    @Override
    public String landen() {
        return "Das Passagierflugzeug des Typs " + typ + " mit " + passagierAnzahl + " Passagieren landet.";
    }
}