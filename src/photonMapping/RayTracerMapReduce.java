
package photonMapping;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class RayTracerMapReduce {
    public static class RayTracerMapper extends
            Mapper<Object, Photon, Vector, PhotonHitInfo> {
        IPhotonCaster photonCaster;

        public void map(Object key, Photon value, Context context) throws IOException,
                InterruptedException {

        }

        public void setup(Context context) throws IOException, InterruptedException {
            // photonCaster;
        }
    }

    public static class RayTracerReducer extends
            Reducer<Vector, PhotonHitInfo, Vector, PhotonHitInfo> {
        public void reduce(Vector key, Iterable<PhotonHitInfo> values, Context context)
                throws IOException, InterruptedException {

        }
    }
}
