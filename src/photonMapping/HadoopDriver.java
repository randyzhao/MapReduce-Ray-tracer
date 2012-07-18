
package photonMapping;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import photonMapping.RayTracerMapReduce.RayTracerMapper;
import photonMapping.RayTracerMapReduce.RayTracerReducer;

public class HadoopDriver {

    public static void main(String[] args) throws Exception {
        Configuration conf1 = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf1, args).getRemainingArgs();
        if (otherArgs.length != 2) {
            System.err.println("Usage: <in> <out>");
            System.exit(2);
        }

        Job job1 = new Job(conf1, "JOB1");
        job1.setJarByClass(HadoopDriver.class);
        job1.setMapperClass(RayTracerMapper.class);
        job1.setReducerClass(RayTracerReducer.class);
        job1.setMapOutputKeyClass(Vector.class);
        job1.setMapOutputValueClass(PhotonHitInformation.class);
        job1.setOutputKeyClass(Vector.class);
        job1.setOutputValueClass(PhotonHitInformation.class);
        FileInputFormat.setInputPaths(job1, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job1, new Path("output/xxx"));
        job1.waitForCompletion(true);
    }
}
