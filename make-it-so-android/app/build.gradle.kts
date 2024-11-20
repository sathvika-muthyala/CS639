plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
    id("dagger.hilt.android.plugin")
    id("com.ncorti.ktfmt.gradle") version "0.10.0"
    id("org.jetbrains.compose") version "1.5.2" apply false
}


android {
    compileSdk = 35
    namespace = "com.example.makeitso"

    defaultConfig {
        applicationId = "com.example.makeitso"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.makeitso.MakeItSoTestRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    flavorDimensions += "environment"
    productFlavors {
        create("dev")
        create("staging")
        create("prod")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
    packaging {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

// In settings.gradle.kts


ktfmt {
    googleStyle()
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation(platform("androidx.compose:compose-bom:2024.11.00"))
    implementation("androidx.compose.ui:ui:1.7.5")
    implementation("androidx.compose.material:material:1.7.5")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material-icons-extended:1.7.5")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.navigation:navigation-compose:2.8.4")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
    implementation("com.google.accompanist:accompanist-permissions:0.30.1")
    implementation("com.google.dagger:hilt-android:2.49")
    ksp("com.google.dagger:hilt-compiler:2.47")

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-perf")
    implementation("com.google.firebase:firebase-config")
    implementation("com.google.firebase:firebase-messaging")

    //Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.5")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.43.2")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    kspAndroidTest("com.google.dagger:hilt-compiler:2.47")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Required for AndroidJUnitRunner
    androidTestImplementation("androidx.test:runner:1.5.1")

    // Optional but often useful
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

