import java.util.PriorityQueue;

class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode current = null;

        PriorityQueue<ListNodeIndex> heap = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(new ListNodeIndex(i, lists[i].val));
                lists[i] = lists[i].next;
            }
        }

        while (!heap.isEmpty()) {
            ListNodeIndex x = heap.poll();
            if(result == null){
                result = new ListNode(x.elem);
                current = result;

            }
            else{
                current.next = new ListNode(x.elem);
                current = current.next;

            }
            if (lists[x.index] != null) {
                x.elem = lists[x.index].val;
                heap.add(x);
                lists[x.index] = lists[x.index].next;
            }
        }

        return result;
    }

    private static class ListNodeIndex implements Comparable<ListNodeIndex> {
        int index;

        int elem;

        public ListNodeIndex (int index, int elem) {
            this.index = index;
            this.elem = elem;
        }

        @Override
        public int compareTo(ListNodeIndex o) {
            return this.elem - o.elem;
        }
    }

     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int val) { this.val = val; }
     }
}