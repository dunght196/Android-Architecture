package com.example.data.model

interface EntityMapper<DM, DT> {
    fun mapToDomain(data: DT): DM

    fun mapToData(domain: DM) : DT
}