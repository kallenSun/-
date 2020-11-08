import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <Description> <br>
 *
 * @author sunyue <br>
 * @version 9.0 <br>
 * @taskId <br>
 * @CreateDate 2020/10/28 <br>
 * @since V9.0 <br>
 */
public class MyHashMap<K,V> {
    // 初始化的桶大小
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    // 桶的最大值
    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 扩容因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 用于判断是否需要将链表转为二叉树
    static final int TREEIFY_THRESHOLD = 8;

    transient Node<K,V>[] table;

    // transient Set<Map.Entry<K,V>> entrySet;

    transient int size;

    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public final int HashCode(){
            return Objects.hashCode(this.key) ^ Objects.hashCode(this.value);
        }

        @Override
        public final boolean equals(Object o){
            if (o == this){
                return true;
            }
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
                    return true;
                }
            }
            return  false;
        }

    }

//    判断当前数组是否需要初始化。
//    如果 key 为空，则 put 一个空值进去。
//    根据 key 计算出 hashcode。
//    根据计算出的 hashcode 定位出所在桶。
//    如果桶是一个链表则需要遍历判断里面的 hashcode、key 是否和传入 key 相等，如果相等则进行覆盖，并返回原来的值。
//    如果桶是空的，说明当前位置没有数据存入；新增一个 Entry 对象写入当前位置
    public V put(K key, V value) {

        return null;
    }

}
