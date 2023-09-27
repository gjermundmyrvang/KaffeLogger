import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    Kontroll kontroll;
    JFrame vindu;
    JPanel panel, menypanel, funksjonpanel;
    JButton liten, stor, stanley, start, quit;

    ImageIcon img = new ImageIcon("kaffe.png");
    Image bilde = img.getImage();
    Image nyimg = bilde.getScaledInstance(200, 200, Image.SCALE_SMOOTH);



    // QUIT
    class avsluttProgram implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            kontroll.quit();
        }
    }

    // Start/Slutt
    class runProgram implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (start.getText().equalsIgnoreCase("start")) {
                start.setBackground(Color.blue);
                start.setForeground(Color.WHITE);
                start.setText("Stop");
            }
            else {
            start.setText("Start");
            start.setBackground(Color.GREEN);
            start.setForeground(Color.BLACK);
            }
            kontroll.run();
        }
    }

    // Logger kaffe
    class logKaffe implements ActionListener {

        char bokstav;
        logKaffe(Character c) {
            bokstav = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!kontroll.isRunning()) {
                JOptionPane.showMessageDialog(null, "Du må starte programmet!", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (bokstav == 'l') {kontroll.logKaffe(2); return;}
            if (bokstav == 's') {kontroll.logKaffe(2.5); return;}
            kontroll.logKaffe(3.5);
        }
    }


    GUI(Kontroll k) {
        // Standard looknfeel setup
        try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(9);
        }

        // Oppretter en kontroll
        kontroll = k;

        img = new ImageIcon(nyimg);

        // Oppretter vindu
        vindu = new JFrame("KaffeKonsumIndeksen");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Oppretter overordnet panel
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.black);
        vindu.add(panel);

        // Oppretter menypanel
        menypanel = new JPanel();
        menypanel.setBackground(Color.darkGray);
        panel.add(menypanel, BorderLayout.NORTH);

        // Start/stop knapp
        start = new JButton("Start");
        start.setBackground(Color.GREEN);
        start.addActionListener(new runProgram());
        menypanel.add(start);

        // QUIT
        quit = new JButton("QUIT & SAVE");
        quit.setBackground(Color.RED);
        quit.addActionListener(new avsluttProgram());
        menypanel.add(quit);

        panel.add(new JLabel(img), BorderLayout.CENTER);

        // Oppretter funksjonpanel
        funksjonpanel = new JPanel();
        funksjonpanel.setLayout(new FlowLayout());
        funksjonpanel.setBackground(Color.darkGray);
        panel.add(funksjonpanel, BorderLayout.SOUTH);


        // Knapp for liten kopp med kaffe
        liten = new JButton("Liten kopp");
        liten.setBackground(Color.ORANGE);
        liten.addActionListener(new logKaffe('l'));

        // Knapp for liten kopp med kaffe
        stor = new JButton("Stor kopp");
        stor.setBackground(Color.pink);
        stor.addActionListener(new logKaffe('s'));

        // Knapp for stanley med kaffe
        stanley = new JButton("Stanley");
        stanley.setBackground(Color.green);
        stanley.addActionListener(new logKaffe('u'));

        funksjonpanel.add(liten); funksjonpanel.add(stor); funksjonpanel.add(stanley);





        vindu.pack();
        vindu.setSize(800, 600);
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);


    }
}


