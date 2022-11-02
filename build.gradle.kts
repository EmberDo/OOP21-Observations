plugins {
    kotlin("jvm") version "1.7.20"
    java
    application
    id ("com.github.johnrengelman.shadow") version "7.1.2"
}

group "org"
version "1.0"

repositories {
    mavenCentral()
}

val javaFXModules = listOf(
        "base",
        "controls",
        "graphics"
)

val supportedPlatforms = listOf("linux", "mac", "win")
val jUnitVersion = "5.7.1"
val javaFxVersion = "17.0.2"

dependencies {
    for (platform in supportedPlatforms) {
        for (module in javaFXModules) {
            implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
        }
    }

    // https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox
    implementation("org.apache.pdfbox:pdfbox:2.0.27")

    // JUnit API and testing engine
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jUnitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jUnitVersion")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainModule.set("org.observations")
    mainClass.set("org.observations.AppLauncher")
}