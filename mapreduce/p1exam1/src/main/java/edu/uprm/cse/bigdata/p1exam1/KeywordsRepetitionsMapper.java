package edu.uprm.cse.bigdata.p1exam1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterObjectFactory;

import java.io.IOException;


public class KeywordsRepetitionsMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String rawTweet = value.toString();

        try {
            Status status = TwitterObjectFactory.createStatus(rawTweet);
            String text = status.getText().toUpperCase();

            if (text.contains("MAGA")) context.write(new Text("MAGA"), new Text(String.valueOf(status.getId())));

            if (text.contains("DICTATOR")) context.write(new Text("DICTATOR"), new Text(String.valueOf(status.getId())));

            if (text.contains("IMPEACH")) context.write(new Text("IMPEACH"), new Text(String.valueOf(status.getId())));

            if (text.contains("DRAIN")) context.write(new Text("DRAIN"), new Text(String.valueOf(status.getId())));

            if (text.contains("SWAMP")) context.write(new Text("SWAMP"), new Text(String.valueOf(status.getId())));

            if (text.contains("CHANGE")) context.write(new Text("CHANGE"), new Text(String.valueOf(status.getId())));

        }
        catch(TwitterException e){

        }
    }
}
