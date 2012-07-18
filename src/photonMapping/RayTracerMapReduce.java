
package photonMapping;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class RayTracerMapReduce {
    public static class RayTracerMapper extends
            Mapper<Object, PhotonInformation, Vector, PhotonHitInformation> {
        IPhotonCaster photonCaster;

        public void map(Object key, PhotonInformation value, Context context) throws IOException,
                InterruptedException {

        }

        public void setup(Context context) throws IOException, InterruptedException {
            // photonCaster;
        }
    }

    public static class RayTracerReducer extends
            Reducer<Vector, PhotonHitInformation, Vector, PhotonHitInformation> {
        public void reduce(Vector key, Iterable<PhotonHitInformation> values, Context context)
                throws IOException, InterruptedException {

        }
    }
}
