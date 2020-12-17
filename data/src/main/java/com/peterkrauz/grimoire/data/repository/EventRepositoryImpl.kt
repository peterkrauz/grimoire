package com.peterkrauz.grimoire.data.repository

import com.peterkrauz.grimoire.data.dao.EventDao
import com.peterkrauz.grimoire.domain.entity.event.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(private val dao: EventDao) : EventRepository
