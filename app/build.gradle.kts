import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.jetbrainsKotlinKapt)
    alias(libs.plugins.hilt)
}

// Get keystore properties for API usage
val keystoreProperties = Properties()
val keystorePropertiesFile = project.file("keystore.properties")
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {
    namespace = "com.example.naturelife"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.naturelife"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            "String",
            "WEATHER_KEY",
            "\"${keystoreProperties.getProperty("weatherKey")}\""
        )
        buildConfigField(
            "String",
            "MAPKIT_KEY",
            "\"${keystoreProperties.getProperty("mapkitKey")}\""
        )
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // DI
    implementation(libs.hilt)
    implementation(libs.androidx.lifecycle.service)
    kapt(libs.hilt.compiler)

    // Web
    implementation(libs.retrofit2.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.converter.gson)

    // Map
    implementation(libs.yandex.mapkit)

    // WorkManager
    implementation(libs.androidx.work.runtime.ktx)

    // Preferences
    implementation(libs.androidx.preference.ktx)

    // Permissions
    implementation(libs.permissions)

    // DB
    implementation(libs.androidx.room)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

kapt {
    correctErrorTypes = true
}