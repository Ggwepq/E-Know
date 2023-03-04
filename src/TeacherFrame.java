import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TeacherFrame extends JFrame{

    final String img = "assets\\img\\";
    CreateFile cf = new CreateFile();
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
        filePane.setBackground(Color.BLACK);

        add(filePane);
    }

    public static void main(){
        new TeacherFrame();
    }

}
