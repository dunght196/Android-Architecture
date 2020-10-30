package com.example.cleanarchitecture.base

interface ItemMapper<DM, IM> {
    fun mapToPresentation(domainModel: DM): IM

    fun mapToDomain(itemModel: IM): DM
}