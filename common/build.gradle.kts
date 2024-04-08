plugins {
    kotlin("jvm")
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}
val ktlintCom by configurations.creating
group = "org.example"
version = "2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.apache.poi:poi:5.2.0")
    implementation("org.apache.poi:poi-ooxml:5.2.0")
    ktlintCom("com.pinterest.ktlint:ktlint-cli:1.2.1") {
        attributes {
            attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
        }
    }
}
val ktlintCheckCom by tasks.registering(JavaExec::class) {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style"
    classpath = ktlintCom
    mainClass.set("com.pinterest.ktlint.Main")
    // see https://pinterest.github.io/ktlint/install/cli/#command-line-usage for more information
    args(
        "**/src/**/*.kt",
        "**.kts",
        "!**/build/**",
    )
}

tasks.check {
    dependsOn(ktlintCheckCom)
}

tasks.register<JavaExec>("ktlintFormatCom") {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Check Kotlin code style and format"
    classpath = ktlintCom
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
