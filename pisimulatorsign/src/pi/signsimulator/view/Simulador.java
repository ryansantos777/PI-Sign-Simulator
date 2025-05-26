
package pi.signsimulator.view;
import pi.signsimulator.controle.Controle;
import pi.signsimulator.serviço.SimuladorDeSigno;
import pi.signsimulator.modelo.Signo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Simulador extends JFrame {
    private Controle controle;
    private SimuladorDeSigno simulador;
    private JLabel lblTitulo;
    private JLabel lblNome;
    private JLabel lblData;
    private JLabel lblFormato;
    private JTextField txtNome;
    private JTextField txtData;
    private JButton btnVoltar;
    private JButton btnDescobrir;

    public Simulador(Controle controle) {
        this.controle = controle;
        this.simulador = new SimuladorDeSigno();
        initComponents();
        setupLayout();
        setupEvents();
    }

    private void initComponents() {
        // Configurações da janela
        setTitle("Simulador - Descubra seu Signo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 450);
        setLocationRelativeTo(null);
        setResizable(false);

        // Criar componentes
        lblTitulo = new JLabel("DESCUBRA SEU SIGNO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblNome = new JLabel("Seu nome:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 16));
        lblNome.setForeground(Color.WHITE);

        lblData = new JLabel("Data de nascimento:");
        lblData.setFont(new Font("Arial", Font.BOLD, 16));
        lblData.setForeground(Color.WHITE);

        lblFormato = new JLabel("(Formato: dd/mm/aaaa)");
        lblFormato.setFont(new Font("Arial", Font.ITALIC, 12));
        lblFormato.setForeground(new Color(255, 255, 255, 180));

        txtNome = new JTextField();
        txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNome.setPreferredSize(new Dimension(250, 32));

        txtData = new JTextField();
        txtData.setFont(new Font("Arial", Font.PLAIN, 14));
        txtData.setPreferredSize(new Dimension(250, 32));

        btnVoltar = new JButton("VOLTAR");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
        btnVoltar.setBackground(new Color(108, 117, 125));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setPreferredSize(new Dimension(120, 40));
        btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnDescobrir = new JButton("DESCOBRIR SIGNO");
        btnDescobrir.setFont(new Font("Arial", Font.BOLD, 14));
        btnDescobrir.setBackground(new Color(220, 53, 69));
        btnDescobrir.setForeground(Color.WHITE);
        btnDescobrir.setFocusPainted(false);
        btnDescobrir.setBorderPainted(false);
        btnDescobrir.setPreferredSize(new Dimension(170, 40));
        btnDescobrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupLayout() {
        // Painel principal com gradiente
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(105, 105, 105),
                    0, getHeight(), new Color(169, 169, 169)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        // Posicionamento manual dos componentes
        lblTitulo.setBounds(50, 30, 450, 40);
        lblNome.setBounds(120, 120, 100, 25);
        txtNome.setBounds(120, 150, 300, 32);
        lblData.setBounds(120, 200, 180, 25);
        txtData.setBounds(120, 230, 300, 32);
        lblFormato.setBounds(120, 265, 200, 20);
        btnVoltar.setBounds(140, 330, 120, 40);
        btnDescobrir.setBounds(280, 330, 170, 40);

        // Adicionar componentes ao painel
        mainPanel.add(lblTitulo);
        mainPanel.add(lblNome);
        mainPanel.add(txtNome);
        mainPanel.add(lblData);
        mainPanel.add(txtData);
        mainPanel.add(lblFormato);
        mainPanel.add(btnVoltar);
        mainPanel.add(btnDescobrir);

        add(mainPanel);
    }

    private void setupEvents() {
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.mostrarTelaApresentacao();
                dispose();
            }
        });

        btnDescobrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descobrirSigno();
            }
        });

        // Enter para descobrir signo
        getRootPane().setDefaultButton(btnDescobrir);
    }

    private void descobrirSigno() {
        String nome = txtNome.getText().trim();
        String dataStr = txtData.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, digite seu nome!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dataStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, digite sua data de nascimento!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(dataStr, formatter);
            
            Signo signo = simulador.getSignoObj(dataNascimento);
            if (signo != null) {
                controle.mostrarTelaResultado(nome, signo);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Não foi possível determinar o signo. Verifique a data!", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, 
                "Data inválida! Use o formato dd/mm/aaaa\nExemplo: 15/03/1990", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
