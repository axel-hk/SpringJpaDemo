package ru.sber.springjpademo.persistence.repository

import org.hibernate.SessionFactory
import org.springframework.stereotype.Repository
import ru.sber.springjpademo.persistence.entity.Worker
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
class CustomWorkerRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager
) : CustomWorkerRepository {

    override fun findAllWorkers(): List<Worker> =
        entityManager.createQuery("from Worker").resultList as List<Worker>


}