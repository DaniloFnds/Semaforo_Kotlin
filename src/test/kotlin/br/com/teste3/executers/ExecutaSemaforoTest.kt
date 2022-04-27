package br.com.teste3.executers

import br.com.teste3.domain.Semaforo
import br.com.teste3.enums.StatusSemaforoEnum
import org.junit.jupiter.api.Assertions
import java.util.concurrent.TimeUnit
import kotlin.test.Test

class ExecutaSemaforoTest {
    @Test
    fun `DEVE Executar um Semaforo QUANDO Status eh Inicial`() {
        val executa = ExecutaSemaforo(Semaforo())
        Assertions.assertTrue(executa.semforoEmEstadoInicial())
    }

    @Test
    fun `NAO DEVE Executar um Semaforo QUANDO Status nao eh Inicial`() {
        val executa = ExecutaSemaforo(Semaforo(StatusSemaforoEnum.VERDE))
        Assertions.assertFalse(executa.semforoEmEstadoInicial())
    }

    @Test
    fun `DEVE Mudar Status Semaforo QUANDO Atingir Tempo`() {
        val executa = ExecutaSemaforo(Semaforo(StatusSemaforoEnum.AMARELO))

        val thread = Thread {
            executa.inicia()
        }
        thread.start()
        Thread.sleep(TimeUnit.SECONDS.toMillis(15))
        thread.interrupt()
        Assertions.assertEquals(StatusSemaforoEnum.VERMELHO, executa.statusAtualSemaforo())

    }
}