plugins {
    kotlin("jvm")
    application
}

kotlin {
    sourceSets {
        @Suppress("UNUSED_VARIABLE")
        val main by getting {
            dependencies {
                implementation(project(":common"))
                implementation("com.github.kotlin-everywhere.kenet:kenet-client-jvm:7c39638c32")
            }
        }
    }
}


application {
    mainClass.set("MainKt")
}