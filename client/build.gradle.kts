plugins {
    kotlin("jvm")
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    application
    java
}
val ktlintC by configurations.creating
group = "org.example"
version = "2.0"

repositories {
    mavenCentral()
}
application {
    mainClass.set("org.example.RunKt")
}
tasks {
    val fatJar =
        register<Jar>("fatJar") {
            dependsOn.addAll(listOf("compileJava", "compileKotlin", "processResources"))
            archiveClassifier.set("standalone")
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            manifest { attributes(mapOf("Main-Class" to application.mainClass)) }
            val sourcesMain = sourceSets.main.get()
            val contents =
                configurations.runtimeClasspath.get()
                    .map { if (it.isDirectory) it else zipTree(it) } +
                    sourcesMain.output
            from(contents)
        }
    build {
        dependsOn(fatJar)
    }
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(project(":common"))
    ktlintC("com.pinterest.ktlint:ktlint-cli:1.2.1") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}
val ktlintCheckC by tasks.registering(JavaExec::class) {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style"
    classpath = ktlintC
    mainClass.set("com.pinterest.ktlint.Main")
    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
    args(
        "**/src/**/*.kt",
        "**.kts",
        "!**/build/**",
    )
}

tasks.check {
    dependsOn(ktlintCheckC)
}

tasks.register<JavaExec>("ktlintFormatS") {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style and format"
    classpath = ktlintC
    mainClass.set("com.pinterest.ktlint.Main")
    jvmArgs("--add-opens=java.base/java.lang=ALL-UNNAMED")
    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
    args(
        "-F",
        "**/src/**/*.kt",
        "**.kts",
        "!**/build/**",
    )
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
