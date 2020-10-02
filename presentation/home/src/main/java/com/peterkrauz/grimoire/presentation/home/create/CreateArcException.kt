package com.peterkrauz.grimoire.presentation.home.create

sealed class CreateArcException : Exception()

object InvalidTitleException : CreateArcException()
object InvalidDescriptionException : CreateArcException()
