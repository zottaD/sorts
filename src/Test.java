import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:dzmitry.kasakouski@onespan.com">Dzmitry Kasakouski</a>
 */
public class Test {

  public static void main(String[] args) {
    System.out.println(stripUrlParams("https://devtailor.com?first=1&second=2&first=2"));
  }

  static String stripUrlParams(String url) {
    final String[] strings = url.split("\\?+");
    if (strings.length < 2) {
      return url;
    }
    Map<String, String> map = new HashMap<>();
    Arrays.stream(strings[1].split("&")).forEach(st -> {
      final String[] pair = st.split("=");
      if (!map.containsKey(pair[0])) {
        map.put(pair[0], pair[1]);
      }
    });
    StringBuilder builder = new StringBuilder();
    builder.append(strings[0]).append("?");
    int i = 0;
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (i != 0) {
        builder.append("&");
      }
      builder.append(entry.getKey()).append('=').append(entry.getValue());
      i++;
    }
    return builder.toString();
  }
}
