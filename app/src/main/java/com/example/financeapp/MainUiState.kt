package com.example.financeapp


internal data class MainUiState(
    // Какое начальное значение у баланса?
    // Как посчитать выполненные операции?
    val balance: Int = 0,
    val transactionCount: Int = 0,
)

internal enum class TransactionType {
    // Какие два типа нужны кнопкам?
    INCOME,
    EXPENSE,
}

internal data class Transaction(
    // Какие два свойства полностью описывают операцию?
    var type: TransactionType,
    var amount: Int,
)

internal sealed interface MainUiEvent {
    // Одно событие должно переносить созданную транзакцию
    data class AddTransaction(val transaction: Transaction) : MainUiEvent
}

internal fun reduce(state: MainUiState, event: MainUiEvent) : MainUiState = when (event) {
    is MainUiEvent.AddTransaction -> {
        val transaction = event.transaction
        require(value = transaction.amount > 0) { "Transaction amount must be positive" }

        val balanceChange = when (transaction.type) {
            TransactionType.INCOME -> transaction.amount
            TransactionType.EXPENSE -> -transaction.amount
        }

        state.copy(
            balance = state.balance + balanceChange,
            transactionCount = state.transactionCount + 1
        )
    }
}
