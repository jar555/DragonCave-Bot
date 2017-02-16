package Dragcave;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

/**
 * Created by Leo on 5/7/2016.
 */
public class DragCaveApp {
    private JButton startButton;
    private JButton stopButton;
    private JPanel panelMain;
    private JTextArea textArea1;
    private JButton clearButton;
    private JPanel middlePanel;
    private JScrollPane textPanel;
    private JTabbedPane tabbedPane1;
    private JCheckBox blueDinoCheckBox;
    private JCheckBox blusangLindwurmCheckBox;
    private JCheckBox goldDragonCheckBox;
    private JCheckBox goldenWyvrenCheckBox;
    private JCheckBox greenDinoCheckBox;
    private JCheckBox iceDragonCheckBox;
    private JCheckBox magmaDragonCheckBox;
    private JCheckBox paperDragonCheckBox;
    private JCheckBox thunderDragonCheckBox;
    private JCheckBox silverDragonCheckBox;
    private JCheckBox redDinoCheckBox;
    private JCheckBox xenowyrmCheckBox;
    private JCheckBox yellowDinoCheckBox;
    private JCheckBox copperDragonCheckBox;
    private JCheckBox cheeseDragonCheckBox;
    private JCheckBox chickenCheckBox;
    private JPanel optionsPanel;
    private JCheckBox selectAllCheckBox;
    private String imagePath = "egg2.png";
    private TrayIcon tray;
    private Image trayIcon;
    private final SystemTray taskBarTray = SystemTray.getSystemTray();
    private int update = 0;

