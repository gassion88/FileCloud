package com.gassion.filecloudbackend.common.mapper;

public interface Mapper <D, S> {

    D map(S source);

}
