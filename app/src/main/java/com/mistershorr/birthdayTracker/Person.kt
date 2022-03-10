package com.mistershorr.birthdayTracker

import java.util.*

//Backendless & other online BaaS
data class Person(
    var name : String = "Default Person",
    var birthday : Date = Date(1646932056741),
    var budget : Double = .99,
    var desiredGift : String = "String",
    var previousGifts : List<String> = listOf(),
    var previousGiftsToMe : List<String>,
    var giftPurchased : Boolean = false
)

//TODO: have methods to return calculated values of age, days until birthday