public class Codec {
    
    Map<Integer, String> map = new HashMap<>();
    String BASE_URL = "http://tinyurl.com";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode();
        map.put(hashCode, longUrl);
        return BASE_URL + hashCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int hashCode = Integer.valueOf(shortUrl.replace(BASE_URL, ""));
        return map.get(hashCode);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));