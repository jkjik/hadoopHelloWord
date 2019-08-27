import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by lenovo on 2019/7/6.
 */
public class WordCountDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration config = new Configuration();
        Job job = Job.getInstance(config);

        job.setJarByClass(WordCountDriver.class);

        job.setMapperClass(WordCountMap.class);
        job.setReducerClass(WordCountReduce.class);

        //ָ��mapper���������
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //ָ��reduce�������
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //ָ�������ļ���λ��
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        //ָ������ļ���λ��
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean flag = job.waitForCompletion(true);
        System.exit(flag?0:1);
    }
}
