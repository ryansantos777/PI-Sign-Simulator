
package pi.signsimulator.view;
import pi.signsimulator.controle.Controle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends javax.swing.JFrame{

private Controle controle;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogin;
    private JLabel lblTitulo;
    private JLabel lblUsuario;
    private JLabel lblSenha;

    public Login(Controle controle) {
        this.controle = controle;
        initComponents();
        setupLayout();
        setupEvents();
    }

    private void initComponents() {
        setTitle("Login - Simulador de Signos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        lblTitulo = new JLabel(" SIMULADOR DE SIGNOS ");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblUsuario.setForeground(Color.WHITE);

        lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
        lblSenha.setForeground(Color.WHITE);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsuario.setPreferredSize(new Dimension(200, 30));

        txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSenha.setPreferredSize(new Dimension(200, 30));

        btnLogin = new JButton("ENTRAR");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBackground(new Color(135, 206, 250));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setPreferredSize(new Dimension(150, 40));
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(0, 0, 128),
                    0, getHeight(), new Color(25, 25, 112)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        lblTitulo.setBounds(50, 30, 350, 40);
        lblUsuario.setBounds(100, 100, 80, 25);
        txtUsuario.setBounds(180, 100, 180, 30);
        lblSenha.setBounds(100, 150, 80, 25);
        txtSenha.setBounds(180, 150, 180, 30);
        btnLogin.setBounds(150, 220, 150, 40);

        mainPanel.add(lblTitulo);
        mainPanel.add(lblUsuario);
        mainPanel.add(txtUsuario);
        mainPanel.add(lblSenha);
        mainPanel.add(txtSenha);
        mainPanel.add(btnLogin);

        add(mainPanel);
    }

    private void setupEvents() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerLogin();
            }
        });

        getRootPane().setDefaultButton(btnLogin);
    }

    private void fazerLogin() {
        String usuario = txtUsuario.getText().trim();
        String senha = new String(txtSenha.getPassword());

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, preencha todos os campos!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (usuario.length() >= 3 && senha.length() >= 3) {
            controle.setUsuarioLogado(usuario);
            controle.mostrarTelaApresentacao();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Usuário e senha devem ter pelo menos 3 caracteres!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
