package org.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new MatrixServiceImpl())
                .build();

        //Стартуууем
        server.start();
        System.out.println("gRPC server start on port: 50051");

        server.awaitTermination();
    }
}
