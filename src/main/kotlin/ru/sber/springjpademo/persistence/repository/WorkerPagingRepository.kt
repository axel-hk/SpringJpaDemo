package ru.sber.springjpademo.persistence.repository

import org.springframework.data.repository.PagingAndSortingRepository
import ru.sber.springjpademo.persistence.entity.Worker

interface WorkerPagingRepository: PagingAndSortingRepository<Worker, Long>