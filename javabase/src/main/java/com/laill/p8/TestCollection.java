package com.laill.p8;

import java.util.*;

/**
 * @program: t7_04.test
 * @description:
 * @author: laill
 * @create: 2018/12/10
 */
public class TestCollection {
    public static void main(String[] args) {
        if(Objects.equals("43","43")){
            System.out.println("r");
        }
        @SuppressWarnings("unchecked")
        List list=new ArrayList();

        Collection collection=new Collection() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object object) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        Queue queue=new Queue() {
            @Override
            public boolean add(Object object) {
                return false;
            }

            @Override
            public boolean offer(Object object) {
                return false;
            }

            @Override
            public Object remove() {
                return null;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object element() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        //Hierarchy
        Map map=new HashMap();
        Set set=new HashSet();
        set.add("45");
        set.add(null);
        map.put(null, null);
        queue.add(null);
        list.add(null);
        Collections.addAll(set, "fdfd,gdfgf");

        List<String> list1 = Arrays.asList("434", "gdgd");

        //list1.add("fsf");
//        list1.remove(1);
//        Collections.shuffle(list1);

        String str = "a,b,c,,";
        String[] ary = str.split(",");
        //预期大于 3，结果是 3
        System.out.println(ary.length);

        //linkedList
        com.test.p8.Stack<User> userStack = new com.test.p8.Stack<>();
        userStack.push(new User("lisi", "34"));
        userStack.push(new User("lisi22", "134"));

        System.out.println(userStack.peek().getAge());
        System.out.println(userStack.isEmpty());

        //hashSet
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Random random=new Random(47);
        Random random2=new Random(47);
        for (int i = 0; i < 5; i++) {
            set1.add(random.nextInt(20));
        }
        System.out.println(set1);
        for (int i = 0; i < 5; i++) {
            set2.add(random2.nextInt(20));
        }
        System.out.println(set2);

        //map
        Map<Integer, Integer> map1 = new HashMap<>();
        Random random1 = new Random(40);
        for (int i = 0; i < 1000; i++) {
            int t = random1.nextInt(10);
//            Integer key=map1.get(t);
            map1.put(t, map1.containsKey(Integer.valueOf(t)) ?  map1.get(t) + 1:1);

        }
        System.out.println(map1);
        Iterator<Map.Entry<Integer,Integer>>  entries = map1.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<Integer,Integer> entry = entries.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }


    }

    public static <T> List<T> getList(){
        return new ArrayList<T>();
    }

    public native void getNati();
}


