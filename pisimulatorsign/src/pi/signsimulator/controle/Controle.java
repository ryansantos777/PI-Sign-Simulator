
package pi.signsimulator.controle;

import pi.signsimulator.view.Login;
import pi.signsimulator.view.Apresentacao;
import pi.signsimulator.view.Simulador;
import pi.signsimulator.view.Resultado;
import pi.signsimulator.modelo.Signo;

public class Controle {
    private String usuarioLogado;

    public void setUsuarioLogado(String usuario) {
        this.usuarioLogado = usuario;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void mostrarTelaLogin() {
        Login tela = new Login(this);
        tela.setVisible(true);
    }

    public void mostrarTelaApresentacao() {
        Apresentacao tela = new Apresentacao(this);
        tela.setVisible(true);
    }

    public void mostrarTelaSimulador() {
        Simulador tela = new Simulador(this);
        tela.setVisible(true);
    }

    public void mostrarTelaResultado(String nome, Signo signo) {
        Resultado tela = new Resultado(this, nome, signo);
        tela.setVisible(true);
    }
}
