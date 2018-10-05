import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;
import java.awt.Color;

public class TerminalFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private StyledDocument doc;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TerminalFrame terminal = new TerminalFrame();
                    terminal.setVisible(true);
                    terminal.print("put somethng here"); // Using print() to print to the "Swing Terminal".
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TerminalFrame() {
        setTitle("Is This A Game ?");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JTextPane textPane = new JTextPane();
        textPane.setForeground(Color.GREEN);
        textPane.setBackground(Color.BLACK);
        textPane.setEditable(false);
        contentPane.add(textPane, BorderLayout.CENTER);
        doc = textPane.getStyledDocument();
    }

    public void print(String s) {
        try {
            doc.insertString(0, s+"\n", null);
        }
        catch(Exception e) { System.out.println(e); }
    }

}