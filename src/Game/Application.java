
package Game;
import javax.swing.JFrame;

public class Application extends JFrame {
    
    public Application() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        //Tamaño imagen fondo
        setSize(800, 533);
        setTitle("Ejercicio 3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        Application application = new Application();
        application.setVisible(true);       
    }
}
