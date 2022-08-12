package com.kursor.chroniclesofww2.model.game

import com.kursor.chroniclesofww2.model.serializable.Player

class GamePlayer(
    val name: String,
    val divisionResources: DivisionResources,
    val nation: Nation,
    val isInitiator: Boolean
) {
    constructor(player: Player): this(
        player.name,
        DivisionResources(player.divisionResourcesMap, player.name),
        player.nation,
        player.isInitiator
    )
}