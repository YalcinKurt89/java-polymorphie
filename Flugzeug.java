/* Diese Klasse ist die Basisklasse für alle Flugzeugtypen. 
Sie enthält ein Attribut typ, das den Typ des Flugzeugs speichert, 
und eine Methode landen(), die eine allgemeine Meldung für die 
Landung eines Flugzeugs ausgibt.
*/

public class Flugzeug {


    protected String typ;


    public Flugzeug(String typ) {
        this.typ = typ;
    }


/*  Die landen() Methode gibt eine allgemeine Meldung aus, 
    wenn das Flugzeug landet.
*/
    public String landen() {
        return "Das Flugzeug des Typs " + typ + " landet.";
    }
}