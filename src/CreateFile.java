import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile extends JFrame{
    final String file = "files\\";

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
        fileSave.addActionListener(e -> fileSave());

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

    public void fileSave(){
        String filename = writeField.getText()+".txt";

        createFile(filename);
    }

    public void goBack(){
        dispose();
        new TeacherFrame().setVisible(true);
    }

    public void createFile(String fileName){
        try {
            File myObj = new File(file+fileName);
            if (myObj.createNewFile()) {
            } else {
                writeField.setText(writeField.getText());
            }
            writeFile(myObj.getPath());
        } catch (IOException e) {
            writeField.setText("Something went Wrong");
            e.printStackTrace();
        }
    }

    public void writeFile(String name){
        try {
            FileWriter myWriter = new FileWriter(name);
            myWriter.write(fileName.getText());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(){
        new CreateFile();
    }

}
