package phature.amaranth.simple.framework.utility.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.utility.StringHandler;

import java.text.DateFormat;
import java.util.List;

/**
 * JSON处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-17
 */
public class JsonExchanger implements Exchanger {
    private final static Logger logger = LoggerFactory.getLogger(JsonExchanger.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <Value> String serialize(Class<Value> valueClass, Value value) {
        String result = null;

        if (null != value) {
            try {
                result = objectMapper.writeValueAsString(value);
            } catch (JsonProcessingException exception) {
                logger.error(exception.getMessage(), exception);
            }
        }

        return result;
    }

    @Override
    public <Value> Value deserialize(Class<Value> valueClass, String text) {
        Value result = null;

        if (!StringHandler.empty(text)) {
            try {
                result = objectMapper.readValue(text, valueClass);
            } catch (JsonProcessingException exception) {
                logger.error(exception.getMessage(), exception);
            }
        }

        return result;
    }

    /**
     * 构造器
     */
    public JsonExchanger() {
    }

    /**
     * 构造器
     *
     * @param dateFormat 时间格式
     */
    public JsonExchanger(DateFormat dateFormat) {
        if (null != dateFormat) {
            objectMapper.setDateFormat(dateFormat);
        }
    }

    /**
     * 构造器
     *
     * @param dateFormat              时间格式
     * @param serializationFeatures   序列化功能
     * @param deserializationFeatures 反系列化功能
     */
    public JsonExchanger(DateFormat dateFormat, List<SerializationFeature> serializationFeatures, List<DeserializationFeature> deserializationFeatures) {
        if (null != dateFormat) {
            objectMapper.setDateFormat(dateFormat);
        }
        if (null != serializationFeatures) {
            for (SerializationFeature serializationFeature : serializationFeatures) {
                objectMapper.enable(serializationFeature);
            }
        }
        if (null != deserializationFeatures) {
            for (DeserializationFeature deserializationFeature : deserializationFeatures) {
                objectMapper.enable(deserializationFeature);
            }
        }
    }
}
