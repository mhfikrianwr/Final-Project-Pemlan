package Main_App;

import Main_Frame.MainFrame;
import java.awt.EventQueue;

public class AppRun {
    public static void main(String[] args){
        EventQueue.invokeLater(MainFrame :: new);
    }
}
