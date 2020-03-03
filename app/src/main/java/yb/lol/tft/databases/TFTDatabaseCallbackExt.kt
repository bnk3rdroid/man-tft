package yb.lol.tft.databases

import yb.lol.tft.entities.*

val TFTDatabaseCallback.compositionShadowRanger: Composition
    get() = Composition(
        id = 42,
        name = "Shadow Rangers",
        rank = Rank.S
    )

val TFTDatabaseCallback.championKindred: Champion
    get() = Champion(
        id = 200,
        name = "Kindred",
        cost = 3,
        mana = 35,
        health_lvl_one = 650,
        health_lvl_two = 1170,
        health_lvl_three = 2106,
        starting_mana = 0,
        range = 3,
        attack_damage_lvl_one = 55,
        attack_damage_lvl_two = 99,
        attack_damage_lvl_three = 198,
        attack_speed = 0.75f,
        armor = 20,
        dps_lvl_one = 41,
        dps_lvl_two = 74,
        dps_lvl_three = 149,
        magic_resist = 20
    )

val TFTDatabaseCallback.typeShadow: Type
    get() = Type(
        id = 100,
        name = "Shadow",
        desc = "Shadow champions deal increased damage."
    )

val TFTDatabaseCallback.typeRanger: Type
    get() = Type(
        id = 101,
        name = "Ranger",
        desc = "Rangers have a chance to gain double attack speed."
    )

val TFTDatabaseCallback.itemRabadon: Item
    get() = Item(
        id = 300,
        name = "Rabadon's Deathcap",
        rank = Rank.A,
        desc = "Increases ability power by 75%."
    )

val TFTDatabaseCallback.itemFirecannon: Item
    get() = Item(
        id = 301,
        name = "Rapid Firecannon",
        rank = Rank.A,
        desc = "Attack range is double."
    )

val TFTDatabaseCallback.itemSeraph: Item
    get() = Item(
        id = 302,
        name = "Seraph's Embrace",
        rank = Rank.S,
        desc = "Regain 20 mana each time a spell is cast."
    )

val TFTDatabaseCallback.itemInfinityEdge: Item
    get() = Item(
        id = 303,
        name = "Infinity Edge",
        rank = Rank.S,
        desc = "Critical strikes deal +100% damage."
    )

val TFTDatabaseCallback.itemJeweledGauntlet: Item
    get() = Item(
        id = 304,
        name = "Jeweled Gauntlet",
        rank = Rank.A,
        desc = "Your special ability can critically strike."
    )