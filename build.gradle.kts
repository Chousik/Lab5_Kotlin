plugins {
    kotlin("jvm") version "1.9.21"
}

group = "labs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.fasterxml.jackson.core:jackson.datatype:2.12.4")
    implementation ("com.fasterxml.jackson.core:com.fasterxml.jackson.datatype.jsr310")
    compileOnly ("org.projectlombok:lombok:1.18.20")
    annotationProcessor ("org.projectlombok:lombok:1.18.20")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}