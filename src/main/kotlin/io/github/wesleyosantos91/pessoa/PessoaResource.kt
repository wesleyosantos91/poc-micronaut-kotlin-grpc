package io.github.wesleyosantos91.pessoa

import io.github.wesleyosantos91.exception.ObjectNotFoundException
import io.github.wesleyosantos91.proto.*
import io.github.wesleyosantos91.proto.Pessoa
import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.grpc.stub.StreamObserver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class PessoaResource(private val service: PessoaService) : PessoaServiceGrpc.PessoaServiceImplBase() {

    val LOGGER: Logger = LoggerFactory.getLogger(PessoaResource::class.java.name)

    override fun getAll(request: Empty?, responseObserver: StreamObserver<PessoaListReply>?) {

        try {
            responseObserver?.onNext(service.getAll())
            responseObserver?.onCompleted();
        } catch (e: Exception) {
            LOGGER.error("onError : {}" , e.message);
            responseObserver?.onError(StatusRuntimeException(Status.INTERNAL.withDescription(e.message)));
        }
    }

    override fun getById(request: PessoaRequestId?, responseObserver: StreamObserver<PessoaReply>?) {
        try {
            responseObserver?.onNext(service.getById(request?.codigo!!))
            responseObserver?.onCompleted();
        }catch (e: ObjectNotFoundException) {
            LOGGER.error("onError : {}" , e.message);
            responseObserver?.onError(StatusRuntimeException(Status.NOT_FOUND.withDescription(e.message)));
        } catch (e: Exception) {
            LOGGER.error("onError : {}" , e.message);
            responseObserver?.onError(StatusRuntimeException(Status.INTERNAL.withDescription(e.message)));
        }
    }

    override fun insert(request: CreatePessoa?, responseObserver: StreamObserver<PessoaReply>?) {
        try {
            responseObserver?.onNext(service.insert(request))
            responseObserver?.onCompleted();
        } catch (e: Exception) {
            LOGGER.error("onError : {}" , e.message);
            responseObserver?.onError(StatusRuntimeException(Status.ALREADY_EXISTS.withDescription(e.message)));
        }
    }

    override fun update(request: UpdatePessoa?, responseObserver: StreamObserver<PessoaReply>?) {
        try {
            responseObserver?.onNext(service.update(request))
            responseObserver?.onCompleted();
        }catch (e: ObjectNotFoundException) {
            LOGGER.error("onError : {}" , e.message);
            responseObserver?.onError(StatusRuntimeException(Status.NOT_FOUND.withDescription(e.message)));
        } catch (e: Exception) {
            LOGGER.error("onError : {}" , e.message);
            responseObserver?.onError(StatusRuntimeException(Status.INTERNAL.withDescription(e.message)));
        }
    }

    override fun remove(request: PessoaRequestId?, responseObserver: StreamObserver<Empty>?) {
        try {
            service.remove(request?.codigo!!)
            responseObserver?.onNext(Empty.newBuilder().build())
            responseObserver?.onCompleted();
        } catch (e: Exception) {
            LOGGER.error("onError : {}" , e.message);
            responseObserver?.onError(StatusRuntimeException(Status.INTERNAL.withDescription(e.message)));
        }
    }


}