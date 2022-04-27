package br.com.teste3.enums

enum class StatusSemaforoEnum(private val ordemSemaforo: Int, private val tempoExecucao: Long) {
    AMARELO(0, 10),
    VERMELHO(1, 40),
    VERDE(2, 60);

    fun proximo(): StatusSemaforoEnum {
        return getStatusSemforoPelaOrdem(this.ordemSemaforo.plus(1))
    }

    private fun getStatusSemforoPelaOrdem(ordemSemaforo: Int): StatusSemaforoEnum {
        ordemSemaforo.let {
            if (it > StatusSemaforoEnum.values().size.minus(1)) {
                it.minus(1)
            }
            it
        }.let {
            return StatusSemaforoEnum.values()[it]
        }
    }

    fun getTempoExecucao() = this.tempoExecucao
}