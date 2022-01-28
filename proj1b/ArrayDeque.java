public class ArrayDeque<T> {
    private int size;//The real size of the list.
    private T[] items;//The core array of the deque.
    private int first;//This variable is an index that points at the first item in the array.
    private int last;//This variable is an index that points to the last item in the array;
    private double UsageRatio;//evaluate the usage ratio of the array.

    public ArrayDeque(){
        items = (T[]) new Object[8];
        first = 4;
        last = 4;
        size = 0;
    }

    public void addFirst(T x){
        if(size == 0) {
            items[first] = x;
        }else if(size + 1 <= items.length){
            if(first - 1 >= 0){
                items[first - 1] = x;
                first--;
            }else{
                items[items.length - 1] = x;
                first = items.length - 1;
            }
        }else{//size + 1 > items.length
            resize(items.length * 2);
            items[first - 1] = x;
            first--;
        }
        size++;
    }

    public void addLast(T x){
        if(size == 0) {
            items[last] = x;
        }else if(size + 1 <= items.length){
            if(last + 1 >= items.length){
                items[last + 1 - items.length] = x;
                last = last + 1 - items.length;
            }else{
                items[last + 1] = x;
                last++;
            }
        }else{
            resize(items.length * 2);
            if(last + 1 >= items.length){
                items[last + 1 - items.length] = x;
                last = last + 1 - items.length;
            }else{
                items[last + 1] = x;
                last++;
            }
        }
        size++;
    }

    public T get(int index){
        if(index > size || index < 0){
            return null;
        }
        if(index + first <= items.length - 1)
        {
            return items[index + first];
        }else{
            return items[index + first - items.length];
        }
    }

    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        if(last > first){
            System.arraycopy(items,first,a,a.length / 2, size);
            last = a.length / 2 + size - 1;
            first = a.length / 2;
        }else{//last < first
            System.arraycopy(items,first,a,a.length / 2,items.length - first);
            System.arraycopy(items,0,a,a.length / 2 + items.length - first,last + 1);
            last = a.length / 2 + size - 1;
            first = a.length / 2;
        }
        items = a;
        this.UsageRatio = (double)size / items.length;
    }

    public T removeFirst(){
        T x = items[first];
        if(size > 1){
            if(first != items.length - 1){
                items[first] = null;
                first++;
            }else{
                items[first] = null;
                first = 0;
            }
            size--;
            this.UsageRatio = (double)size / items.length;
            while(UsageRatio < 0.25 && items.length > 16){
                resize(items.length / 2);
            }
        }else if(size == 1){
            items[first] = null;
            size--;
            first = last = items.length / 2;
        }
        return x;
    }

    public T removeLast(){
        T x = items[last];
        items[last] = null;
        if(size > 1){
            if(last == 0){
                last = items.length - 1;
            }else{
                last = last - 1;
            }
            size--;
            this.UsageRatio = (double)size / items.length;
            while(UsageRatio < 0.25 && items.length > 16){
                resize(items.length / 2);
            }
        }else if(size == 1){
            last = first = items.length / 2;
            size--;
        }
        return x;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public void printDeque(){
        if(last >= first){
            for(int i = first; i <= last; i++){
                System.out.print(items[i] + " ");
            }
        }else{
            for(int i = first; i < items.length; i++){
                System.out.print(items[i] + " ");
            }
            for(int i = 0; i <= last ; i++){
                System.out.print(items[i] + " ");
            }
        }
    }
}
