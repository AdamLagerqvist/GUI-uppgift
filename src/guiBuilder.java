import javax.swing.*;
import java.awt.event.KeyEvent;

public class guiBuilder {
    public static void main(String[] args) {
        guiBuilder instans = new guiBuilder();
    }

    guiBuilder() {
        JFrame frame = new JFrame("guiBuilder");
        menuBar = new JMenuBar();
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel1;
    private JTextArea textArea1;
    private JScrollPane scollbar1;
    private JMenuBar menuBar;

}
