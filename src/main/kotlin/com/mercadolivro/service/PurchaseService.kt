package com.mercadolivro.service

import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.repository.PurchaseRepository
import jakarta.transaction.Transactional
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {

        save(purchaseModel)

        println(":::: DISPARANDO EVENTO DE COMPRA ::::")

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))

        println(":::: FINALIZAÇÃO DO PROCESSAMENTO ::::")
    }

    fun update(purchaseModel: PurchaseModel) {

        save(purchaseModel)
    }

    @Transactional
    private fun save(purchaseModel: PurchaseModel) {

        purchaseRepository.save(purchaseModel)
    }

}
