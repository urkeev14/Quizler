package com.example.quizler.feature.onboarding.register

import com.example.quizler.domain.data.response.RegisterResponse
import com.example.quizler.domain.model.Player
import com.example.quizler.util.mapper.DataMapper

class RegisterPlayerUserCaseMapper : DataMapper<RegisterResponse, Player> {
    override fun map(input: RegisterResponse): Player {
        return Player(
            id = input.playerId,
            username = "Loaded from JWT",
            email = "Loaded from JWT",
            password = "See how to handle this"
        )
    }
}
