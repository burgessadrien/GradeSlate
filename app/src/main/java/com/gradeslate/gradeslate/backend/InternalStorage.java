package com.gradeslate.gradeslate.backend;

import android.content.Context;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class InternalStorage {
    private InternalStorage() {
    }

    public static void writeObject(Context context, String key, Object object) throws IOException {
        FileOutputStream fos = context.openFileOutput(key, 0);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        fos.close();
    }

    public static Object readObject(Context context, String key) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(context.openFileInput(key)).readObject();
    }
}
