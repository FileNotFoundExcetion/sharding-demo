package com.sharding.builder;

import com.sharding.entity.ActivityInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Builder<T> {
    private final Supplier<T> constructor;

    private final List<Consumer<T>> consumers = new ArrayList<>();

    public Builder(Supplier<T> constructor) {
        this.constructor = constructor;
    }

    public static <T> Builder<T> builder(Supplier<T> constructor) {
        return new Builder<>(constructor);
    }

    public <V> Builder<T> with(FieldInject<T, V> consumer, V p1) {
        Consumer<T> c = instance -> consumer.accept(instance, p1);
        consumers.add(c);
        return this;
    }

    public T build() {
        T t = constructor.get();
        consumers.forEach(field -> field.accept(t));
        return t;
    }

    @FunctionalInterface
    public interface FieldInject<T, P1> {
        void accept(T t1, P1 p1);
    }

    public static void main(String[] args) {
        ActivityInfo activityInfo = Builder.
                 builder(ActivityInfo::new)
                .with(ActivityInfo::setActivityId, 1)
                .with(ActivityInfo::setActivityName,"xxxx")
                .build();
        System.out.println(activityInfo);

    }
}
