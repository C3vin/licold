public class Codec {
     
	        // 看有自己的视频讲解
       
            String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
            HashMap<String, String> map = new HashMap<>();
    
            int count = 1;

            public String encode(String longUrl) {

                String key = a();

                map.put(key, longUrl);

                count ++;

                return "http://tinyurl.com/" + key;

            }

            public String decode(String shortUrl) {
                return map.get( shortUrl.replace("http://tinyurl.com/", "") );
            }
 
            /** 这里返回的 密码是唯一的 **/
            public String a() {

                int c = count;

                StringBuilder sb = new StringBuilder();

                while (c > 0) {
                     
                    sb.append(chars.charAt(c % 62));
                    c /= 62; /** count 是 62的多少倍**/
                }

                return sb.toString();
            }
}
