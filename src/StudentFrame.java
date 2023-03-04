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

public class StudentFrame extends JFrame{

    JPanel leftPane = new JPanel(), centerPane = new JPanel();
    JPanel filePane = new JPanel();
    JPanel libPane = new JPanel(), browsePane = new JPanel();
    FileViewer fv = new FileViewer();

    public StudentFrame(){
        this.setSize(1300, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setTitle("E-Know Student");

        leftPane.setPreferredSize(new Dimension(300, 10));
        leftPane.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 0));

        centerPane.setBackground(Color.GREEN);
        centerPane.setLayout(null);

        this.add(leftPane, BorderLayout.WEST);
        this.add(centerPane, BorderLayout.CENTER);

        leftPane();
        centerPane();
    }

    public void leftPane(){
        JPanel libBtn = new JPanel();
        JPanel browseBtn = new JPanel();

        libBtn.setPreferredSize(new Dimension(300, 100));
        libBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
//        libBtn.setBorder(BorderFactory.createMatteBorder(3, 3, 1, 3, Color.DARK_GRAY));
        libBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                libBtn.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e) {
                libBtn.setBackground(getBackground());
            }
            public void mouseClicked(MouseEvent e){
                browsePane.setVisible(false);
                libPane.setVisible(true);
            }
        });

        browseBtn.setPreferredSize(new Dimension(300, 100));
        browseBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
//        browseBtn.setBorder(BorderFactory.createMatteBorder(2, 3, 3, 3, Color.DARK_GRAY));
        browseBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                browseBtn.setBackground(Color.LIGHT_GRAY);
            }
            public void mouseExited(MouseEvent e) {
                browseBtn.setBackground(getBackground());
            }
            public void mouseClicked(MouseEvent e){
                libPane.setVisible(false);
                browsePane.setVisible(true);
            }
        });

        leftPane.add(libBtn);
        leftPane.add(browseBtn);

        JLabel libLabel = new JLabel("Library");
        JLabel browseLabel = new JLabel("Browse");

        libLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        browseLabel.setFont(new Font("Arial", Font.PLAIN, 40));

        libBtn.add(libLabel);
        browseBtn.add(browseLabel);

    }

    public void centerPane(){
        libPane.setBounds(0,0,1000, 765);
        browsePane.setBounds(0,0,1000, 765);

        libPane.setBackground(new Color(0xc7c7c7));
        browsePane.setBackground(new Color(0xc7c7c7));

        libPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        browsePane.setLayout(new FlowLayout(FlowLayout.CENTER));

        libPane.setVisible(true);
        browsePane.setVisible(false);

        centerPane.add(libPane);
        centerPane.add(browsePane);
        browsePane();
    }

    public void libPane(){

    }

    public void browsePane(){
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

        browsePane.add(filePane);

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

    public static void main(String[] args){
        new StudentFrame();
    }
}
