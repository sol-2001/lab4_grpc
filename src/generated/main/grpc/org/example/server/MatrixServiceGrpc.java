package org.example.server;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.0)",
    comments = "Source: matrix_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MatrixServiceGrpc {

  private MatrixServiceGrpc() {}

  public static final String SERVICE_NAME = "MatrixService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.server.MatrixRequest,
      org.example.server.MatrixResponse> getMultiplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "multiply",
      requestType = org.example.server.MatrixRequest.class,
      responseType = org.example.server.MatrixResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.server.MatrixRequest,
      org.example.server.MatrixResponse> getMultiplyMethod() {
    io.grpc.MethodDescriptor<org.example.server.MatrixRequest, org.example.server.MatrixResponse> getMultiplyMethod;
    if ((getMultiplyMethod = MatrixServiceGrpc.getMultiplyMethod) == null) {
      synchronized (MatrixServiceGrpc.class) {
        if ((getMultiplyMethod = MatrixServiceGrpc.getMultiplyMethod) == null) {
          MatrixServiceGrpc.getMultiplyMethod = getMultiplyMethod =
              io.grpc.MethodDescriptor.<org.example.server.MatrixRequest, org.example.server.MatrixResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "multiply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.server.MatrixRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.server.MatrixResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MatrixServiceMethodDescriptorSupplier("multiply"))
              .build();
        }
      }
    }
    return getMultiplyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MatrixServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatrixServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MatrixServiceStub>() {
        @java.lang.Override
        public MatrixServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MatrixServiceStub(channel, callOptions);
        }
      };
    return MatrixServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MatrixServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatrixServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MatrixServiceBlockingStub>() {
        @java.lang.Override
        public MatrixServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MatrixServiceBlockingStub(channel, callOptions);
        }
      };
    return MatrixServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MatrixServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MatrixServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MatrixServiceFutureStub>() {
        @java.lang.Override
        public MatrixServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MatrixServiceFutureStub(channel, callOptions);
        }
      };
    return MatrixServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Метод для умножения двух матриц
     * </pre>
     */
    default void multiply(org.example.server.MatrixRequest request,
        io.grpc.stub.StreamObserver<org.example.server.MatrixResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMultiplyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MatrixService.
   */
  public static abstract class MatrixServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MatrixServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MatrixService.
   */
  public static final class MatrixServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MatrixServiceStub> {
    private MatrixServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatrixServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatrixServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Метод для умножения двух матриц
     * </pre>
     */
    public void multiply(org.example.server.MatrixRequest request,
        io.grpc.stub.StreamObserver<org.example.server.MatrixResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMultiplyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MatrixService.
   */
  public static final class MatrixServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MatrixServiceBlockingStub> {
    private MatrixServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatrixServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatrixServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Метод для умножения двух матриц
     * </pre>
     */
    public org.example.server.MatrixResponse multiply(org.example.server.MatrixRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMultiplyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MatrixService.
   */
  public static final class MatrixServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MatrixServiceFutureStub> {
    private MatrixServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MatrixServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MatrixServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Метод для умножения двух матриц
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.server.MatrixResponse> multiply(
        org.example.server.MatrixRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMultiplyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MULTIPLY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MULTIPLY:
          serviceImpl.multiply((org.example.server.MatrixRequest) request,
              (io.grpc.stub.StreamObserver<org.example.server.MatrixResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getMultiplyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.example.server.MatrixRequest,
              org.example.server.MatrixResponse>(
                service, METHODID_MULTIPLY)))
        .build();
  }

  private static abstract class MatrixServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MatrixServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.server.MatrixServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MatrixService");
    }
  }

  private static final class MatrixServiceFileDescriptorSupplier
      extends MatrixServiceBaseDescriptorSupplier {
    MatrixServiceFileDescriptorSupplier() {}
  }

  private static final class MatrixServiceMethodDescriptorSupplier
      extends MatrixServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MatrixServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MatrixServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MatrixServiceFileDescriptorSupplier())
              .addMethod(getMultiplyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
