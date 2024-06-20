package fastslowpointers

class ListNode(
    val value: Int,
    var next: ListNode? = null
)

fun getLinkedList(): ListNode {
    val node7 = ListNode(7)
    val node6 = ListNode(6, node7)
    val node5 = ListNode(5, node6)
    val node4 = ListNode(4, node5)
    val node3 = ListNode(3, node4)
    val node2 = ListNode(2, node3)
    val node1 = ListNode(1, node2)

    return node1
}

fun getLinkedListWithCycle(): ListNode {
    val node8 = ListNode(8)
    val node7 = ListNode(7, node8)
    val node6 = ListNode(6, node7)
    val node5 = ListNode(5, node6)
    val node4 = ListNode(4, node5)
    val node3 = ListNode(3, node4)
    val node2 = ListNode(2, node3)
    val node1 = ListNode(1, node2)
    node8.next = node3

    return node1
}

fun printLinkedList(head: ListNode?) {
    var current: ListNode? = head

    while (current != null) {
        print("${current.value} -> ")
        current = current.next
    }

    println()
}