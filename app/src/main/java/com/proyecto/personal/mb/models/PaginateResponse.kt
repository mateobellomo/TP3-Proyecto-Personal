package com.proyecto.personal.mb.models

data class PaginateResponse<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)
