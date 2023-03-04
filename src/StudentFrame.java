import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class StudentFrame extends JFrame{

    JPanel leftPane = new JPanel(), centerPane = new JPanel();
    JPanel libPane = new JPanel(), browsePane = new JPanel();

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
    }

    public void libPane(){

    }

    public void browsePane(){

    }

    public static void main(String[] args){
        new StudentFrame();
    }
}
