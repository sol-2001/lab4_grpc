package org.example.server;

import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixServiceImpl extends MatrixServiceGrpc.MatrixServiceImplBase {

    private final ExecutorService executorService = Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()));

    @Override
    public void multiply(MatrixRequest request, StreamObserver<MatrixResponse> responseObserver) {
        // Получаем матрицы из запроса
        List<Row> rowsA = request.getRowsAList();
        List<Row> rowsB = request.getRowsBList();

        // Преобразуем их во массивы
        double[][] matrixA = convertTo2DArray(rowsA);
        double[][] matrixB = convertTo2DArray(rowsB);

        // Проверяем, возможно ли умножение
        int aRows = matrixA.length;
        int aCols = matrixA[0].length;
        int bRows = matrixB.length;
        int bCols = matrixB[0].length;

        if (aCols != bRows) {
            responseObserver.onError(
                    new IllegalArgumentException("Невозможно умножить: число столбцов A != числу строк B.")
            );
            return;
        }

        // Асинхронно
        CompletableFuture.supplyAsync(() -> multiplyMatrices(matrixA, matrixB), executorService)
                .thenApply(this::convertToMatrixResponse)
                .thenAccept(responseObserver::onNext)
                .thenRun(responseObserver::onCompleted)
                .exceptionally(throwable -> {
                    responseObserver.onError(throwable);
                    return null;
                });
    }

    private double[][] multiplyMatrices(double[][] A, double[][] B) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bRows = B.length;
        int bCols = B[0].length;

        double[][] C = new double[aRows][bCols];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                double sum = 0;
                for (int k = 0; k < aCols; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        return C;
    }

    // Преобразуем список Row в массив
    private double[][] convertTo2DArray(List<Row> rows) {
        if (rows.isEmpty()) {
            return new double[0][0];
        }

        int rowCount = rows.size();
        int colCount = rows.get(0).getColsCount();
        double[][] matrix = new double[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            List<Double> rowData = rows.get(i).getColsList();
            for (int j = 0; j < colCount; j++) {
                matrix[i][j] = rowData.get(j);
            }
        }

        return matrix;
    }

    // Преобразуем массив в MatrixResponse
    private MatrixResponse convertToMatrixResponse(double[][] matrix) {
        MatrixResponse.Builder responseBuilder = MatrixResponse.newBuilder();
        for (double[] row : matrix) {
            Row.Builder rowBuilder = Row.newBuilder();
            for (double value : row) {
                rowBuilder.addCols(value);
            }
            responseBuilder.addRows(rowBuilder);
        }
        return responseBuilder.build();
    }
}


