public class LinkedListDeque<T> {
    private class ListNode{
        ListNode next;
        ListNode prev;
        T item;

        public ListNode(T i, ListNode l1, ListNode l2){
            item = i;
            prev = l1;
            next = l2;
        }

        private T getRecurtive(int index){
            if(index == 0){
                return item;
            }
            return this.next.getRecurtive(index - 1);
        }
    }
    private static int size;
    /** The first node is sentinel.next*/
    private ListNode sentinel;
    /** Point to the last node of the deque*/
    /**private ListNode last;
     * it's not necessary*/

    public LinkedListDeque(){
        this.sentinel = new ListNode(null,null,null);
        size = 0;
    }

    public void addFirst(T item){
        if(sentinel.next == null)//The deque is empty
        {
            sentinel.next = new ListNode(item, null,null);
            sentinel.next.prev = sentinel.next;
            sentinel.next.next = sentinel.next;
        }else{
            sentinel.next = new ListNode(item, sentinel.next.prev,sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            sentinel.next.prev.next = sentinel.next;
        }
        size++;
    }

    public void addLast(T item){
        if(sentinel.next != null){//It has first node
            sentinel.next.prev.next = new ListNode(item,sentinel.next.prev,sentinel.next);
            sentinel.next.prev = sentinel.next.prev.next;
            size++;
        }else{//The deque is empty
            sentinel.next = new ListNode(item,null,null);
            sentinel.next.prev = sentinel.next;
            sentinel.next.next = sentinel.next;
            size++;
        }
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        ListNode l = sentinel.next;
        while(l != sentinel.next.prev){
            System.out.print(l.item + " ");
            l = l.next;
        }
        System.out.print(l.item);
    }

    public T removeFirst(){
        if(sentinel.next == null) {
            return null;
        }else if(sentinel.next == sentinel.next.next){
            T i = sentinel.next.item;
            sentinel.next = null;
            size--;
            return i;
        }else{
            T i = sentinel.next.item;
            sentinel.next.next.prev = sentinel.next.prev;
            sentinel.next.prev.next = sentinel.next.next;
            sentinel.next = sentinel.next.next;
            size--;
            return i;
        }
    }

    public T removeLast(){
        if(sentinel.next == null) {//empty deque
            return null;
        }else if(sentinel.next == sentinel.next.next){//only has one node
            T i = sentinel.next.item;
            sentinel.next = null;
            size--;
            return i;
        }else{//has more than two nodes
            T i = sentinel.next.prev.item;
            sentinel.next.prev.prev.next = sentinel.next;
            sentinel.next.prev = sentinel.next.prev.prev;
            size--;
            return i;
        }
    }

    public T get(int index){
        if(index + 1 > size || index < 0){
            return null;
        }else{
            ListNode L = sentinel.next;
            for(int i = 0; i < index; i++){
                L = L.next;
            }
            return L.item;
        }
    }

    public T getRecursive(int index){
        if(index + 1 > size || index < 0){
            return null;
        }
        ListNode l = sentinel.next;
        if(index == 0) {
            return l.item;
        }else{
            return l.next.getRecurtive(index - 1);
        }
    }
}
