package fastslowpointers


/**
 * Задача:
 *
 * Дан связный список, который состоит из нечетного! количества узлов.
 * Необходимо вернуть значение узла в середине.
 *
 * Пример:
 *
 * Дан связный список: 1 -> 2 -> 3 -> 4 -> 5
 *
 * Ответ: 3
 */

/*
 * Данную задачу можно решить разными способами, но более элегантый подход состоит в использовании подхода
 * Fast and Slow Pointers.
 *
 * Если у нас один указатель движется в два раза быстрее другого, то к тому времени, как он достигнет конца,
 * медленный указатель пройдет половину пути, поскольку он движется с половиной скорости.
 *
 * Временная сложность алгоритма: O(n)
 * Пространственная сложность алгоритма: O(1)
 */

fun main() {
    val testLinkedList = getLinkedList()
    val result = FastAndSlowPointersFirstUse().getMiddle(testLinkedList)

    println(result)
}

class FastAndSlowPointersFirstUse {

    fun getMiddle(head: ListNode): Int? {
        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            // В других задачах вы можете использовать разное расстояние между указателями, в зависимости от условий задачи.
            fast = fast.next?.next
        }

        return slow?.value
    }
}