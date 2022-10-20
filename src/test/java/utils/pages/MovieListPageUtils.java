package utils.pages;

import org.openqa.selenium.WebElement;
import utils.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class MovieListPageUtils {

    public static List<Long> getMoviesTimestamp(List<WebElement> listMovieDates) {
        return listMovieDates.stream().map(s -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.MOVIE_DATE_PATTERN);
            try {
                return dateFormat.parse(s.getText()).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
