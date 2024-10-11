package estrategia

import modelo.Atributo
import java.util.Scanner

class DistribuicaoPersonalizada : DistribuicaoDeAtributosEstrategia {

    private val custoPontos = mapOf(
        8 to 0,
        9 to 1,
        10 to 2,
        11 to 3,
        12 to 4,
        13 to 5,
        14 to 7,
        15 to 9
    )

    override fun distribuirAtributos(): Map<Atributo, Int> {
        val scanner = Scanner(System.`in`)
        val pontosDisponiveis = 27
        val distribuicao = mutableMapOf<Atributo, Int>()
        var pontosRestantes = pontosDisponiveis

        for (atributo in Atributo.entries) {
            var pontos: Int
            do {
                println("Você tem $pontosRestantes pontos restantes.")
                println("Digite os pontos para ${atributo.name.lowercase().replaceFirstChar { it.uppercase() }}:")
                pontos = scanner.nextInt()

                val custo = custoPontos[pontos] ?: Int.MAX_VALUE

                if (pontos in 8..15 && custo <= pontosRestantes) {
                    pontosRestantes -= custo
                    distribuicao[atributo] = pontos
                    break
                } else {
                    println("Valor inválido ou pontos insuficientes. Custo do valor escolhido: $custo. Tente novamente.")
                }
            } while (true)
        }

        return distribuicao
    }
}
