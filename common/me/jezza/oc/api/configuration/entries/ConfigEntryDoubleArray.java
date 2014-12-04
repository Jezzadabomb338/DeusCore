package me.jezza.oc.api.configuration.entries;

import me.jezza.oc.api.configuration.Config.ConfigDoubleArray;
import me.jezza.oc.api.configuration.ConfigEntry;
import net.minecraftforge.common.config.Configuration;

public class ConfigEntryDoubleArray extends ConfigEntry<ConfigDoubleArray, double[]> {
    @Override
    public Object processAnnotation(Configuration config, String fieldName, ConfigDoubleArray annotation, double[] defaultValues) {
        String comment = processComment(annotation.comment());
        return config.get(annotation.category(), fieldName, defaultValues, comment, annotation.minValue(), annotation.maxValue(), annotation.isListLengthFixed(), annotation.maxListLength()).getDoubleList();
    }
}
