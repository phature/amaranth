package phature.amaranth.simple.framework.controller.tracer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.controller.entity.Trace;
import phature.amaranth.simple.framework.utility.exchange.JsonExchanger;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认追溯器类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-15
 */
public class DefaultTracer extends AbstractTracer {
    private final static Logger logger = LoggerFactory.getLogger(DefaultTracer.class);

    @Override
    public void run() {
        Trace trace = getTrace();
        if (null != trace) {
            List<SerializationFeature> serializationFeatures = new ArrayList<>();
            serializationFeatures.add(SerializationFeature.INDENT_OUTPUT);
            List<DeserializationFeature> deserializationFeatures = new ArrayList<>();
            JsonExchanger jsonExchanger = new JsonExchanger(ConfigurationVariate.getDateFormat(), serializationFeatures, deserializationFeatures);
            String message = jsonExchanger.serialize(Trace.class, trace);
            logger.trace(message);
        }
    }
}
