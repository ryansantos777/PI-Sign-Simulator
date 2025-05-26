
package pisimulatorsign;
import pi.signsimulator.controle.Controle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Pisimulatorsign {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    System.err.println("Erro ao definir Look and Feel: " + e.getMessage());
                }
                Controle controle = new Controle();
                controle.mostrarTelaLogin();
            }
        });
    }
}