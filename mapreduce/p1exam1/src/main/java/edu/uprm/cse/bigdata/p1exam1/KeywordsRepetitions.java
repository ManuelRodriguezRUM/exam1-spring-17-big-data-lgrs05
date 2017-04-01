package edu.uprm.cse.bigdata.p1exam1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.net.URI;

/**
 * Created by ubuntu on 2/6/17.
 */
public class KeywordsRepetitions {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: KeywordsRepetitions <input path> <output path>");
            System.exit(-1);
        }
        String fileName = args[0];

        URI fileUri = URI.create(fileName);

        Configuration conf = new Configuration();
        conf.set("mapred.textoutputformat.separator", ", ");

        Job job = new Job(conf);

        Path path = new Path(fileUri);
        FileInputFormat.addInputPath(job, path);


        job.setJarByClass(KeywordsRepetitions.class);
        job.setJobName("Keywords Repetitions");


        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(KeywordsRepetitionsMapper.class);
        job.setReducerClass(KeywordsRepetitionsReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);



        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
