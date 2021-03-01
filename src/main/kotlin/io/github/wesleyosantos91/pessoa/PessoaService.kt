package io.github.wesleyosantos91.pessoa

import io.github.wesleyosantos91.exception.ObjectNotFoundException
import io.github.wesleyosantos91.proto.CreatePessoa
import io.github.wesleyosantos91.proto.PessoaListReply
import io.github.wesleyosantos91.proto.PessoaReply
import io.github.wesleyosantos91.utils.DateUtils
import io.github.wesleyosantos91.proto.UpdatePessoa
import java.time.LocalDate
import javax.inject.Singleton

@Singleton
class PessoaService(private val repository: PessoaRepository) {

    fun getAll() : PessoaListReply {

        val reply = PessoaListReply.newBuilder()
        for (pessoa in repository.findAll()) {
            val (codigo, nome, dataNascimento, cpf, email) = pessoa;
            reply.addPessoas(pessoaReply(codigo, nome, cpf, dataNascimento, email))
        }

        return reply.build();

    }

    fun getById(codigo: Long) : PessoaReply {
        val (codigoUpdate, nome, dataNascimento, cpf, email) = repository.findById(codigo).orElseThrow{
            throw ObjectNotFoundException("Pessoa não encontrada com código: ${codigo} informado.")
        }

        return pessoaReply(codigoUpdate, nome, cpf, dataNascimento, email)
    }

    fun insert(request: CreatePessoa?) : PessoaReply {

        val (codigo, nome, dataNascimento, cpf, email) = repository.save(
            Pessoa(
                null,
                request?.nome!!,
                DateUtils().toLocalDate(request.dataNascimento)!!,
                request.cpf,
                request.email
            )
        )

        return pessoaReply(codigo, nome, cpf, dataNascimento, email)
    }

    fun update(request: UpdatePessoa?) : PessoaReply {

        var pessoa =  repository.findById(request?.codigo!!).orElseThrow{
            throw ObjectNotFoundException("Pessoa não encontrada com código: ${request.codigo} informado.")
        }
        pessoa.nome = request.nome
        pessoa.dataNascimento = DateUtils().toLocalDate(request.dataNascimento)!!
        pessoa.cpf = request.cpf
        pessoa.email = request.email

        val (codigo, nome, dataNascimento, cpf, email) = repository.update(pessoa)

        return pessoaReply(codigo, nome, cpf, dataNascimento, email)

    }

    fun remove(codigo: Long) {
        exists(codigo)

        repository.deleteById(codigo)
    }

    private fun exists(codigo: Long) {
        repository.findById(codigo).orElseThrow {
            throw ObjectNotFoundException("Pessoa não encontrada com código: ${codigo} informado.")
        }
    }

    private fun pessoaReply(
        codigo: Long?,
        nome: String,
        cpf: String,
        dataNascimento: LocalDate,
        email: String
    ) = PessoaReply.newBuilder()
        .setCodigo(codigo!!)
        .setNome(nome)
        .setCpf(cpf)
        .setDataNascimento(DateUtils().fromLocalDate(dataNascimento))
        .setEmail(email)
        .build()
}