package com.example.naturelife.domain

abstract class Mapper<F, T> {
    abstract fun mapFrom(from: F): T
}