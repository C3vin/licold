class Solution {
 
        public List < List < String >> findDuplicate(String[] paths) {

            HashMap< String, List < String >> map = new HashMap< >();

            /* 扫描每个输入 */
            for (String path: paths) {

                /* 拆解每个输入 */
                String[] values = path.split(" ");

                for (int i = 1; i < values.length; i++) {

                    /** 製造 ["3.txt", "abcd"]  **/
                    String[] name_cont = values[i].split("\\(");    //拆成array
                    
                    name_cont[1] = name_cont[1].replace(")", "");   //拿到content

                    /* 拿出，放入 */
                    List < String > list = map.getOrDefault( name_cont[1], new ArrayList < String > () );
                    
                    /*
                    name_cont[1]  文件内容
                    name_cont[0]  文件名
                    */
                    
                             /* 路径 */
                    list.add(values[0] + "/" + name_cont[0]);
                    
                    map.put(name_cont[1], list);
                    
                    /** "abcd"，["3.txt", ] **/

                }

            }

            List < List < String >> res = new ArrayList < > ();
            for (String key: map.keySet()) {
                if (map.get(key).size() > 1)
                    res.add(map.get(key));
            }

            return res;

        }
}
