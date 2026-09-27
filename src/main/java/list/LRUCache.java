package list;
import java.util.*;

/**
 * LRU缓存
 */
public class LRUCache {
    public static class Node{
        int key, val;
        Node pre, next;
        public Node(int k, int v){
            key = k;
            val = v;
        }
    }

    private Node dummy = new Node(0, 0);
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;

    public LRUCache(int c){
        capacity = c;
        dummy.next = dummy;
        dummy.pre = dummy;
    }

    public int get(int key){
        Node node = getNode(key);
        return node == null ? -1 : node.val;
    }

    public void put(int key, int value){
        Node node = getNode(key);
        if(node != null){
            node.val = value;
            return;
        }
        node = new Node(key, value);
        map.put(key, node);
        pushFront(node);
        if(map.size() > capacity){
            Node n = dummy.pre;
            map.remove(n.key);
            remove(n);
        }
    }


    public Node getNode(int key){
        if(!map.containsKey(key)){
            return null;
        }
        Node node = map.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void pushFront(Node node){
        node.next = dummy.next;
        node.pre = dummy;
        node.next.pre = node;
        node.pre.next = node;
    }


    public static void main(String[] args){
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1)); // 输出 1
        lru.put(3, 3); // 删除键 2
        System.out.println(lru.get(2)); // 输出 -1

    }

}
