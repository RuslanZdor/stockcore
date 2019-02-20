import com.tensorflow.constant.MathOperations;
import com.tensorflow.constant.Optimazers;
import org.tensorflow.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.util.Iterator;

public class TensorTest {

    public static String OPERATION_ATTR_TYPE = "dtype";
    public static String OPERATION_ATTR_VALUE = "value";

    public static void main(String[] args) throws Exception {
        try (Graph g = new Graph()) {
            final String value = "Hello from " + TensorFlow.version();

            float[] arr1 = {-2.2f, 1};
            float[] arr2 = {2, 2};
            Tensor t1 = Tensor.create(arr1);

            Output<Integer> c1 = g.opBuilder(MathOperations.OPERATION_TYPE_CONST, "C1")
                    .setAttr(OPERATION_ATTR_TYPE, DataType.FLOAT)
                    .setAttr(OPERATION_ATTR_VALUE, t1)
                    .build()
                    .output(0);

            g.opBuilder(MathOperations.OPERATION_TYPE_CONST, "MyConst").addInput(c1).build();

            g.opBuilder(Optimazers.GRADIENT_DESCENT, "Test").setAttr("learning_rate", 0.1f).build();

            // Execute the "MyConst" operation in a Session.
            try (Session s = new Session(g);
                Tensor output = s.runner().fetch("MyConst").run().get(0)) {
                FloatBuffer buffer = FloatBuffer.allocate(2);
                output.writeTo(buffer);
                for (float val : buffer.array()) {
                    System.out.print(val);
                }
            }
        }
    }
}
