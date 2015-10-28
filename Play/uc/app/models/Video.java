package models;

import play.db.jpa.*;
import play.data.validation.*;

import org.json.*;

import static org.elasticsearch.node.NodeBuilder.*;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import static org.elasticsearch.index.query.FilterBuilders.*;
import static org.elasticsearch.index.query.QueryBuilders.*;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilteredQueryBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.client.*;

// import org.apache.hadoop.conf.Configuration;
// import org.apache.hadoop.hbase.*;
// import org.apache.hadoop.hbase.client.*;
// import org.apache.hadoop.hbase.util.Bytes;

// import java.io.IOException;
// import java.util.*;
// import javax.persistence.*;


@Entity
public class Video extends GenericModel {

    @Id
    @Required
    public String id;

    // Pageview of a video
    public int pv;

    public String genre;

    @Required
    public String title;

    // Elasticsearch client
    public static Client client;

    public Video(String id, int pv, String genre, String title) {
        this.id = id;
        this.pv = pv;
        this.genre = genre;
        this.title = title;
    }

    public static String searchVideo(String field, String query, int size) {
        /**
          * Search video by specifying the field to search and size to show.
          */
        SearchRespone response;

        if (field.toLowerCase() == "title") {
            QueryBuilder match = matchQuery(field, query);
            response = client.prepareSearch("ucvideo")
                .setTypes("video_view")
                .setQuery(match)
                .addSort("pv", SortOrder.DESC)
                .setSize(size)
                .execute()
                .actionGet();
        } else {
            FilterBuilder term = termFilter(field, query.toLowerCase());
            FilteredQueryBuilder filtered =
                filteredQuery(matchAllQuery(), term);
            response = client.prepareSearch("ucvideo")
                .setTypes("video_view")
                .setQuery(filtered)
                .addSort("pv", SortOrder.DESC)
                .setSize(size)
                .execute()
                .actionGet();
        }

        return response.toString();
    }

}