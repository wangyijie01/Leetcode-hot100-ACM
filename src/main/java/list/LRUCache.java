package list;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 *
 */
public class LRUCache {

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }


    public static class Node{
        int key, value;
        Node next, prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public final int capacity;
    public final Node dummy = new Node(0, 0);
    public final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key){
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value){
        Node node = getNode(key);  //拿出节点并且放到最前面
        if(node != null){
            node.value = value;
            return;
        }

        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(node);
        if(this.capacity < keyToNode.size()){
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }


    public Node getNode(int key){
        if(!keyToNode.containsKey((key))){
            return null;
        }
        Node cur = keyToNode.get(key);
        remove(cur);
        pushFront(cur);
        return cur;
    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void pushFront(Node node){
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next = node;
        node.next.prev = node;
    }
}
