object Kotlin {
    private const val version = "1.3.7"
    const val standardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:$version"
}

object Android {
    private object Versions {
        const val coreKtxVersion = "1.3.1"
        const val appCompatVersion = "1.2.0"
        const val constraintLayoutVersion = "2.0.1"
    }

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
}

object JUnit {
    private object Versions {
        const val jUnitVersion = "4.12"
        const val jUnitExtVersion = "1.1.2"
    }

    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val jUnitExtension = "androidx.test.ext:junit:${Versions.jUnitExtVersion}"
}

object Material {
    private const val version = "1.2.1"
    const val material = "com.google.android.material:material:$version"
}

object Navigation {
    private const val version = "2.3.0"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:$version"
}

object Firebase {
    private object Versions {
        const val analytics = "17.5.0"
    }

    const val analytics = "com.google.firebase:firebase-analytics:${Versions.analytics}"
}

object Room {
    private const val version = "2.5.0"

    const val ktx = "androidx.room:room-ktx:$version"
    const val runtime = "androidx.room:room-runtime:$version"
    const val compiler = "androidx.room:room-compiler:$version"
}