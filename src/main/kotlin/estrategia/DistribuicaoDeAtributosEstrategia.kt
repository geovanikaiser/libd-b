package estrategia

import modelo.Atributo

interface DistribuicaoDeAtributosEstrategia {
    fun distribuirAtributos(): Map<Atributo, Int>
}
