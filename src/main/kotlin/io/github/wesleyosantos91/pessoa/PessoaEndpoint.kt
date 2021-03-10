package io.github.wesleyosantos91.pessoa

import io.github.wesleyosantos91.exception.interceptor.ErrorHandler
import io.github.wesleyosantos91.proto.*
import io.grpc.stub.StreamObserver
import javax.inject.Singleton

@ErrorHandler
@Singleton
class PessoaEndpoint(private val service: PessoaService) : PessoaServiceGrpc.PessoaServiceImplBase() {

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