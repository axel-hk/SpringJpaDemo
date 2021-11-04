package ru.sber.springjpademo.persistence.entity

import javax.persistence.Basic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class HomeAddress(
    @Id
    @GeneratedValue
    var id: Long = 0,
    var street: String,
    var homeNumber: Int,
)