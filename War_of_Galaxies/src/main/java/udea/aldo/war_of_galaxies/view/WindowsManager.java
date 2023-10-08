/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JFrame;

/**
 *
 * @author Jhomar_Arrieta
 */
public class WindowsManager {
    // Lista para almacenar todas las ventanas abiertas
    private static final Stack<JFrame> windows = new Stack<>();

    // Método para añadir una ventana a la lista
    public static void addWindow(JFrame frame) {
        if (!windows.isEmpty()) {
            windows.peek().setVisible(false);
        }
        windows.push(frame);
    }

    // Método para remover una ventana de la lista
    public static void removeWindow(JFrame frame) {
        windows.remove(frame);
    }

    // Método para obtener todas las ventanas abiertas
    public static List<JFrame> getOpenWindows() {
        return new ArrayList<>(windows);
    }
    
    //guardar la ventana principal
    private static JFrame mainFrame = null;

    public static void setMainFrame(JFrame frame) {
    mainFrame = frame;
    }

    public static JFrame getMainFrame() {
    return mainFrame;
    }
    
    //cierra todas las ventans menos el main
    public static void closeAllButMain(JFrame mainFrame) {
        for (JFrame frame : new ArrayList<>(windows)) {
            if (frame != mainFrame) {
                frame.dispose();
                removeWindow(frame);
            }
        }
    }
    public static void closeCurrentAndShowPrevious() {
        if (!windows.isEmpty()) {
            JFrame current = windows.pop();  // Elimina y devuelve la ventana actual
            current.dispose();
        }

        if (!windows.isEmpty()) {
            JFrame previous = windows.peek();  // Obtiene la ventana anterior sin eliminarla
            previous.setVisible(true);
        }
    }
    
}
