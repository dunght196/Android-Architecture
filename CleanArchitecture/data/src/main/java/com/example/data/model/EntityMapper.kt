package com.example.data.model

import com.example.domain.model.DomainModel

interface EntityMapper<DM: DomainModel, DT: EntityModel> {
    fun mapToDomain(data: DT): DM

    fun mapToData(domain: DM) : DT
}