    public DragCaveApp() {
        try {
            trayIcon = ImageIO.read(new File(imagePath));
            tray = new TrayIcon(trayIcon, "DragCave Application");
            taskBarTray.add(tray);
        } catch (Exception e) {

        }
        middlePanel.setBorder(new TitledBorder(new EtchedBorder()));
        textPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel.setAutoscrolls(true);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dragcave.main(null);
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                blueDinoCheckBox.setEnabled(true);
                blusangLindwurmCheckBox.setEnabled(true);
                goldDragonCheckBox.setEnabled(true);
                goldenWyvrenCheckBox.setEnabled(true);
                greenDinoCheckBox.setEnabled(true);
                iceDragonCheckBox.setEnabled(true);
                magmaDragonCheckBox.setEnabled(true);
                paperDragonCheckBox.setEnabled(true);
                thunderDragonCheckBox.setEnabled(true);
                silverDragonCheckBox.setEnabled(true);
                redDinoCheckBox.setEnabled(true);
                xenowyrmCheckBox.setEnabled(true);
                yellowDinoCheckBox.setEnabled(true);
                copperDragonCheckBox.setEnabled(true);
                cheeseDragonCheckBox.setEnabled(true);
                chickenCheckBox.setEnabled(true);
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dragcave.stop();
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                blueDinoCheckBox.setEnabled(false);
                blusangLindwurmCheckBox.setEnabled(false);
                goldDragonCheckBox.setEnabled(false);
                goldenWyvrenCheckBox.setEnabled(false);
                greenDinoCheckBox.setEnabled(false);
                iceDragonCheckBox.setEnabled(false);
                magmaDragonCheckBox.setEnabled(false);
                paperDragonCheckBox.setEnabled(false);
                thunderDragonCheckBox.setEnabled(false);
                silverDragonCheckBox.setEnabled(false);
                redDinoCheckBox.setEnabled(false);
                xenowyrmCheckBox.setEnabled(false);
                yellowDinoCheckBox.setEnabled(false);
                copperDragonCheckBox.setEnabled(false);
                cheeseDragonCheckBox.setEnabled(false);
                chickenCheckBox.setEnabled(false);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(null);
            }
        });

        textArea1.setEditable(false);
        textArea1.setAutoscrolls(true);
        ScheduledExecutorService textUpdater = Executors.newSingleThreadScheduledExecutor();
        textUpdater.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (String s : Dragcave.getGottenEggs()) {
                    if (update != Dragcave.getGottenEggs().size()) {
                        update = Dragcave.getGottenEggs().size();
                        textArea1.append("Got " + s + "\n");
                        tray.displayMessage("Notification", "Got " + s, TrayIcon.MessageType.INFO);
                    }
                }
                for (String s :Dragcave.getEggs()) {
                    textArea1.append(s + " has appeared in the cave!" + "\n");
                }
                Dragcave.clearEggs();
                Dragcave.clearGottenEggs();
            }
        }, 0, 1, TimeUnit.SECONDS);

        redDinoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (redDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much warmer than the rest of the eggs.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much warmer than the rest of the eggs.", false);
                }
            }
        });

        blueDinoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (blueDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much lighter than the other eggs.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much lighter than the other eggs.", false);
                }
            }
        });

        yellowDinoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yellowDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much heavier than the other eggs.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much heavier than the other eggs.", false);
                }
            }
        });

        greenDinoCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (greenDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots.", false);
                }
            }
        });

        goldDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (goldDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is very reflective, almost metallic-looking.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is very reflective, almost metallic-looking.", false);
                }
            }
        });

        silverDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (silverDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg gives off a beautiful glow.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg gives off a beautiful glow.", false);
                }
            }
        });

        goldenWyvrenCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (goldenWyvrenCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg shimmers like gold.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg shimmers like gold.", false);
                }
            }
        });

        copperDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (copperDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg gleams with a reddish shine.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg gleams with a reddish shine.", false);
                }
            }
        });

        magmaDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (magmaDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is almost too hot to touch.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is almost too hot to touch.", false);
                }
            }
        });

        iceDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iceDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg has icicles forming on it.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg has icicles forming on it.", false);
                }
            }
        });

        thunderDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thunderDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("Whenever you go near this egg, your hair stands on end.", true);
                } else {
                    Dragcave.changeWantedEggs("Whenever you go near this egg, your hair stands on end.", false);
                }
            }
        });

        paperDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paperDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is tiny and made out of several pieces of paper folded together.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is tiny and made out of several pieces of paper folded together.", false);
                }
            }
        });

        xenowyrmCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xenowyrmCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("Mana courses throughout this glassy egg.", true);
                } else {
                    Dragcave.changeWantedEggs("Mana courses throughout this glassy egg.", false);
                }
            }
        });

        blusangLindwurmCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (blusangLindwurmCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg smells faintly like brine.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg smells faintly like brine.", false);
                }
            }
        });

        cheeseDragonCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cheeseDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is soft and smells uncannily like cheese.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is soft and smells uncannily like cheese.", false);
                }
            }
        });

        chickenCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chickenCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is much smaller than the others.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is much smaller than the others.", false);
                }
            }
        });

        selectAllCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectAllCheckBox.isSelected()) {
                    blueDinoCheckBox.setSelected(true);
                    blusangLindwurmCheckBox.setSelected(true);
                    goldDragonCheckBox.setSelected(true);
                    goldenWyvrenCheckBox.setSelected(true);
                    greenDinoCheckBox.setSelected(true);
                    iceDragonCheckBox.setSelected(true);
                    magmaDragonCheckBox.setSelected(true);
                    paperDragonCheckBox.setSelected(true);
                    thunderDragonCheckBox.setSelected(true);
                    silverDragonCheckBox.setSelected(true);
                    redDinoCheckBox.setSelected(true);
                    xenowyrmCheckBox.setSelected(true);
                    yellowDinoCheckBox.setSelected(true);
                    copperDragonCheckBox.setSelected(true);
                    cheeseDragonCheckBox.setSelected(true);
                    chickenCheckBox.setSelected(true);
                } else {
                    blueDinoCheckBox.setSelected(false);
                    blusangLindwurmCheckBox.setSelected(false);
                    goldDragonCheckBox.setSelected(false);
                    goldenWyvrenCheckBox.setSelected(false);
                    greenDinoCheckBox.setSelected(false);
                    iceDragonCheckBox.setSelected(false);
                    magmaDragonCheckBox.setSelected(false);
                    paperDragonCheckBox.setSelected(false);
                    thunderDragonCheckBox.setSelected(false);
                    silverDragonCheckBox.setSelected(false);
                    redDinoCheckBox.setSelected(false);
                    xenowyrmCheckBox.setSelected(false);
                    yellowDinoCheckBox.setSelected(false);
                    copperDragonCheckBox.setSelected(false);
                    cheeseDragonCheckBox.setSelected(false);
                    chickenCheckBox.setSelected(false);
                }
            }
        });

        redDinoCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (redDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much warmer than the rest of the eggs.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much warmer than the rest of the eggs.", false);
                }
            }
        });

        blueDinoCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (blueDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much lighter than the other eggs.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much lighter than the other eggs.", false);
                }
            }
        });

        yellowDinoCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (yellowDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much heavier than the other eggs.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots. It's much heavier than the other eggs.", false);
                }
            }
        });

        greenDinoCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (greenDinoCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg looks like it doesn't belong; it is brightly colored with white spots.", false);
                }
            }
        });

        goldDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (goldDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is very reflective, almost metallic-looking.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is very reflective, almost metallic-looking.", false);
                }
            }
        });

        silverDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (silverDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg gives off a beautiful glow.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg gives off a beautiful glow.", false);
                }
            }
        });

        goldenWyvrenCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (goldenWyvrenCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg shimmers like gold.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg shimmers like gold.", false);
                }
            }
        });

        copperDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (copperDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg gleams with a reddish shine.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg gleams with a reddish shine.", false);
                }
            }
        });

        magmaDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (magmaDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is almost too hot to touch.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is almost too hot to touch.", false);
                }
            }
        });

        iceDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (iceDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg has icicles forming on it.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg has icicles forming on it.", false);
                }
            }
        });

        thunderDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (thunderDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("Whenever you go near this egg, your hair stands on end.", true);
                } else {
                    Dragcave.changeWantedEggs("Whenever you go near this egg, your hair stands on end.", false);
                }
            }
        });

        paperDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (paperDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is tiny and made out of several pieces of paper folded together.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is tiny and made out of several pieces of paper folded together.", false);
                }
            }
        });

        xenowyrmCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (xenowyrmCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("Mana courses throughout this glassy egg.", true);
                } else {
                    Dragcave.changeWantedEggs("Mana courses throughout this glassy egg.", false);
                }
            }
        });

        blusangLindwurmCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (blusangLindwurmCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg smells faintly like brine.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg smells faintly like brine.", false);
                }
            }
        });

        cheeseDragonCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (cheeseDragonCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is soft and smells uncannily like cheese.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is soft and smells uncannily like cheese.", false);
                }
            }
        });

        chickenCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (chickenCheckBox.isSelected()) {
                    Dragcave.changeWantedEggs("This egg is much smaller than the others.", true);
                } else {
                    Dragcave.changeWantedEggs("This egg is much smaller than the others.", false);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DragCaveApp");
        frame.setContentPane(new DragCaveApp().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
