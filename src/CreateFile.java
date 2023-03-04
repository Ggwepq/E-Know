import javax.swing.*;
import java.awt.*;

public class CreateFile extends JFrame{

    JPanel cntrlPane = new JPanel();
    JTextField writeField = new JTextField();
    JTextArea fileName = new JTextArea();
    JButton fileSave = new JButton();
    JButton goBack = new JButton();

    public CreateFile(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1300, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Create a File");
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));

        cntrlPane.setPreferredSize(new Dimension(800, 80));
        cntrlPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        add(cntrlPane);
        cntrlPane();
        textArea();
    }

    public void cntrlPane(){
        JLabel fileLabel = new JLabel("File Name");
        fileLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        writeField.setPreferredSize(new Dimension(300, 35));
        writeField.setFont(new Font("Arial", Font.PLAIN, 20));

        fileSave.setText("Save File");
        fileSave.setPreferredSize(new Dimension(100, 35));
        fileSave.setFocusable(false);

        goBack.setText("Go Back");
        goBack.setPreferredSize(new Dimension(100, 35));
        goBack.setFocusable(false);
        goBack.addActionListener(e -> goBack());

        cntrlPane.add(fileLabel);
        cntrlPane.add(writeField);
        cntrlPane.add(fileSave);
        cntrlPane.add(goBack);
    }

    public void textArea() {
        fileName.setPreferredSize(new Dimension(750, 600));
        fileName.setFont(new Font("Arial", Font.PLAIN, 15));
        fileName.setWrapStyleWord(true);
        fileName.setLineWrap(true);
        fileName.setBorder(BorderFactory.createCompoundBorder(
                fileName.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        writeField.setText("");
        fileName.setText("");

        add(fileName);
    }
    public void goBack(){
        dispose();
        new TeacherFrame().setVisible(true);
    }



    public static void main(){
        new CreateFile();
    }

}
