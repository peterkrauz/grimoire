package com.peterkrauz.grimoire.presentation.home.errors

sealed class ArcException : Exception()

object ArcNotFoundException : ArcException()
