package utils.pages;

import org.openqa.selenium.WebElement;
import utils.Contants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MovieListPageUtils {

    public static List<Long> getMoviesTimestamp(List<WebElement> listMovieDates) {
        return listMovieDates.stream().map(s -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat(Contants.MOVIE_DATE_PATTERN);
            try {
                return dateFormat.parse(s.getText()).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
