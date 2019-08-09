package micronaut.http.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import micronaut.http.client.domain.Album;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    @JsonProperty("resultCount")
    private int resultCount;

    @JsonProperty("results")
    private List<Album> results = new ArrayList<Album>();

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Album> getResults() {
        return results;
    }

    public void setResults(List<Album> results) {
        this.results = results;
    }
}
