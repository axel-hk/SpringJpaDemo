package ru.sber.springjpademo.persistence.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.sber.springjpademo.persistence.entity.Worker
import ru.sber.springjpademo.persistence.entity.HomeAddress
import ru.sber.springjpademo.persistence.entity.WorkingType


@Repository
interface WorkerRepository : CrudRepository<Worker, Long> {
    //auto
    fun findByAddress(specialty: HomeAddress): List<Worker>

    //manual
    @Query("SELECT w FROM Worker w where w.workingType = :type")
    fun findWorkingType(@Param("type") type: WorkingType): List<Worker>
}