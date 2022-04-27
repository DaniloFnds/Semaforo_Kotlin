package br.com.teste3.domain

import br.com.teste3.enums.StatusSemaforoEnum

class Semaforo(val statusSemaforoEnum: StatusSemaforoEnum = StatusSemaforoEnum.AMARELO) {

    fun proximoStatusSemaforo(): Semaforo = Semaforo(this.statusSemaforoEnum.proximo())

    fun isEstadoInicial(): Boolean =StatusSemaforoEnum.AMARELO == this.statusSemaforoEnum

    fun tempoExecucao(): Long = this.statusSemaforoEnum.getTempoExecucao()
}