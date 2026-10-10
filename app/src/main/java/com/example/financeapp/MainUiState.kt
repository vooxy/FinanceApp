package com.example.financeapp

import androidx.compose.ui.Modifier

internal data class MainUiState(
    // Какое начальное значение у баланса?
    // Как посчитать выполненные операции?
    val balance: Int = 0,
    val counter: Int = 0,
)

internal enum class TransactionType {
    // Какие два типа нужны кнопкам?
    DEPOSIT,
    WITHDRAWAL,
}

internal data class Transaction(
    // Какие два свойства полностью описывают операцию?
    var type: TransactionType,
    var amount: Int,
)

internal sealed interface MainUiEvent {
    // Одно событие должно переносить созданную транзакцию
    data class addTransaction(val transaction: Transaction): MainUiEvent
}

internal fun reduce(
    state: MainUiState,
    event: MainUiEvent,
): MainUiState =when(event){
    is MainUiEvent.addTransaction -> {
        val changeBalance= when(event.transaction.type)
        {
            TransactionType.
        }
    }
}