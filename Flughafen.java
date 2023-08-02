import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Flughafen extends JFrame {

    
    private JComboBox<String> flugzeugComboBox;
    private JTextArea ausgabeTextArea;

    public Flughafen() {
        setTitle("Flughafen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);


// Flugzeugtypen für die ComboBox hinzufügen
        String[] flugzeugTypen = {"Standard-Flugzeug", "Passagierflugzeug", "Frachtflugzeug", "Militärflugzeug"};
        flugzeugComboBox = new JComboBox<>(flugzeugTypen);


// Ausgabe-TextArea
        ausgabeTextArea = new JTextArea();
        ausgabeTextArea.setEditable(false);


// Button
        JButton anzeigenButton = new JButton("Anzeigen");
        anzeigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeigeFlugzeugLandung();
            }
        });


// Layout
        setLayout(new BorderLayout()); // Hier wird das Layout des JFrame auf BorderLayout gesetzt. BorderLayout ist ein Layout-Manager, der Komponenten in fünf Bereichen anordnet: Norden (NORTH), Süden (SOUTH), Westen (WEST), Osten (EAST) und Zentrum (CENTER).
        JPanel obenPanel = new JPanel(new FlowLayout()); //  Es wird ein neues JPanel mit FlowLayout erstellt und in der Variable "obenPanel" gespeichert. FlowLayout ist ein Layout-Manager, der Komponenten in einer Zeile oder einer Spalte anordnet, und wenn der Platz nicht ausreicht, wird eine neue Zeile oder Spalte begonnen.
        obenPanel.add(new JLabel("Flugzeugtyp auswählen:")); // Ein JLabel mit dem Text "Flugzeugtyp auswählen:" wird erstellt und dem "obenPanel" hinzugefügt.
        obenPanel.add(flugzeugComboBox); // Die JComboBox flugzeugComboBox, die die verschiedenen Flugzeugtypen enthält, wird dem "obenPanel" hinzugefügt.
        obenPanel.add(anzeigenButton); //  Der JButton "anzeigenButton" mit der Beschriftung "Anzeigen" wird dem "obenPanel" hinzugefügt.

        add(obenPanel, BorderLayout.NORTH); //  Das obenPanel wird dem JFrame im nördlichen (oberen) Bereich des BorderLayouts hinzugefügt. Dadurch werden die Komponenten (JLabel, JComboBox und JButton) im nördlichen Bereich des Fensters angeordnet.
        add(new JScrollPane(ausgabeTextArea), BorderLayout.CENTER);
        /* Eine JScrollPane (eine Scrollbar-Komponente) wird erstellt und dem ausgabeTextArea (der Textausgabe) hinzugefügt. Die JScrollPane wird dann 
        dem JFrame im zentralen Bereich des BorderLayouts hinzugefügt. Dadurch wird das ausgabeTextArea im zentralen Bereich des Fensters angeordnet. 
        Wenn der Text im ausgabeTextArea den verfügbaren Bereich überschreitet, wird eine Scrollbar angezeigt, um durch den Text zu scrollen.        
         */
    }


    private void zeigeFlugzeugLandung() {

// Ausgewählten Flugzeugtyp aus der ComboBox erhalten

        /* flugzeugComboBox ist eine JComboBox, die die verschiedenen Flugzeugtypen enthält 
        (z. B. "Standard-Flugzeug", "Passagierflugzeug", "Frachtflugzeug", "Militärflugzeug"). 
        getSelectedItem() ist eine Methode der JComboBox, die das aktuell ausgewählte Element in 
        der ComboBox zurückgibt. In diesem Fall wird das ausgewählte Flugzeugtyp-Element als Object zurückgegeben.
        */
        String flugzeugTyp = (String) flugzeugComboBox.getSelectedItem();
        Flugzeug flugzeug;


// Je nach ausgewähltem Flugzeugtyp das entsprechende Flugzeug erstellen
        switch (flugzeugTyp) {
            case "Passagierflugzeug":
                flugzeug = new PassagierFlugzeug("Airbus A320", 180);
                break;
            case "Frachtflugzeug":
                flugzeug = new FrachtFlugzeug("Boeing 747", 30.5);
                break;
            case "Militärflugzeug":
                flugzeug = new MilitaerFlugzeug("F-16", 500);
                break;
            default:
                flugzeug = new Flugzeug("Standard-Flugzeug");
        }


// Textausgabe vorbereiten und die landen()-Methode aufrufen
        String ausgabe = "Ausgewähltes Flugzeug: " + flugzeugTyp + "\n";
        ausgabe += "Status der Landung:\n";
        ausgabe += flugzeug.landen(); // Hier wird die individuelle landen()-Methode des ausgewählten Flugzeugs aufgerufen.
        ausgabeTextArea.setText(ausgabe); // Ausgabe in das JTextArea-Feld setzen
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Flughafen().setVisible(true);
            }
        });
    }
}
