package fastslowpointers


/**
 * Задача:
 *
 * Дан связный список.
 * Необходимо определить есть ли в связном списке циклы.
 */

/*
 * Мы можем применить эту логику — перемещать быстрый указатель в два раза быстрее, чем медленный.
 * Если они когда-нибудь встретятся (кроме самого начала), то мы знаем, что должен существовать цикл.
 * Если быстрый указатель достигает конца связанного списка, значит, цикла нет.
 *
 * Временная сложность алгоритма: O(n)
 * Пространственная сложность алгоритма: O(1)
 */

fun main() {
    val testLinkedListWithCycle = getLinkedListWithCycle()
    val testLinkedList = getLinkedList()

    val result = FastAndSlowPointersSecondUse().hasCycle(testLinkedListWithCycle)

    println(result)
}

class FastAndSlowPointersSecondUse {

    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            println("slow: ${slow?.value}, fast: ${fast?.value}")

            if (slow == fast) {
                return true
            }
        }

        return false
    }
}