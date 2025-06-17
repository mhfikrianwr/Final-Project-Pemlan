package application;

import java.awt.EventQueue;
import frames.MainFrame;

public class AppRun {
    public static void main(String[] args) {
        EventQueue.invokeLater(MainFrame :: new);
    }
}
