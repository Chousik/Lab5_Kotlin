plugins {
    kotlin("jvm") version "1.9.21"
}

group = "labs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.12.4")
    implementation("com.google.code.gson:gson:2.9.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}