plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    //id ("kotlin-kapt") //este es para usar kapt para room
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.ucb.framework"
    compileSdk = 35

    defaultConfig {
        minSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //para room
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.ktx)
    //kapt (libs.androidx.room.compiler)
    ksp("androidx.room:room-compiler:2.7.1")


    implementation(project(":data"))
    implementation(project(":domain"))
}