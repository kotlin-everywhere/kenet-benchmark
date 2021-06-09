plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    
    sourceSets {
        @Suppress("UNUSED_VARIABLE")
        val commonMain by getting {
            dependencies {
                implementation("com.github.kotlin-everywhere.kenet:kenet-dsl:7c39638c32")
            }
        }
    }
}
