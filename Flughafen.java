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
        setLayout(new BorderLayout());
        JPanel obenPanel = new JPanel(new FlowLayout());
        obenPanel.add(new JLabel("Flugzeugtyp auswählen:"));
        obenPanel.add(flugzeugComboBox);
        obenPanel.add(anzeigenButton);

        add(obenPanel, BorderLayout.NORTH);
        add(new JScrollPane(ausgabeTextArea), BorderLayout.CENTER);
    }


    private void zeigeFlugzeugLandung() {
// Ausgewählten Flugzeugtyp aus der ComboBox erhalten
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
