package br.com.teste3.executers

import br.com.teste3.domain.Semaforo
import br.com.teste3.enums.StatusSemaforoEnum
import java.util.concurrent.TimeUnit

class ExecutaSemaforo(private var semaforo: Semaforo) {
    fun semforoEmEstadoInicial(): Boolean = this.semaforo.isEstadoInicial()

    fun inicia() {
        var statusExecucaco = true
        while (statusExecucaco) {

            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(this.semaforo.tempoExecucao()))
                this.semaforo = this.semaforo.proximoStatusSemaforo()
            } catch (e: Exception) {
                statusExecucaco = false
            }
        }
    }

    fun statusAtualSemaforo(): StatusSemaforoEnum = this.semaforo.statusSemaforoEnum
}
