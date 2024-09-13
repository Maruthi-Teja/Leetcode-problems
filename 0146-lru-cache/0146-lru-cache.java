class LRUCache {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    LinkedHashMap<Integer,Node> map;

    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.data;
        }
        return -1;
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        map.put(node.key,node);
        Node temp = head.next;
        head.next = node;
        node.prev= head;
        node.next = temp;
        node.next.prev = node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        Node node = new Node(key,value);
        insert(node);
    }
}

class Node{

    Node prev,next;
    int data,key;
    Node(int key,int _data){
        this.data = _data;
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */