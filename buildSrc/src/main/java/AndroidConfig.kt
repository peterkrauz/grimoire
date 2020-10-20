import org.gradle.api.JavaVersion

object AndroidConfig {

    const val compileSdkVersion = 30
    const val buildToolsVersion = "29.0.3"
    const val applicationId = "com.peterkrauz.grimoire"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "0.0.2"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val consumerProguardFile = "consumer-rules.pro"

    val javaVersion = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"
}
