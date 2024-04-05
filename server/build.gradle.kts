plugins {
    kotlin("jvm")
    application
    java
}

group = "org.example"
version = "2.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(project(":common"))
    implementation("org.apache.poi:poi:5.2.0")
    implementation("org.apache.poi:poi-ooxml:5.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.8.0")
}

application
java

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}