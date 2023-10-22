package com.tsarenko.langsapp.domain.model

enum class Interest(
    private val value: String,
    private var isSelected: Boolean = false
) {
    SPORTS("Sports"),
    TRAVELLING("Travelling"),
    ART("Art"),
    MOVIES("Movies"),
    CARTOONS("Cartoons"),
    GAMES("Games"),
    FINANCIALS("Financials"),
    PROGRAMMING("Programming"),
    MUSIC("Music"),
    LITERATURE("Literature"),
    SCIENCE("Science");

    override fun toString() = value

    fun isSelected() = isSelected

    fun select() {
        isSelected = true
    }

    fun unselect() {
        isSelected = false
    }

}