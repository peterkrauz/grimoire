object ModulePaths {
    const val common = ":common"
    const val data = ":data"
    const val domain = ":domain"

    object Presentation {
        private const val packageName = ":presentation"
        const val home = "$packageName:home"
        const val notes = "$packageName:notes"
        const val characters = "$packageName:characters"
    }
}
