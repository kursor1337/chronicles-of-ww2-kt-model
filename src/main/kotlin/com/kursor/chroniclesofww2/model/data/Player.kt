package com.kursor.chroniclesofww2.model.data

import com.kursor.chroniclesofww2.model.game.DivisionResources
import com.kursor.chroniclesofww2.model.game.Nation
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    val name: String,
    val divisionResources: DivisionResources,
    val nation: Nation,
    val isInitiator: Boolean
)