package com.example.project1892.Domain

import java.io.Serializable

class ItemDomain : Serializable {
    var title: String? = null
    var address: String? = null
    var description: String? = null
    var pic: String? = null
    var duration: String? = null
    var timeTour: String? = null
    var dateTour: String? = null
    var tourGuideName: String? = null
    var tourGuidePhone: String? = null
    var tourGuidePic: String? = null
    var price: Int = 0
    var bed: Int = 0
    var distance: String? = null
    var score: Double = 0.0
}
