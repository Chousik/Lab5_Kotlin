plugins {
    kotlin("jvm") version "1.9.21"
    application
    java
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

group = "Lab5_Kotlin"
version = "2.0"
val ktlintM by configurations.creating

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    ktlintM("com.pinterest.ktlint:ktlint-cli:1.2.1") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}
val ktlintCheckM by tasks.registering(JavaExec::class) {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style"
    classpath = ktlintM
    mainClass.set("com.pinterest.ktlint.Main")
    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
    args(
        "**/src/**/*.kt",
        "**.kts",
        "!**/build/**",
    )
}

tasks.check {
    dependsOn(ktlintCheckM)
}

tasks.register<JavaExec>("ktlintFormatS") {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style and format"
    classpath = ktlintM
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
application {
    mainClass.set("org.chousik.Main")
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
kotlin {
    jvmToolchain(17)
}
