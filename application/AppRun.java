package application;
import frames.MainFrame;
import java.awt.EventQueue;
public class AppRun {
    public static void main(String[] args) {
        EventQueue.invokeLater(MainFrame :: new);
    }
}
