package com.example.quizler.util.mapper

interface DataMapper<I, O> {
    abstract fun map(input: I): O
}
