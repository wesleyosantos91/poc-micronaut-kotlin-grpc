package io.github.wesleyosantos91.pessoa

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PessoaRepository : JpaRepository<Pessoa, Long> {
}