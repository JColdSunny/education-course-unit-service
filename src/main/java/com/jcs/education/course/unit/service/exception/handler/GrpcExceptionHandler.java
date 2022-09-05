package com.jcs.education.course.unit.service.exception.handler;

import com.google.rpc.Status;
import com.jcs.education.course.unit.service.exception.RequestValidationException;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.server.advice.GrpcAdvice;

import static com.google.rpc.Code.INVALID_ARGUMENT_VALUE;

@GrpcAdvice
public class GrpcExceptionHandler {

    @net.devh.boot.grpc.server.advice.GrpcExceptionHandler(RequestValidationException.class)
    public StatusRuntimeException handleValidationException(RequestValidationException e) {
        Status invalidAgrStatus = Status.newBuilder()
                .setCode(INVALID_ARGUMENT_VALUE)
                .setMessage(e.getMessage())
                .build();
        return StatusProto.toStatusRuntimeException(invalidAgrStatus);
    }

}
