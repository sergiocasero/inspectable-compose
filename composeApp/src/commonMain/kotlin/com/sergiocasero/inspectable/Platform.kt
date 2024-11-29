package com.sergiocasero.inspectable

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform