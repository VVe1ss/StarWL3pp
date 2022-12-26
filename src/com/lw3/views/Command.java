package com.lw3.views;

import lombok.Getter;

import java.util.Scanner;
@Getter
public abstract class Command {

    private final Scanner sc = new Scanner(System.in);
    protected abstract Command execute();
}
