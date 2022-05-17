val kotlin_version = "1.6.10"
plugins {
    kotlin("jvm") version "1.6.10"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

    dependencies {
        testImplementation("org.slf4j:slf4j-api:1.7.36")
        testImplementation("org.slf4j:slf4j-simple:1.7.36")

        testImplementation(kotlin("test"))
        compileOnly(kotlin("test"))
        compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
        implementation("org.litote.kmongo:kmongo:4.6.0")
        testImplementation("org.litote.kmongo:kmongo:4.6.0")

    }

}

