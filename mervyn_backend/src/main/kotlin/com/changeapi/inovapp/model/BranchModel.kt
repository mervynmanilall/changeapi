package com.changeapi.inovapp.model

data class BranchLocation(
    val lat: Float,
    val lng: Float
)

data class BranchLink(
    val text: String,
    val href: String
)

data class BranchModel (
    val name: String,
    val address: String,
    val opening_hours: String,
    val information: String,
    val photo: String,
    val location: BranchLocation,
    val link: BranchLink,
    val moreInfo: String,
    val category: String
)

data class ExposedBranchesInfo(
    val name: String,
    val address: String,
    val opening_hours: String,
    val information: String,
    val location: BranchLocation,
    val moreInfo: String,
    val category: String
)