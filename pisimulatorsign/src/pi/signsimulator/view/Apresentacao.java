
package pi.signsimulator.view;

import pi.signsimulator.controle.Controle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Apresentacao extends JFrame {
private Controle controle;
    private JLabel lblTitulo;
    private JTextArea txtApresentacao;
    private JButton btnContinuar;
    private JScrollPane scrollPane;

    public Apresentacao(Controle controle) {
        this.controle = controle;
        initComponents();
        setupLayout();
        setupEvents();
    }

    private void initComponents() {
        setTitle("Apresentação - Simulador de Signos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        lblTitulo = new JLabel("Bem-vindo(a), " + controle.getUsuarioLogado() + "!");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        txtApresentacao = new JTextArea();
        txtApresentacao.setText("DESCUBRA SEU SIGNO DO ZODÍACO\n\n" +
                "Os signos do zodíaco são uma forma antiga de entender\n" +
                "a personalidade e características das pessoas baseada\n" +
                "na data de nascimento.\n\n" +
                "Existem 12 signos, cada um com suas próprias\n" +
                "características únicas e períodos específicos do ano.\n\n" +
                "Descubra qual é o seu signo e conheça mais sobre\n" +
                "sua personalidade!\n\n" +
                "Áries, Touro, Gêmeos, Câncer\n" +
                "Leão, Virgem, Libra, Escorpião \n" +
                "Sagitário, Capricórnio, Aquário, Peixes ");
        
        txtApresentacao.setFont(new Font("Arial", Font.PLAIN, 16));
        txtApresentacao.setForeground(Color.WHITE);
        txtApresentacao.setOpaque(false);
        txtApresentacao.setEditable(false);
        txtApresentacao.setLineWrap(true);
        txtApresentacao.setWrapStyleWord(true);
        txtApresentacao.setMargin(new Insets(10, 10, 10, 10));

        scrollPane = new JScrollPane(txtApresentacao);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        btnContinuar = new JButton("SIMULAR");
        btnContinuar.setFont(new Font("Arial", Font.BOLD, 16));
        btnContinuar.setBackground(new Color(40, 167, 69));
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorderPainted(false);
        btnContinuar.setPreferredSize(new Dimension(220, 45));
        btnContinuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(16, 78, 139),
                    0, getHeight(), new Color(79, 148, 205)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        lblTitulo.setBounds(50, 30, 550, 40);
        scrollPane.setBounds(75, 90, 500, 280);
        btnContinuar.setBounds(215, 390, 220, 45);

        mainPanel.add(lblTitulo);
        mainPanel.add(scrollPane);
        mainPanel.add(btnContinuar);

        add(mainPanel);
    }

    private void setupEvents() {
        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.mostrarTelaSimulador();
                dispose();
            }
        });
    }
}
