import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

import org.elasticsearch.node.*;

import java.io.IOException;


@OnApplicationStart
public class ConnectElasticsearch extends Job {

    public void doJob() {
        // Default cluster name is "elasticsearch"
        Node node = NodeBuilder.nodeBuilder().client(true).node();
        Video.client = node.client();
    }
}