import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Permute {
    private static final Logger logger = LoggerFactory.getLogger(Permute.class);

    public static void main(String args[]) {
        String input = "abc";

        if (args.length > 0) {
            input = args[0];
        }

        Permute permute = new Permute();

        permute.permute(input);
    }

    public void permute(String str) {
        char[] chars = str.toCharArray();

        permute(chars, 0, chars.length);
    }

    public void permute(char[] str, int low, int high) {
        if ((low + 1) < high) {
            permute(str, low+1, high);
        } else {
            logger.info("permutation: {}", new String(str));
            return;
        }

        char cur = str[low];

        for (int i=low+1; i < high; i++) {
            str[low] = str[i];
            str[i] = cur;
            permute(str, low+1, high);
            str[i] = str[low];
        }

        str[low] = cur;
    }
}
