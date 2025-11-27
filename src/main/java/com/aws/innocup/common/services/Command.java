package com.aws.innocup.common.services;

public interface Command<I, O> {

    O execute(I input);

}
