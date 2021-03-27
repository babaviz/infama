package infama.interview.question1.urlshortener.utility;
import java.util.regex.Pattern;


public class ValidateUrls {
    public static final ValidateUrls instance = new ValidateUrls();
    private static final String url_regex_str = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";

    private static final Pattern URL_PATTERN = Pattern.compile(url_regex_str);

    public boolean validateURL(String url) {
        return URL_PATTERN.matcher(url).matches();
    }
}
