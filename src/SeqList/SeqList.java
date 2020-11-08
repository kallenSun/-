package SeqList;

/**
 * @author sunyue
 * 线性表具体实现
 */
public class SeqList implements MyList {

    private int len = 0;

    private Object[] element;

    public SeqList(int size){
        this.element = new Object[size];
        this.len = size;
    }

    public SeqList(){
        this(64);
    }


    @Override
    public boolean isEmpty() {
        return this.len == 0;
    }

    @Override
    public int length() {
        return this.len;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public void set(int i, Object x) {

    }

    @Override
    public void insert(int i, Object x) {

    }

    @Override
    public void append(Object x) {

    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public void removeall() {

    }

    @Override
    public Object search(Object key) {
        return null;
    }
}
