import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;


@OnApplicationStart
public class Connect extends Job<HTable> {

    public void doJob() {
        Configuration conf = HBaseConfiguration.create();
        User.connection = HConnectionManager.createConnection(conf);
    }
}