package reversing_linked_list

import fastslowpointers.ListNode
import fastslowpointers.getLinkedList
import fastslowpointers.printLinkedList


/**
 * Задача:
 *
 * Дан связный список, необходимо развернуть его.
 *
 * Пример:
 *
 * Дан связный список: 1 -> 2 -> 3 -> 4 -> 5
 *
 * Ответ: 5 -> 4 -> 3 -> 2 -> 1
 */

/*
 * Временная сложность алгоритма: O(n)
 * Пространственная сложность алгоритма: O(1)
 */

fun main() {
    val testLinkedList = getLinkedList()
    val result = ReversingLinkedListFirstUse().reverse(testLinkedList)

   printLinkedList(result)
}

class ReversingLinkedListFirstUse {

    fun reverse(head: ListNode): ListNode? {
        printLinkedList(head) // Выводим исходный связный список

        var previousNode: ListNode? = null // null; 1; ...
        var currentNode: ListNode? = head // 1; 2; ...

        while (currentNode != null) {
            val nextNode = currentNode.next // 2; 3; ...
            currentNode.next = previousNode // 1 -> null; 2 -> 1; ...

            previousNode = currentNode // 1; 2; ...
            currentNode = nextNode // 2; 3; ...
        }

        return previousNode
    }
}