
package pi.signsimulator.modelo;

import java.time.LocalDate;

public class Signo {
    private String nome;
    private int diaInicio, mesInicio;
    private int diaFim, mesFim;
    private String descricao;

    public Signo(String nome, int diaInicio, int mesInicio, int diaFim, int mesFim, String descricao) {
        this.nome = nome;
        this.diaInicio = diaInicio;
        this.mesInicio = mesInicio;
        this.diaFim = diaFim;
        this.mesFim = mesFim;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean verificaData(LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        if (mesInicio < mesFim || (mesInicio == mesFim && diaInicio <= diaFim)) {
            return (mes > mesInicio || (mes == mesInicio && dia >= diaInicio)) &&
                   (mes < mesFim || (mes == mesFim && dia <= diaFim));
        } else {
            return (mes > mesInicio || (mes == mesInicio && dia >= diaInicio)) ||
                   (mes < mesFim || (mes == mesFim && dia <= diaFim));
        }
    }
}
