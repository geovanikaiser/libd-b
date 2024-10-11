package main

import estrategia.DistribuicaoPersonalizada
import modelo.Personagem
import modelo.Raca
import java.util.Scanner
import modelo.Atributo


fun main() {
    val scanner = Scanner(System.`in`)

    println("Digite o nome do personagem:")
    val nome = scanner.nextLine()

    println("Escolha a raça do personagem:")
    println("1 - ANAO")
    println("2 - ELFO")
    println("3 - HUMANO")
    println("4 - HALFLING")
    val escolhaRaca = scanner.nextInt()
    val raca = when (escolhaRaca) {
        1 -> Raca.ANAO
        2 -> Raca.ELFO
        3 -> Raca.HUMANO
        4 -> Raca.HALFLING
        else -> {
            println("Opção inválida, definindo raça como HUMANO por padrão.")
            Raca.HUMANO
        }
    }

    // Distribuir pontos de atributos personalizados
    val estrategia = DistribuicaoPersonalizada()
    val atributosDistribuidos = estrategia.distribuirAtributos()

    // Criar o personagem com os valores informados pelo usuárioo
    val personagem = Personagem(
        nome = nome,
        raca = raca,
        forca = atributosDistribuidos[Atributo.FORCA] ?: 10,
        destreza = atributosDistribuidos[Atributo.DESTREZA] ?: 10,
        constituicao = atributosDistribuidos[Atributo.CONSTITUICAO] ?: 10,
        inteligencia = atributosDistribuidos[Atributo.INTELIGENCIA] ?: 10,
        sabedoria = atributosDistribuidos[Atributo.SABEDORIA] ?: 10,
        carisma = atributosDistribuidos[Atributo.CARISMA] ?: 10
    )

    personagem.aplicarBonusRaciais()

    // Exibir o personagem criado
    println("Personagem criado com sucesso!")
    println(personagem)
}
