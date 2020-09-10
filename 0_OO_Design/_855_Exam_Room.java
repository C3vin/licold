class ExamRoom {
        int N;
        /** 先定义学生集合 */
        TreeSet<Integer> students; // --> TreeSet
        /** 定义位置的数目 */
        public ExamRoom(int N) {
            this.N = N;
            /** 再赋值 */
            students = new TreeSet();
        }
        /** 增加学生 */
        public int seat() {
                        /** 初始值 */
                        int student = 0;    
                        /**  */
                        if (students.size() > 0) {
                                    /** 返回最小的值 */
                                    int max_d = students.first();
                                    /** 初始化 prev */
                                    Integer prev = null;
                                    for (Integer M: students) {
                                            if (prev != null) {
                                                        /** 找到中间的位置 */
                                                        int d = (M - prev) / 2;
                                                        /** 如果这个 d 比 max_d 还长，就更新max_d  */
                                                        if (d > max_d) {
                                                            max_d = d;
                                                            /** 确定学生的位置 */
                                                            student = prev + d;
                                                        }
                                            }
                                            prev = M;
                                    }
                                    /** 考虑右边的位置 */
                                    if (N - 1 - students.last() > max_d) student = N - 1;                
                        }
                        students.add(student);
                        return student;
        }
        /** 删除学生 */
        public void leave(int p) {
            students.remove(p);
        }
}