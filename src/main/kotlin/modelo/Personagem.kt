package modelo

data class Personagem(
    val nome: String,
    val raca: Raca,
    var forca: Int,
    var destreza: Int,
    var constituicao: Int,
    var inteligencia: Int,
    var sabedoria: Int,
    var carisma: Int
) {
    val pontosDeVida: Int = 10 + calcularModificador(constituicao)

    init {
        aplicarBonusRaciais()
    }

    fun aplicarBonusRaciais() {
        when (raca) {
            Raca.ANAO -> constituicao += 2
            Raca.ELFO -> destreza += 2
            Raca.HUMANO -> {
                forca += 1
                destreza += 1
                constituicao += 1
                inteligencia += 1
                sabedoria += 1
                carisma += 1
            }
            Raca.HALFLING -> destreza += 2
        }
    }

    private fun calcularModificador(atributo: Int): Int {
        return (atributo - 10) / 2
    }
}
