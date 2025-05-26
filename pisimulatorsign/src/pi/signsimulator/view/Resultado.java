
package pi.signsimulator.view;
import pi.signsimulator.controle.Controle;
import pi.signsimulator.modelo.Signo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class Resultado extends JFrame {
    private Controle controle;
    private String nomeUsuario;
    private Signo signo;
    private JLabel lblTitulo;
    private JTextArea txtDescricao;
    private JScrollPane scrollPane;
    private JButton btnNovo;
    private JButton btnSair;

    public Resultado(Controle controle, String nomeUsuario, Signo signo) {
        this.controle = controle;
        this.nomeUsuario = nomeUsuario;
        this.signo = signo;
        initComponents();
        setupLayout();
        setupEvents();
    }

    private void initComponents() {
        // Configurações da janela
        setTitle("Resultado - Seu Signo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        // Criar componentes
        lblTitulo = new JLabel(" " + nomeUsuario + ", seu signo é " + signo.getNome() + "!");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        txtDescricao = new JTextArea();
        txtDescricao.setText(signo.getDescricao());
        txtDescricao.setFont(new Font("Arial", Font.PLAIN, 16));
        txtDescricao.setForeground(Color.WHITE);
        txtDescricao.setOpaque(false);
        txtDescricao.setEditable(false);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        txtDescricao.setMargin(new Insets(15, 15, 15, 15));

        scrollPane = new JScrollPane(txtDescricao);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        btnNovo = new JButton("SIMULAR");
        btnNovo.setFont(new Font("Arial", Font.BOLD, 14));
        btnNovo.setBackground(new Color(40, 167, 69));
        btnNovo.setForeground(Color.WHITE);
        btnNovo.setFocusPainted(false);
        btnNovo.setBorderPainted(false);
        btnNovo.setPreferredSize(new Dimension(150, 40));
        btnNovo.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnSair = new JButton("SAIR");
        btnSair.setFont(new Font("Arial", Font.BOLD, 14));
        btnSair.setBackground(new Color(220, 53, 69));
        btnSair.setForeground(Color.WHITE);
        btnSair.setFocusPainted(false);
        btnSair.setBorderPainted(false);
        btnSair.setPreferredSize(new Dimension(100, 40));
        btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
                    0, 0, new Color(102, 51, 153),
                    0, getHeight(), new Color(237, 117, 237)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);

        // Posicionamento manual dos componentes
        lblTitulo.setBounds(50, 30, 550, 40);
        scrollPane.setBounds(75, 180, 500, 250);
        btnNovo.setBounds(200, 450, 150, 40);
        btnSair.setBounds(370, 450, 100, 40);

        // Adicionar componentes ao painel
        mainPanel.add(lblTitulo);
        mainPanel.add(scrollPane);
        mainPanel.add(btnNovo);
        mainPanel.add(btnSair);

        add(mainPanel);
    }

    private void setupEvents() {
        btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.mostrarTelaSimulador();
                dispose();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcao = JOptionPane.showConfirmDialog(
                    Resultado.this,
                    "Deseja realmente sair do sistema?",
                    "Confirmar Saída",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (opcao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
        }
    
