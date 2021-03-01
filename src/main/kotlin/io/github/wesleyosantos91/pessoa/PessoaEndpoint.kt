package io.github.wesleyosantos91.pessoa

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException
import io.github.wesleyosantos91.exception.interceptor.ErrorHandler
import io.github.wesleyosantos91.proto.*
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.grpc.stub.StreamObserver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@ErrorHandler
@Singleton
class PessoaEndpoint(private val service: PessoaService) : PessoaServiceGrpc.PessoaServiceImplBase() {

    val LOGGER: Logger = LoggerFactory.getLogger(PessoaEndpoint::class.java.name)

    override fun getAll(request: Empty?, responseObserver: StreamObserver<PessoaListReply>?) {

        responseObserver?.onNext(service.getAll())
        responseObserver?.onCompleted();
    }

    override fun getById(request: PessoaRequestId?, responseObserver: StreamObserver<PessoaReply>?) {
        responseObserver?.onNext(service.getById(request?.codigo!!))
        responseObserver?.onCompleted();
    }

    override fun insert(request: CreatePessoa?, responseObserver: StreamObserver<PessoaReply>?) {
        responseObserver?.onNext(service.insert(request))
        responseObserver?.onCompleted();
    }

    override fun update(request: UpdatePessoa?, responseObserver: StreamObserver<PessoaReply>?) {
        responseObserver?.onNext(service.update(request))
        responseObserver?.onCompleted();
    }

    override fun remove(request: PessoaRequestId?, responseObserver: StreamObserver<Empty>?) {
        service.remove(request?.codigo!!)
        responseObserver?.onNext(Empty.newBuilder().build())
        responseObserver?.onCompleted();
    }
}