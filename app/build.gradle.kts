plugins {
    id("com.android.application")
}

android {
    namespace = "com.neonstudios.notetaker"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.neonstudios.notetaker"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            storeFile = file("../flipstack-release.jks")
            storePassword = System.getenv("KEYSTORE_PASSWORD") ?: "password123"
            keyAlias = "flipstack"
            keyPassword = System.getenv("KEYSTORE_PASSWORD") ?: "password123"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    applicationVariants.all {
        outputs.all {
            this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            outputFileName = "${rootProject.name}-${versionName}.apk"
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
}
