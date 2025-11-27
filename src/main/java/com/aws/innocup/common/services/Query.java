package com.aws.innocup.common.services;

public interface Query<I, O> {

    O execute(I input);

}
