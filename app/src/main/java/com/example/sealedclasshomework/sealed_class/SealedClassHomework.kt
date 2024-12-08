package com.example.sealedclasshomework.sealed_class

/**
 * У нас есть метод getPurchaseStatus(), но сейчас Android Studio ругается на ошибку. Исправьте ее и запустите программу.
 * Что будет выведено в терминале?
 * Помните, что задачу можно решить несколькими способами.
 */
fun main() {
    getPurchaseStatus(PurchaseStatus.InProgress)
    try {
        assertDivider(0)
    } catch(e: RuntimeException) {
        print("main catch runtime exception /")
    } finally {
        print("main finally")
    }

}

fun getPurchaseStatus(status: PurchaseStatus) = when (status) {
    PurchaseStatus.InProgress -> println("доставка в процессе")
    PurchaseStatus.Ready -> println("доставка готова")
    is PurchaseStatus.Canceled -> {
        println("Доставка отменена, причина: ${status.reason}")
    }
}

class ZeroDividerAssertionException: Exception()

fun assertDivider(divider: Int) {
    try {
        if (divider == 0) throw ZeroDividerAssertionException()
    } finally {
        print("assertDivider finally /")
    }
}