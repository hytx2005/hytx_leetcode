package a13dui;

public class T03L295 {
    class MedianFinder {
        static class Heap {
            int[] array;
            int size;
            boolean max;

            public Heap(int capacity, boolean max) {
                array = new int[capacity];
                this.max = max;
            }

            public int peek() {
                return array[0];
            }


            /**
             * 建堆，对堆内的元素进行初始化操作，使之符合（大顶堆 / 小顶堆）的定义
             */
            private void heapify() {
                // 1.找到最后一个非叶子节点 size / 2 - 1
                for (int i = size / 2 - 1; i >= 0; i--) {
                    // 节点下潜操作
                    down(i);
                }
            }


            /**
             * 操作：将 parent 索引处的节点下潜，
             *
             * @param parent 父元素节点索引
             */
            private void down(int parent) {
                // 1.找到子节点的索引
                int left = 2 * parent + 1;
                int right = left + 1;
                int m = parent;

                if (left < size && (this.max ? array[left] > array[m] : array[left] < array[m])) {
                    m = left;
                }

                if (right < size && (this.max ? array[right] > array[m] : array[right] < array[m])) {
                    m = right;
                }

                if (m != parent) {
                    // 需要下潜
                    swap(parent, m);
                    // 继续下潜
                    down(m);
                }
            }


            /**
             * 交换两个索引处元素的值
             *
             * @param i 第一个索引
             * @param j 第二个索引
             */
            private void swap(int i, int j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }


            /**
             * 删除堆顶元素
             *
             * @return int
             */
            public int poll() {
                if (isEmpty()) {
                    throw new RuntimeException("Heap is empty");
                }
                int temp = array[0];
                swap(0, --size);
                down(0);
                return temp;
            }


            /**
             * 替换堆顶元素
             *
             * @param newValue 新的值
             */
            public void replace(int newValue) {
                if (isEmpty()) {
                    throw new RuntimeException("Heap is empty");
                }
                array[0] = newValue;
                down(0);
            }

            /**
             * 往堆的尾部添加元素
             *
             * @param newValue - 新元素的值
             * @return boolean - 是否添加成功
             */
            public boolean offer(int newValue) {
                if (size == array.length) {
                    grow();
                }
                array[size] = newValue;
                up(size++);
                return true;
            }

            private void grow() {
                int capacity = array.length * 2;
                int[] newArray = new int[capacity];
                System.arraycopy(array, 0, newArray, 0, size);
                array = newArray;
            }

            /**
             * 元素上浮
             *
             * @param son 元素的索引
             */
            private void up(int son) {
                if (son <= 0) {
                    return;
                }
                // 1.找到父节点
                int parent = (son - 1) >> 1;
                boolean t = this.max ? array[son] > array[parent] : array[son] < array[parent];
                if (t) {
                    swap(parent, son);
                    up(parent);
                }
            }

            private boolean isEmpty() {
                return size == 0;
            }

            private boolean isFull() {
                return size == array.length;
            }
        }

        Heap leftMinHeap;
        Heap rightMaxHeap;

        public MedianFinder() {
            leftMinHeap = new Heap(10, true);
            rightMaxHeap = new Heap(10, false);
        }

        public void addNum(int num) {
            if (leftMinHeap.size == rightMaxHeap.size) {
                rightMaxHeap.offer(num);
                leftMinHeap.offer(rightMaxHeap.poll());
            } else {
                leftMinHeap.offer(num);
                rightMaxHeap.offer(leftMinHeap.poll());
            }
        }

        public double findMedian() {
            if (leftMinHeap.size == rightMaxHeap.size) {
                return (leftMinHeap.peek() + rightMaxHeap.peek()) / 2.0;
            } else {
                return leftMinHeap.peek();
            }
        }
    }
}
