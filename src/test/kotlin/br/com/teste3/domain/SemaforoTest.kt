package br.com.teste3.domain

import br.com.teste3.enums.StatusSemaforoEnum
import org.junit.jupiter.api.Assertions
import kotlin.test.Test

class SemaforoTest {

    @Test
    internal fun `DEVE iniciar com status parametrizavel`() {
        val semaforo = Semaforo(StatusSemaforoEnum.AMARELO)
        Assertions.assertEquals(StatusSemaforoEnum.AMARELO, semaforo.statusSemaforoEnum)
    }

    @Test
    internal fun `DEVE trocar status Semaforo para Vermelho`() {
        var semaforo = Semaforo()
        semaforo = semaforo.proximoStatusSemaforo()

        Assertions.assertEquals(StatusSemaforoEnum.VERMELHO, semaforo.statusSemaforoEnum)
    }

    @Test
    internal fun `DEVE trocar status Semaforo para Verde QUAANDO Solcitado 2x`() {
        var semaforo = Semaforo(StatusSemaforoEnum.AMARELO)
        semaforo = semaforo.proximoStatusSemaforo()
        semaforo = semaforo.proximoStatusSemaforo()

        Assertions.assertEquals(StatusSemaforoEnum.VERDE, semaforo.statusSemaforoEnum)

    }
}