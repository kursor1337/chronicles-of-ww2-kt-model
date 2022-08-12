package com.kursor.chroniclesofww2.model.serializable

import com.kursor.chroniclesofww2.model.game.Nation
import com.kursor.chroniclesofww2.model.game.board.Division
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val name: String,
    val divisionResourcesMap: Map<Division.Type, Int>,
    val nation: Nation,
    val isInitiator: Boolean
) {
}