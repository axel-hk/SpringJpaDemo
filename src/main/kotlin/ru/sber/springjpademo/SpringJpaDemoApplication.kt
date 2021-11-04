package ru.sber.springjpademo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.domain.PageRequest
import ru.sber.springjpademo.persistence.entity.*

import ru.sber.springjpademo.persistence.repository.CustomWorkerRepository
import ru.sber.springjpademo.persistence.repository.WorkerPagingRepository
import ru.sber.springjpademo.persistence.repository.WorkerRepository
import java.time.LocalDate

@SpringBootApplication
class SpringJpaDemoApplication(
    private val workerRepository: WorkerRepository,
    private val workerPagingRepository: WorkerPagingRepository,
    private val customWorkerRepository: CustomWorkerRepository
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val worker1 = Worker(
            name = "Petr",
            email = "petr@worker.ru",
            workingType = WorkingType.FULL_TIME,
            birthDate = LocalDate.now().minusYears(20),
            personalData = PersonalData("123", "74839"),
            homeAddress = HomeAddress(street = "Кутузовский пр-т", homeNumber = 12),
            Kids = mutableSetOf(Kid(name = "Alex", serName = "Ann", sex = "Male"), Kid(name="Ann", serName = "Ann", sex = "Female"))
        )
        val worker2 = Worker(
            name = "Ivan",
            email = "ivan@sworker.ru",
            workingType = WorkingType.PART_TIME,
            birthDate = LocalDate.now().minusYears(24),
            personalData = PersonalData("543", "341444"),
            homeAddress = HomeAddress(street = "Ленина", homeNumber = 75),
            Kids = mutableSetOf(Kid(name = "Mary", serName = "Beaty", sex = "Female"))
        )
        val workers = mutableListOf<Worker>(worker1,worker2)

        workerRepository.saveAll(workers)


        val fullWork = workerRepository.findWorkingType(WorkingType.FULL_TIME)
        val partWork = workerRepository.findWorkingType(WorkingType.FULL_TIME)

        println(fullWork)

        println(partWork)
        val pageResult = workerPagingRepository.findAll(PageRequest.of(1, 2))
        println("Total elements: ${pageResult.totalElements}")
        println("Total pages: ${pageResult.totalPages}")
        println("page 1: ${pageResult.content}")

        val resultAll = customWorkerRepository.findAllWorkers()
        println(resultAll)
        workerRepository.delete(worker1)
        val updateResult = customWorkerRepository.findAllWorkers()
        println(resultAll)
    }
}

fun main(args: Array<String>) {
    runApplication<SpringJpaDemoApplication>(*args)
}
