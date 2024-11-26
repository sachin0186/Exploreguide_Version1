package com.example.project1892.Domain

class Location {
    var id: Int = 0
    var loc: String? = null

    override fun toString(): String {
        return loc!!
    }
}
