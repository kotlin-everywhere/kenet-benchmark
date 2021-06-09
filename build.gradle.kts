plugins {
    kotlin("jvm") version "1.5.10" apply false
    kotlin("multiplatform") version "1.5.10" apply false
    kotlin("plugin.serialization") version "1.5.0" apply false
}

allprojects {
    repositories {
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}