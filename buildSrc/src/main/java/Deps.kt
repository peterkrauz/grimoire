object Libs {

    object Kotlin {
        private const val version = "1.3.7"

        const val standardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }

    object Android {
        private const val coreKtxVersion = "1.3.1"
        const val ktx = "androidx.core:core-ktx:$coreKtxVersion"

        private const val appCompatVersion = "1.2.0"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

        private const val constraintLayoutVersion = "2.0.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    }

    object JUnit {
        private const val jUnitVersion = "4.12"
        const val jUnit = "junit:junit:$jUnitVersion"

        private const val jUnitExtVersion = "1.1.2"
        const val jUnitExtension = "androidx.test.ext:junit:$jUnitExtVersion"
    }
}
