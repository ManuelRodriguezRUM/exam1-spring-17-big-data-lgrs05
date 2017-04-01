package edu.uprm.cse.bigdata.p1exam1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class KeywordsRepetitionsReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {


        String result = "";

        for (Text value : values){
            result+=value+", ";
        }

        result = result.substring(0,result.length()-2);
        context.write(key, new Text(result));
    }

}
