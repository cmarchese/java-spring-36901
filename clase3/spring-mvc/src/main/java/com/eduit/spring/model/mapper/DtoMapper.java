package com.eduit.spring.model.mapper;

import java.util.List;

public interface DtoMapper<I, O> {

    O map(I object);

    List<O> map(List<I> objects);
}
