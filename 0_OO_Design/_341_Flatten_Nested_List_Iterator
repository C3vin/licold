public class NestedIterator implements Iterator<Integer> {

        Queue<Integer> q = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            flattenNestedList(nestedList);
        }

        private void flattenNestedList(List<NestedInteger> nestedList) {

            for (NestedInteger ni: nestedList /**它是list**/) {

                if (ni.isInteger()) {
                    q.add(ni.getInteger());
                } else {
                    flattenNestedList(ni.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return q.remove();
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }
}