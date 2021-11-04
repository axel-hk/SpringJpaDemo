package ru.sber.springjpademo.persistence.repository

import ru.sber.springjpademo.persistence.entity.Worker

interface CustomWorkerRepository {
    fun findAllWorkers(): List<Worker>

}