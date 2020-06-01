package me.buck.bigbrother.test;

import android.content.Intent;

import me.buck.receiver.annotation.LocalAction;

public class TestReceiver {

    @LocalAction("action-1")
    public void ac(Intent intent) {

    }
}
