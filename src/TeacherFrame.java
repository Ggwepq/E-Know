import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class TeacherFrame extends JFrame{

    final String img = "assets\\img\\";
    CreateFile cf = new CreateFile();
    FileViewer fv = new FileViewer();
    JPanel uploadPane = new JPanel(), createPane = new JPanel(), menuPane = new JPanel(), filePane = new JPanel();

    public TeacherFrame(){
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        this.setTitle("E-Know Teacher");

        menuPane();
        filePane();
    }

    public void menuPane(){
        menuPane.setPreferredSize(new Dimension(700, 300));
        menuPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        add(menuPane);

        uploadPane.setPreferredSize(new Dimension(250, 250));
        uploadPane.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.DARK_GRAY));
        uploadPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        uploadPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                uploadPane.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                uploadPane.setBackground(getBackground());
            }
        });

        createPane.setPreferredSize(new Dimension(250, 250));
        createPane.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.DARK_GRAY));
        createPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        createPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                createPane.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                createPane.setBackground(getBackground());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                cf.setVisible(true);
            }
        });

        menuPane.add(uploadPane);
        menuPane.add(createPane);

        JLabel uploadIcon = new JLabel(new ImageIcon(new ImageIcon(img+"open-folder.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT)));
        JLabel uploadLabel = new JLabel("Upload File");

        JLabel createIcon = new JLabel(new ImageIcon(new ImageIcon(img+"add.png").getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT)));
        JLabel createLabel = new JLabel("Create File");

        uploadLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        createLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        uploadPane.add(uploadIcon);
        uploadPane.add(uploadLabel);

        createPane.add(createIcon);
        createPane.add(createLabel);
    }

    public void filePane(){
        filePane.setPreferredSize(new Dimension(1000, 400));
        filePane.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 5));

        File folder = new File("files\\");
        File[] listOfFiles = folder.listFiles();

        JPanel[] paneArr = new JPanel[getNumberOfFiles()];

        for (int i = 0; i < getNumberOfFiles(); i++){
            paneArr[i] = new JPanel();
            paneArr[i].setPreferredSize(new Dimension(950, 60));
            paneArr[i].setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.DARK_GRAY));
            paneArr[i].setLayout(new FlowLayout(FlowLayout.LEFT, 40, 15));
            int finalI = i;
            paneArr[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    paneArr[finalI].setBackground(Color.LIGHT_GRAY);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                   paneArr[finalI].setBackground(getBackground());
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    String get = listOfFiles[finalI].toString();
                    new FileViewer().setVisible(true);
                    fv.displayFile(get);
                }
            });

            filePane.add(paneArr[i]);

            JLabel[] nameOfArr;
            nameOfArr = new JLabel[getNumberOfFiles()];

            nameOfArr[i] = new JLabel();
            nameOfArr[i].setFont(new Font("Arial", Font.PLAIN, 20));

            if (listOfFiles[i].isFile()) {
                nameOfArr[i].setText(listOfFiles[i].getName());
            }

            paneArr[i].add(nameOfArr[i]);

        }
        System.out.println(Arrays.toString(listOfFiles));

        add(filePane);
    }

    public int getNumberOfFiles(){
        List<String> fileNames = new ArrayList<>();
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("files\\"));
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {

        }
        return fileNames.size();
    }



    public static void main(){
        new TeacherFrame();
    }

}
