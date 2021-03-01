package io.github.wesleyosantos91.pessoa

import io.github.wesleyosantos91.proto.Pessoa as PessoaProto
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    var codigo: Long?,

    @Column(name = "nome")
    var nome: String,

    @Column(name = "data_nascimento")
    var dataNascimento: LocalDate,

    @Column(name = "cpf")
    var cpf: String,

    @Column(name = "email")
    var email: String,
) {}