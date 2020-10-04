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

    public Icon press(String press){
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource(press)));
        return icon;
    }

    public Icon release(String release){
        ImageIcon icon = new ImageIcon((Toolkit.getDefaultToolkit().createImage(getClass().getResource(release))));
        return icon;
    }

    public Widget(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(BackGround);
        this.setSize(379, 71);
        this.setUndecorated(true);
        this.setLocation(770, 0);
        this.setIconImage(
                Toolkit.getDefaultToolkit().getImage(Widget.class.getResource("Icons/IconApp.png")));
        this.setVisible(true);

        VKBTN.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                VKBTN.setIcon(press("Icons/IconVKPressed.png"));
            }
            public void mouseReleased(MouseEvent e) {
                VKBTN.setIcon(release("Icons/IconVK.png"));
                LB.launchVK();
            }
        });
        InstaBTN.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                InstaBTN.setIcon(press("Icons/IconInstaPressed.png"));
            }
            public void mouseReleased(MouseEvent e) {
                InstaBTN.setIcon(release("Icons/IconInsta.png"));
                LB.launchInstagram();
            }
        });
        YouTubeBTN.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                YouTubeBTN.setIcon(press("Icons/IconYouTubePressed.png"));
            }
            public void mouseReleased(MouseEvent e) {
                YouTubeBTN.setIcon(release("Icons/IconYouTube.png"));
                LB.launchYoutube();
            }
        });
        MailBTN.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                MailBTN.setIcon(press("Icons/IconMailPressed.png"));
            }
            public void mouseReleased(MouseEvent e) {
                MailBTN.setIcon(release("Icons/IconMail.png"));
                LB.launchMail();
            }
        });
        CloseBTN.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                CloseBTN.setIcon(press("Icons/IconClosePressed.png"));
            }
            public void mouseReleased(MouseEvent e) {
                CloseBTN.setIcon(release("Icons/IconClose.png"));
                System.exit(0);
            }
        });
        BackGround.addMouseListener(new MouseAdapter() {
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
    }
}
