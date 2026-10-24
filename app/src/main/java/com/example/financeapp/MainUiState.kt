package com.example.financeapp

internal enum class TransactionType { INCOME, EXPENSE }

internal enum class TransactionError {
    INVALID_INPUT, AMOUNT_TOO_LARGE
}

internal data class Transaction(
    val amount: Int,
    val type: TransactionType,
    val description: String,
)

internal data class MainUiState(
    val amount: String = "",
    val description: String = "",
    val type: TransactionType = TransactionType.EXPENSE,
    val balance: Int = 0,
    val transactionCount: Int = 0,
    val transactions: List<Transaction> = emptyList(),
    val error: TransactionError? = null,
)