PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(5, new Comparator<Integer>(){
           //@Override it seems having this one or not does not matter a lot, but it may gives more useful info if having it.
           public int compare(Integer a, Integer b){
               return b- a;
           }
        });
        minHeap.offer(2);
               minHeap.offer(1);
                      minHeap.offer(5);
        System.out.println(minHeap.poll());
                System.out.println(minHeap.poll());
                        System.out.println(minHeap.poll());
                        
                        Set<Integer> set = new HashSet<>();
                        set.add(1);
                        set.add(2);
                        set.add(3);
                        //FOR HASHMAP; JUST ITERATOR THROUGH map.keySet() for (String key : map.keySet()) {
                        Iterator itr = set.iterator();
                        while(itr.hasNext()){
                            System.out.println(itr.next());
                        }
                        Integer a  = 1;
                        int b = 2;
                        a = b;
                        System.out.println("b is " + b + " a is " + a);
                        b = a;
                        System.out.println("b is " + b + " a is " + a);

