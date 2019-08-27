import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by lenovo on 2019/7/6.
 */
public class WordCountMap extends Mapper<LongWritable,Text,Text,IntWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String args = value.toString();
        String[] words = args.split(" ");
        for(String word:words){
            context.write(new Text(word),new IntWritable(1));
        }
    }
}
