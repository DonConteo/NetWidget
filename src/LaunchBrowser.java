import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class LaunchBrowser {

    public void launchVK(){
        try {
            Desktop.getDesktop().browse(URI.create("https://vk.com"));
        } catch (IOException ex) {
        }
    }

    public void launchYoutube() {
        try {
            Desktop.getDesktop().browse(URI.create("https://www.youtube.com"));
        } catch (IOException ex) {
        }
    }

    public void launchInstagram() {
        try {
            Desktop.getDesktop().browse(URI.create("https://www.instagram.com"));
        } catch (IOException ex) {
        }
    }

    public void launchMail(){
        try {
            Desktop.getDesktop().browse(URI.create("https://mail.google.com/mail"));
        } catch (IOException ex) {
        }
    }
}
