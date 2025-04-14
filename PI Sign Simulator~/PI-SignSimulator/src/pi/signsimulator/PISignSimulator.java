
package pi.signsimulator;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Signo {
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;

    public Signo(String nome, LocalDate dataInicio, LocalDate dataFim, String descricao) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean verificaData(LocalDate data) {
        if (data.isEqual(dataInicio) || data.isEqual(dataFim)) {
            return true;
        }
        if (dataInicio.isBefore(dataFim)) {
            return data.isAfter(dataInicio) && data.isBefore(dataFim);
        } else {
            // Para signos que atravessam o final do ano
            return data.isAfter(dataInicio) || data.isBefore(dataFim);
        }
    }
}

class SimuladorDeSignos {
    private Signo[] signos;

    public SimuladorDeSignos() {
        signos = new Signo[]{
            new Signo("Áries", LocalDate.of(2025, 3, 21), LocalDate.of(2025, 4, 19), "Corajoso, determinado e confiante."),
            new Signo("Touro", LocalDate.of(2025, 4, 20), LocalDate.of(2025, 5, 20), "Prático, confiável e paciente."),
            new Signo("Gêmeos", LocalDate.of(2025, 5, 21), LocalDate.of(2025, 6, 20), "Adaptável, comunicativo e curioso."),
            new Signo("Câncer", LocalDate.of(2025, 6, 21), LocalDate.of(2025, 7, 22), "Emocional, protetor e intuitivo."),
            new Signo("Leão", LocalDate.of(2025, 7, 23), LocalDate.of(2025, 8, 22), "Generoso, criativo e carismático."),
            new Signo("Virgem", LocalDate.of(2025, 8, 23), LocalDate.of(2025, 9, 22), "Analítico, prático e detalhista."),
            new Signo("Libra", LocalDate.of(2025, 9, 23), LocalDate.of(2025, 10, 22), "Diplomático, justo e sociável."),
            new Signo("Escorpião", LocalDate.of(2025, 10, 23), LocalDate.of(2025, 11, 21), "Intenso, apaixonado e misterioso."),
            new Signo("Sagitário", LocalDate.of(2025, 11, 22), LocalDate.of(2025, 12, 21), "Aventureiro, otimista e filosófico."),
            new Signo("Capricórnio", LocalDate.of(2025, 12, 22), LocalDate.of(2026, 1, 19), "Ambicioso, disciplinado e responsável."),
            new Signo("Aquário", LocalDate.of(2026, 1, 20), LocalDate.of(2026, 2, 18), "Inovador, independente e humanitário."),
            new Signo("Peixes", LocalDate.of(2026, 2, 19), LocalDate.of(2026, 3, 20), "Empático, sonhador e artístico.")
        };
    }

    public String determinarSigno(LocalDate dataNascimento) {
        for (Signo signo : signos) {
            if (signo.verificaData(dataNascimento)) {
                return signo.getNome() + ": " + signo.getDescricao();
            }
        }
        return "Data inválida.";
    }
}

public class PISignSimulator {
    public static void main(String[] args) {
        SimuladorDeSignos simulador = new SimuladorDeSignos();
        String dataStr;
        LocalDate dataNascimento = null;
        boolean dataValida = false;

        while (!dataValida) {
            dataStr = JOptionPane.showInputDialog(null, "Digite a data do seu aniversario neste ano (dd/MM/2025):", "Simulador de Signos", JOptionPane.QUESTION_MESSAGE);
            if (dataStr == null) {
             JOptionPane.showMessageDialog(null, "Operação cancelada.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return; // Encerra o programa se o usuário cancelar
            }

            
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataNascimento = LocalDate.parse(dataStr, formatter);
                dataValida = true;
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data inválida. Por favor, insira no formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        String resultado = simulador.determinarSigno(dataNascimento);
        JOptionPane.showMessageDialog(null, resultado, "Seu Signo", JOptionPane.INFORMATION_MESSAGE);
    }
}
    

