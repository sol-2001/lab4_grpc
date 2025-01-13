plugins {
    java
    idea
    // Плагин для генерации gRPC кода
    id("com.google.protobuf") version "0.9.4"
    // Плагин для Lombok
    id("io.freefair.lombok") version "8.0.1"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    // gRPC
    implementation("io.grpc:grpc-netty:1.56.0")
    implementation("io.grpc:grpc-protobuf:1.56.0")
    implementation("io.grpc:grpc-stub:1.56.0")

    // Для аннотаций (optional)
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    // Тестирование
    testImplementation("junit:junit:4.9")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.0.0"
    }
    // Папка для сгенерированных файлов
    generatedFilesBaseDir = "$projectDir/src/generated"

    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.56.0"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("grpc")            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
