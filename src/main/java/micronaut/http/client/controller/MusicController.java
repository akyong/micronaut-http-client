package micronaut.http.client.controller;

import io.micronaut.core.util.StringUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import micronaut.http.client.domain.Album;
import micronaut.http.client.repository.ItunesClient;

import javax.annotation.Nullable;
import micronaut.http.client.domain.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller("/music")
public class MusicController {
    private ItunesClient itunesClient;
    private Logger log = LoggerFactory.getLogger(MusicController.class);
    public MusicController(ItunesClient itunesClient) {
        this.itunesClient = itunesClient;
    }

    @Get("/search/{searchTerm}")
    public List<Album> search(String searchTerm, @Nullable @QueryValue String maxResults) {
        log.info("searchTerm : {}",searchTerm);
        log.info("maxResults : {}",maxResults);
        final int limit;
        if(StringUtils.isDigits(maxResults)) {
            limit = Math.min(25, Integer.parseInt(maxResults));
        } else {
            limit = 25;
        }

        SearchResult result = itunesClient.search(searchTerm, limit);
        return result.getResults();
    }
}
