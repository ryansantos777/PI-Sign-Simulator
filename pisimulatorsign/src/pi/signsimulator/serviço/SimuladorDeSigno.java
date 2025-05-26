
package pi.signsimulator.serviço;

import pi.signsimulator.modelo.Signo;
import java.time.LocalDate;

public class SimuladorDeSigno {
    private Signo[] signos;

    public SimuladorDeSigno() {
        signos = new Signo[]{
            new Signo("Áries", 21, 3, 19, 4, "Pessoas de Áries costumam ser impulsivas, energéticas, corajosas e cheias de iniciativa. Gostam de liderar, são determinadas e muitas vezes competitivas. Podem ser impacientes, mas têm muita coragem e otimismo."),
            new Signo("Touro", 20, 4, 20, 5, "Touro é estável, paciente e muito sensível ao prazer. As pessoas deste signo geralmente apreciam a beleza, a natureza e os confortos da vida. São práticas, fiéis e gostam de segurança, mas podem ser teimosas e possessivas."),
            new Signo("Gêmeos", 21, 5, 20, 6, "Geminianos são comunicativos, versáteis e curiosos. São conhecidos pela sua adaptabilidade e inteligência, mas podem ser inconstantes e indecisos. Gostam de estar em movimento e em busca de novas experiências."),
            new Signo("Câncer", 21, 6, 22, 7, "Cancerianos são sensíveis, protetores e muito ligados à família. Têm uma natureza emocional e intuitiva, sendo empáticos e cuidadosos, mas também podem ser temperamentais e mudar de humor rapidamente."),
            new Signo("Leão", 23, 7, 22, 8, "Leoninos são autoconfiantes, generosos e gostam de ser o centro das atenções. São criativos e têm uma natureza positiva e orgulhosa. Podem ser dramáticos e exigentes, mas são leais e cheios de energia."),
            new Signo("Virgem", 23, 8, 22, 9, "Virginianos são organizados, detalhistas e práticos. São muito analíticos e buscam a perfeição. Embora possam ser críticos, também são confiáveis e têm uma forte tendência a cuidar dos outros."),
            new Signo("Libra", 23, 9, 22, 10, "Librianos são equilibrados, diplomáticos e adoram a harmonia. Valorizam as relações e têm um forte senso de justiça. São sociáveis, mas podem ser indecisos e tendem a evitar confrontos."),
            new Signo("Escorpião", 23, 10, 21, 11, "Escorpianos são intensos, misteriosos e passionais. São muito determinados e gostam de profundidade, tanto nas relações quanto nas experiências de vida. Podem ser possessivos e vingativos, mas são leais e corajosos."),
            new Signo("Sagitário", 22, 11, 21, 12, "Sagitarianos são otimistas, aventureiros e adoram explorar o desconhecido. São independentes, filosóficos e têm um espírito livre. Podem ser impulsivos e imprudentes, mas têm um grande coração."),
            new Signo("Capricórnio", 22, 12, 19, 1, "Capricornianos são disciplinados, ambiciosos e responsáveis. São focados em alcançar seus objetivos e têm uma abordagem prática da vida. Podem ser reservados e muitas vezes exigentes consigo mesmos e com os outros."),
            new Signo("Aquário", 20, 1, 18, 2, "Aquarianos são inovadores, intelectuais e possuem uma visão humanitária. São independentes, excêntricos e adoram quebrar barreiras. Podem ser imprevisíveis e têm uma abordagem original da vida."),
            new Signo("Peixes", 19, 2, 20, 3, "Piscianos são sensíveis, empáticos e sonhadores. Têm uma forte conexão com suas emoções e com o mundo espiritual. São criativos e intuitivos, mas podem ser escapistas e indecisos.")
        };
    }

    public Signo getSignoObj(LocalDate dataNascimento) {
        for (Signo signo : signos) {
            if (signo.verificaData(dataNascimento)) {
                return signo;
            }
        }
        return null;
    }
}
