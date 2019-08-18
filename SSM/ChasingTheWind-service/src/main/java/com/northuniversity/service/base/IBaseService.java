package com.northuniversity.service.base;

public interface IBaseService<T> {
    public T  update(T t);
    public T  insert(T t);
}
