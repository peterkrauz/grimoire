package com.peterkrauz.grimoire.presentation.home.createarc

sealed class CreateArcException : Exception()

object InvalidTitleException : CreateArcException()
object InvalidDescriptionException : CreateArcException()
