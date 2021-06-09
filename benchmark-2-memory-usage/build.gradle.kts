plugins {
    kotlin("jvm")
    application
}

kotlin {
    sourceSets {
        @Suppress("UNUSED_VARIABLE")
        val main by getting {
            dependencies {
                implementation(project(":api"))
                implementation("com.github.kotlin-everywhere.kenet:kenet-server-engine-http-jvm:7c39638c32")
            }
        }
    }
}


application {
    mainClass.set("MainKt")
    applicationDefaultJvmArgs = listOf("-Xmx7m")
}