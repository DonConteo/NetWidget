import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Widget extends JFrame {
    private JPanel BackGround;
    private JLabel VKBTN;
    private JLabel YouTubeBTN;
    private JLabel InstaBTN;
    private JLabel MailBTN;
    private JLabel CloseBTN;
    private volatile int draggedAtX, draggedAtY;

    LaunchBrowser LB = new LaunchBrowser();

    public Widget(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(BackGround);
        this.setSize(379, 71);
        this.setUndecorated(true);

        VKBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                VKBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconVKPressed.png"))));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                VKBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconVK.png"))));
                LB.launchVK();
            }
        });
        InstaBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                InstaBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconInstaPressed.png"))));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                InstaBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconInsta.png"))));
                LB.launchInstagram();
            }
        });
        YouTubeBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                YouTubeBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconYouTubePressed.png"))));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                YouTubeBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconYouTube.png"))));
                LB.launchYoutube();
            }
        });
        MailBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MailBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconMailPressed.png"))));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                MailBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconMail.png"))));
                LB.launchMail();
            }
        });
        CloseBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                CloseBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconClosePressed.png"))));
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                CloseBTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("Icons/IconClose.png"))));
                System.exit(0);
            }
        });
        BackGround.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                draggedAtX = e.getX();
                draggedAtY = e.getY();
            }
        });
        BackGround.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){
                setLocation(e.getX() - draggedAtX + getLocation().x, e.getY() - draggedAtY + getLocation().y);
            }
        });
    }

    public static void main (String [] args){
        JFrame frame = new Widget();
        frame.setLocation(770, 0);
        frame.setIconImage(
                Toolkit.getDefaultToolkit().getImage(Widget.class.getResource("Icons/IconApp.png")));
        frame.setVisible(true);
    }
}
