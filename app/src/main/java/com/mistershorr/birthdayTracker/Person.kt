package com.mistershorr.birthdayTracker

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

//Backendless & other online BaaS
@Parcelize
data class Person(
    var name : String = "Default Person",
    var birthday : Date = Date(1646932056741),
    var budget : Double = .99,
    var desiredGift : String = "String",
    var previousGifts : List<String> = listOf(),
    var previousGiftsToMe : List<String> = listOf(),
    var giftPurchased : Boolean = false,
    var ownerId : String? = null,
    var objectId : String? = null
) : Parcelable

//TODO: have methods to return calculated values of age, days until birthday