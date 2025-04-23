plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.android") version "1.9.22"
}

android {
    namespace = "com.example.adventureapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.adventureapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //Retrofit для сетевых запросов
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Конвертация JSON в объекты
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //kotlin Coroutines (для асинхронности)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //Логирование запросов через консоль
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation ("androidx.viewpager2:viewpager2:1.0.0") //Выделение центральной карточки сюжета в свайп-ленте
    implementation("com.squareup.picasso:picasso:2.71828") //Для загрузки картинок с сервера

    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

}