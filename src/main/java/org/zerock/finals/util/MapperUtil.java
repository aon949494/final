package org.zerock.finals.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;
    MapperUtil(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public ModelMapper get(){
        return modelMapper;
    }
}
