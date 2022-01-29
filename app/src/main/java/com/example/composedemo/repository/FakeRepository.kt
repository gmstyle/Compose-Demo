package com.example.composedemo.repository

interface FakeRepository {
    fun sayHello() : String
}

class FakeRepositoryImpl : FakeRepository {
    override fun sayHello(): String = "Hello Koin"
}