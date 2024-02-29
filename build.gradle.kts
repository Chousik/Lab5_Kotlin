plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "labs"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}
application {
    mainClass.set("org.chousik.Main")
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}


tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}