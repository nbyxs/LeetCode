package LeetCode.LinkedList;

import java.util.*;

/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：
    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
示例：
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]
解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4

 */
public class LRUCache {
   class Node{
       int key;
       int value;
       Node pre;
       Node next;
       Node(){};
       Node(int key,int value){
           this.key=key;
           this.value=value;
       }
   }

   int size;
   int length;
   Node head;
   Node tail;
   HashMap<Integer,Node> map=new HashMap<>();
   public  LRUCache(int size){
       this.size=size;
       head=new Node();
       tail=new Node();
       head.next=tail;
       tail.pre=head;
   }
   int get(int key){
       Node node=map.get(key);
       if(node==null)return -1;
       else {
           moveToHead(node);
           return node.value;
       }
   }

   void put(int key,int value){
       Node node=map.get(key);
       if(node==null){
           node=new Node(key,value);
           map.put(key,node);
           addToHead(node);
           ++length;
           if(length>size){
              Node r= removeFromTail();
               --length;
               map.remove(r.key);//注意将key删除
           }
       }
       else {
           node.value=value;
           moveToHead(node);
       }
   }

    private Node removeFromTail() {
       Node node=tail.pre;
       removeFromMap(node);
       return node;
    }

    private void moveToHead(Node node) {
       removeFromMap(node);
       addToHead(node);
    }

    private void addToHead(Node node) {

      node.pre=head;
      node.next=head.next;
      head.next.pre=node;
      head.next=node;


    }

    private void removeFromMap(Node node) {
       node.pre.next=node.next;
       node.next.pre=node.pre;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
         lRUCache.put(1, 1) ;// 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(  lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4


    }
}

