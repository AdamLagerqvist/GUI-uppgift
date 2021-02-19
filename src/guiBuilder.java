import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class guiBuilder {

    private JPanel panel1;
    private JTextArea textArea1;
    private JScrollPane scollbar1;
    private JMenuBar menuBar;
    private JMenu menu, subMenu;
    private JMenuItem menuItem;

    public guiBuilder() {

        //skapar menubaren
        menuBar = new JMenuBar();

        //skapar en meny på min menubar
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        //skapar en load knapp
        menuItem = new JMenuItem("Load", KeyEvent.VK_L);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menu.add(menuItem);
        menuItem.addActionListener(new LoadAL());

        //skapar en save knapp
        menuItem = new JMenuItem("Save", KeyEvent.VK_S);
        menuItem.setMnemonic(KeyEvent.VK_S);
        menu.add(menuItem);
        menuItem.addActionListener(new SaveAssAL());

        //Skapar en ny meny för text grejer
        menu = new JMenu("Text");
        menu.setMnemonic(KeyEvent.VK_T);
        menuBar.add(menu);

        JFrame frame = new JFrame("guiBuilder");
        frame.setContentPane(this.panel1);
        frame.setJMenuBar(this.menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        guiBuilder instans = new guiBuilder();
    }

    public class SaveAssAL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);
            String filename = null;
            filename = fc.getSelectedFile().getAbsolutePath();

            FileWriter fw = null;
            try {
                fw = new FileWriter(filename + ".txt");
            } catch (IOException a) {
                a.printStackTrace();
            }
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter outFile = new PrintWriter(bw);

            outFile.println(textArea1.getText());
            outFile.flush();
            outFile.close();
        }
    }

    public class LoadAL implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent actionEvent) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(null);
            String filename = null;
            filename = fc.getSelectedFile().getAbsolutePath();
            FileReader FRLoad = null;
            try {
                FRLoad = new FileReader(filename);
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
            }

            BufferedReader inFile = new BufferedReader(FRLoad);

            String line;
            textArea1.setText("");
            try {
                while ((line = inFile.readLine()) != null) {
                    textArea1.setText(textArea1.getText() + line + "\n");
                }
                inFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
