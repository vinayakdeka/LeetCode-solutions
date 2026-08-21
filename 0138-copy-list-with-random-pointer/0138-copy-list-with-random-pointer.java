class Solution {
    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        HashMap<Node, Node> mp = new HashMap<>();

        // Step 1: Create all copied nodes
        Node oldTemp = head;
        Node newHead = new Node(head.val);
        Node newTemp = newHead;

        mp.put(head, newHead);

        oldTemp = head.next;

        while (oldTemp != null) {

            Node copyNode = new Node(oldTemp.val);

            mp.put(oldTemp, copyNode);

            newTemp.next = copyNode;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        // Step 2: Connect random pointers
        oldTemp = head;
        newTemp = newHead;

        while (oldTemp != null) {

            if (oldTemp.random != null)
                newTemp.random = mp.get(oldTemp.random);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}